package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.mapper.CountryMapper;
import br.com.raulteles.project_devdojo.request.CountryTeamsPostRequest;
import br.com.raulteles.project_devdojo.request.CountryTeamsPutRequest;
import br.com.raulteles.project_devdojo.response.CountryTeamsGetResponse;
import br.com.raulteles.project_devdojo.services.CountryTeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "country")
public class CountryTeamsController {
    //    Criando um atributo, do tipo contryMapper para tratar o contrato do dominio
    private static final CountryMapper MAPPER = CountryMapper.INSTANCE;

    private final CountryTeamsService service;

    @Autowired
    public CountryTeamsController(CountryTeamsService service) {
        this.service = service;
    }

    @GetMapping("american")
    public ResponseEntity<List<CountryTeamsGetResponse>> listAllCountryTeams(@RequestParam(required = false) String name) {

        var response = service.findAll(name);
        var countryTeamsResponseList = MAPPER.toResonseList(response);
        return ResponseEntity.ok(countryTeamsResponseList);
    }

    @GetMapping("american/filters")
    public ResponseEntity<List<CountryTeamsGetResponse>> listAllCountryParamList(@RequestParam(required = false) List<String> name) {

        var response = service.findFilter(name).stream().filter(c -> name.stream().anyMatch(country -> c.getName().equalsIgnoreCase(country))).toList();
        var teamGetResponseList = MAPPER.toResonseList(response);

        return ResponseEntity.ok(teamGetResponseList);
    }

    @GetMapping("american/{id}")
    public ResponseEntity<CountryTeamsGetResponse> findById(@PathVariable Long id) {

        var countryTeams = service.findById(id);

        var countryTeamsGetResponse = MAPPER.toCountryTeamsGetResponse(countryTeams);

        return ResponseEntity.ok().body(countryTeamsGetResponse);
    }

    @PostMapping
    public ResponseEntity<CountryTeamsGetResponse> save(@RequestBody CountryTeamsPostRequest countryTeamsPostRequest) {

        var countryTeams = MAPPER.toCountryTeams(countryTeamsPostRequest);
        var countrySaved = service.save(countryTeams);
        var countryTeamsGetResponse = MAPPER.toCountryTeamsGetResponse(countrySaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(countryTeamsGetResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CountryTeamsPutRequest putRequest) {

        var upadteCountryTeams = MAPPER.toCountryTeams(putRequest);
        service.update(upadteCountryTeams);

        return ResponseEntity.ok().build();
    }
}
