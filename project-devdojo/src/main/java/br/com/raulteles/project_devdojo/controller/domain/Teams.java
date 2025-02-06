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

}
