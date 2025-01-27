package br.com.raulteles.project_devdojo.controller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//Utilizando uma função do lombook, passando duas annotation para evitar o uso explicito de construtores e Getters
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Teams {
    private Long id;
    private String name;

    public static List<Teams> getTeams(){
        return List.of(new Teams(1L,"Santa Cruz"),
                new Teams(2L, "Sport"),
                new Teams(3L, "Nautico"),
                new Teams(4L, "Retro"));
    }
}
