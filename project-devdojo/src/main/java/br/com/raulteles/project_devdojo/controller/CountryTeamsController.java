package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.domain.CountryTeams;
import br.com.raulteles.project_devdojo.controller.mapper.CountryMapper;
import br.com.raulteles.project_devdojo.controller.request.CountryTeamsPostRequest;
import br.com.raulteles.project_devdojo.controller.response.CountryTeamsGetResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "country")
public class CountryTeamsController {

//    Criando um atributo, do tipo contryMapper para tratar o contrato do dominio
    private static final CountryMapper MAPPER = CountryMapper.INSTANCE;

    @GetMapping("american")
    public ResponseEntity<List<CountryTeamsGetResponse>> listAllCountryTeams(@RequestParam(required = false) String name){

        var countryTeamsResponseList = MAPPER.toResonseList(CountryTeams.getListCountryTeams());

        if(name == null){return ResponseEntity.ok(countryTeamsResponseList);}
        var response = countryTeamsResponseList.stream().filter(c -> c.getName().equalsIgnoreCase(name)).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("american/filters")
    public ResponseEntity<List<CountryTeamsGetResponse>> listAllCountryParamList(@RequestParam(required = false) List<String> name) {

        var teamGetResponseList = MAPPER.toResonseList(CountryTeams.getListCountryTeams());

        if(name == null){return ResponseEntity.ok(teamGetResponseList);}
        var response = teamGetResponseList.stream().filter(c -> name.stream().anyMatch(country -> c.getName().equalsIgnoreCase(country))).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("american/{id}")
    public ResponseEntity<CountryTeamsGetResponse> findById(@PathVariable Long id){

        var countryResponse = CountryTeams.getListCountryTeams().stream().filter(c -> c.getId().equals(id)).findFirst().map(MAPPER::toCountryTeamsGetResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country Team not found"));;
        return ResponseEntity.ok().body(countryResponse);
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

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        var countryTeamsDelete = CountryTeams.getListCountryTeams().stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country Team not found"));

        CountryTeams.getListCountryTeams().remove(countryTeamsDelete);
        return ResponseEntity.noContent().build();
    }
}
