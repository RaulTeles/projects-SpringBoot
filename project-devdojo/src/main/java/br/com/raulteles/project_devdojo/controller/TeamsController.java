package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.domain.Teams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping(value = "teams")
public class TeamsController {

    @GetMapping("/pe")
    public List<Teams> listTeams(@RequestParam(required = false) String teams){
        if(teams == null){return Teams.getTeamsPE();}
        return Teams.getTeamsPE().stream().filter(t -> t.getName().equalsIgnoreCase(teams)).toList();
    }
    @GetMapping("/pe/filters")
    public List<Teams> listAllPeParamList(@RequestParam(required = false) List<String> teams) {
        if(teams == null){return Teams.getTeamsPE();}
        return Teams.getTeamsPE().stream().filter(t -> teams.stream().anyMatch(team -> t.getName().equalsIgnoreCase(team))).toList();
    }

    @GetMapping("/pe/{id}")
    public Teams findById(@PathVariable Long id){
        return Teams.getTeamsPE().stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public ResponseEntity<Teams> save(@RequestBody Teams teams){
//        log.info("'{}'",teams);
        teams.setId(ThreadLocalRandom.current().nextLong(1,1000));
        Teams.getTeamsPE().add(teams);
        return ResponseEntity.status(HttpStatus.CREATED).body(teams);
    }

}
