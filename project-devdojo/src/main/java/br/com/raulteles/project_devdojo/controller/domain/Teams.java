package br.com.raulteles.project_devdojo.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Utilizando uma função da lib do lombook, passando duas annotation para evitar o uso explicito de Getters, Setter e Build
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Teams {
    @EqualsAndHashCode.Include
    private Long id;
    //desserializando uma APi que possui um campo full_name para name
    //@JsonProperty("full_name")
    private String name;
    private LocalDateTime dateTime;

    public Teams(Long id, String name,LocalDateTime dateTime) {
        this.id = id;
        this.dateTime = dateTime;
        this.name = name;
    }

    @Getter
    private static List<Teams> teamsPE = new ArrayList<>();
    static {
        var stz = Teams.builder().id(1L).name("Santa Cruz").dateTime(LocalDateTime.now()).build();
        var spt = Teams.builder().id(2L).name("Sport").dateTime(LocalDateTime.now()).build();
        var nau = Teams.builder().id(3L).name("Nautico").dateTime(LocalDateTime.now()).build();
        var ret = Teams.builder().id(4L).name("Retro").dateTime(LocalDateTime.now()).build();
        teamsPE.addAll(List.of(stz,spt,nau,ret));
    }
}
