package br.com.raulteles.project_devdojo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
