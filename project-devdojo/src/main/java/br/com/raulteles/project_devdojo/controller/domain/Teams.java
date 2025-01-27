package br.com.raulteles.project_devdojo.controller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//Utilizando uma função do lombook, passando duas annotation para evitar o uso explicito de construtores e Getters
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Teams {
    private Long id;
    private String name;
    private static List<Teams> teams = new ArrayList<>();
    static {
        var stz = new Teams(1L,"Santa Cruz");
        var spt = new Teams(2L, "Sport");
        var nau = new Teams(3L, "Nautico");
        var ret = new Teams(4L, "Retro");
        teams.addAll(List.of(stz,spt,nau,ret));
    }

    public static List<Teams> getTeamsPE(){
        return teams;
    }
}
