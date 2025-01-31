package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.domain.CountryTeams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "country")
public class CountryTeamsController {

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
    public ResponseEntity<CountryTeams> save(@RequestBody CountryTeams countryTeams){
        countryTeams.setId(ThreadLocalRandom.current().nextLong(1,1000));
        CountryTeams.getListCountryTeams().add(countryTeams);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryTeams);
    }

}
