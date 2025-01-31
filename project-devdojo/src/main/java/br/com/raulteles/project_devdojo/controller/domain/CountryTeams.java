package br.com.raulteles.project_devdojo.controller.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class CountryTeams {
    private Long id;
    private String name;
    private LocalDateTime dateTime;

    public CountryTeams(Long id, String name,LocalDateTime dateTime) {
        this.id = id;
        this.dateTime = dateTime;
        this.name = name;
    }

    @Getter
    private static List<CountryTeams> listCountryTeams = new ArrayList<>();
    static {
        var bra = CountryTeams.builder().id(1L).name("Brazil").dateTime(LocalDateTime.now()).build();
        var arg = CountryTeams.builder().id(2L).name("Argentina").dateTime(LocalDateTime.now()).build();
        var usa = CountryTeams.builder().id(3L).name("United States").dateTime(LocalDateTime.now()).build();
        var bol = CountryTeams.builder().id(4L).name("Bolivia").dateTime(LocalDateTime.now()).build();

        listCountryTeams.addAll(List.of(bra,arg,usa,bol));
    }


}
