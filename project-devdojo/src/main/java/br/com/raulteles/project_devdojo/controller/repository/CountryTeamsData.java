package br.com.raulteles.project_devdojo.controller.repository;

import br.com.raulteles.project_devdojo.controller.domain.CountryTeams;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryTeamsData {
    private final List<CountryTeams> countryTeams = new ArrayList<>();

    {
        var bra = CountryTeams.builder().id(1L).name("Brazil").dateTime(LocalDateTime.now()).build();
        var arg = CountryTeams.builder().id(2L).name("Argentina").dateTime(LocalDateTime.now()).build();
        var usa = CountryTeams.builder().id(3L).name("United States").dateTime(LocalDateTime.now()).build();
        var bol = CountryTeams.builder().id(4L).name("Bolivia").dateTime(LocalDateTime.now()).build();

        countryTeams.addAll(List.of(bra,arg,usa,bol));
    }

    public List<CountryTeams> getCountryTeams() {
        return countryTeams;
    }
}
