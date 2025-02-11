package br.com.raulteles.project_devdojo.repository;

import br.com.raulteles.project_devdojo.domain.CountryTeams;
import external.dependecy.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public class CountryTeamsRepository {

    private final CountryTeamsData countryTeamsData;

    @Autowired
    public CountryTeamsRepository(CountryTeamsData countryTeamsData) {
        this.countryTeamsData = countryTeamsData;
    }

    public List<CountryTeams> findAll() {
        return countryTeamsData.getCountryTeams();
    }

    public Optional<CountryTeams> findById(Long id) {
        return countryTeamsData.getCountryTeams().stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public List<CountryTeams> findName(@RequestParam(required = false) String name) {
        return countryTeamsData.getCountryTeams().stream().filter(countryTeams -> countryTeams.getName().equalsIgnoreCase(name)).toList();
    }

    public List<CountryTeams> findBynames(@RequestParam(required = false) List<String> name) {

        return countryTeamsData.getCountryTeams().stream().filter(c -> name.stream().anyMatch(country -> c.getName().equalsIgnoreCase(country))).toList();
    }

    public CountryTeams save(CountryTeams countryTeams) {
        countryTeamsData.getCountryTeams().add(countryTeams);
        return countryTeams;
    }

    public void delete(CountryTeams countryTeams) {
        countryTeamsData.getCountryTeams().remove(countryTeams);
    }

    public void update(CountryTeams countryTeams) {
        delete(countryTeams);
        save(countryTeams);
    }

}
