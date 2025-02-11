package br.com.raulteles.project_devdojo.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CountryTeams {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private LocalDateTime dateTime;

    public CountryTeams(Long id, String name,LocalDateTime dateTime) {
        this.id = id;
        this.dateTime = dateTime;
        this.name = name;
    }

}
