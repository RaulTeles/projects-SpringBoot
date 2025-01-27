package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.domain.Teams;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teams")
public class TeamsController {

    @GetMapping("/pe")
    public List<Teams> listTeams(@RequestParam(required = false) String name){
        if(name == null){return Teams.getTeams();}
        return Teams.getTeams().stream().filter(t -> t.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("/pe/{id}")
    public Teams findById(@PathVariable Long id){
        return Teams.getTeams().stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }


}
