package br.com.raulteles.project_devdojo.controller.repository;

import br.com.raulteles.project_devdojo.controller.domain.CountryTeams;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CountryTeamsRepository {

    private static final List<CountryTeams> COUNTRY_TEAMS = new ArrayList<>();

    static {
        var bra = CountryTeams.builder().id(1L).name("Brazil").dateTime(LocalDateTime.now()).build();
        var arg = CountryTeams.builder().id(2L).name("Argentina").dateTime(LocalDateTime.now()).build();
        var usa = CountryTeams.builder().id(3L).name("United States").dateTime(LocalDateTime.now()).build();
        var bol = CountryTeams.builder().id(4L).name("Bolivia").dateTime(LocalDateTime.now()).build();

        COUNTRY_TEAMS.addAll(List.of(bra,arg,usa,bol));
    }

    public List<CountryTeams> findAll(){
        return COUNTRY_TEAMS;
    }

    public Optional<CountryTeams> findById(Long id){
        return COUNTRY_TEAMS.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public List<CountryTeams> findName(@RequestParam(required = false) String name){
        return COUNTRY_TEAMS.stream().filter(countryTeams -> countryTeams.getName().equalsIgnoreCase(name)).toList();
    }

    public List<CountryTeams> findBynames(@RequestParam(required = false) List<String> name){

        return COUNTRY_TEAMS.stream().filter(c -> name.stream().anyMatch(country -> c.getName().equalsIgnoreCase(country))).toList();
    }

    public CountryTeams save(CountryTeams countryTeams){
        COUNTRY_TEAMS.add(countryTeams);
        return countryTeams;
    }

    public void delete(CountryTeams countryTeams){
        COUNTRY_TEAMS.remove(countryTeams);
    }

    public void update(CountryTeams countryTeams){
        delete(countryTeams);
        save(countryTeams);
    }

}
