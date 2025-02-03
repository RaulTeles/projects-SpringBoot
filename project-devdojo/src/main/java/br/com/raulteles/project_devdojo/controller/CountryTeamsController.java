package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.domain.CountryTeams;
import br.com.raulteles.project_devdojo.controller.mapper.CountryMapper;
import br.com.raulteles.project_devdojo.controller.request.CountryTeamsPostRequest;
import br.com.raulteles.project_devdojo.controller.response.CountryTeamsGetResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "country")
public class CountryTeamsController {

//    Criando um atributo, do tipo contryMapper para tratar o contrato do dominio
    private static final CountryMapper MAPPER = CountryMapper.INSTANCE;

    @GetMapping("american")
    public List<CountryTeams> listAllCountryTeams(@RequestParam(required = false) String name){
        if(name == null){return CountryTeams.getListCountryTeams();}
        return CountryTeams.getListCountryTeams().stream().filter(c -> c.getName().equalsIgnoreCase(name)).toList();
    }
    @GetMapping("american/filters")
    public List<CountryTeams> listAllCountryParamList(@RequestParam(required = false) List<String> name) {
        if(name == null){return CountryTeams.getListCountryTeams();}
        return CountryTeams.getListCountryTeams().stream().filter(c -> name.stream().anyMatch(country -> c.getName().equalsIgnoreCase(country))).toList();
    }
    @GetMapping("american/{id}")
    public CountryTeams findById(@PathVariable Long id){
        return CountryTeams.getListCountryTeams().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public ResponseEntity<CountryTeamsGetResponse> save(@RequestBody CountryTeamsPostRequest countryTeamsPostRequest){
//        Fazendo o mapeamento utilizando o Mapper através da interface Mapper (Mesma coisa que o código comentado a baixo.)
        var countryTeams = MAPPER.toCountryTeams(countryTeamsPostRequest);
        var countryTeamsResponse = MAPPER.toCountryTeamsGetResponse(countryTeams);

//        Enviando as informações da criação de um novo objeto
//        var countryTeams = CountryTeams.builder().id(ThreadLocalRandom.current().nextLong(1,1000)).name(countryTeamsPostRequest.getName()).dateTime(LocalDateTime.now()).build();


//        Coletando o campos necessários dos objetos criados
//        var countryTeamsResponse = CountryTeamsGetResponse.builder().id(countryTeams.getId()).name(countryTeams.getName()).dateTime(LocalDateTime.now()).build();
        CountryTeams.getListCountryTeams().add(countryTeams);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryTeamsResponse);
    }

}
