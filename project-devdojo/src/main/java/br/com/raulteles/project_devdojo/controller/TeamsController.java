package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.domain.Teams;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
