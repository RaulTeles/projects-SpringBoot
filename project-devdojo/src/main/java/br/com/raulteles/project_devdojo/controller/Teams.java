package br.com.raulteles.project_devdojo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teams")
public class Teams {

    private static final List<String> Pernambucanos = List.of("Santa Cruz", "Sport", "Náutico", "Retro");

    @GetMapping(value = "/pe")
    public List<String> listAllPe(){
        return Pernambucanos;
    }

    @GetMapping("/pe/filter")
    public List<String> listAllPeParam(@RequestParam(defaultValue = "") String team){
        return Pernambucanos.stream().filter(t -> t.equalsIgnoreCase(team)).toList();
    }

    @GetMapping("/pe/filters")
    public List<String> listAllPeParamList(@RequestParam(defaultValue = "") List<String> teams) {
        return Pernambucanos.stream().filter(t -> teams.stream().anyMatch(team -> t.equalsIgnoreCase(team))).toList();
    }

    @GetMapping("{team}")
    public String findTeam(@PathVariable String team){
        return Pernambucanos.stream().filter(t -> t.equalsIgnoreCase(team)).findFirst().orElse("");
    }

}
