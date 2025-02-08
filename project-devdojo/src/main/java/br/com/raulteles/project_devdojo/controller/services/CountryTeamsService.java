package br.com.raulteles.project_devdojo.controller.services;

import br.com.raulteles.project_devdojo.controller.domain.CountryTeams;
import br.com.raulteles.project_devdojo.controller.repository.CountryTeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CountryTeamsService {

    private final CountryTeamsRepository repository;

    @Autowired
    public CountryTeamsService(CountryTeamsRepository repository){
        this.repository = repository;
    }

    public List<CountryTeams> findAll(String name){
        return name == null ? repository.findAll() : repository.findName(name);
    }

    public List<CountryTeams> findFilter(List<String> name){
        return name == null ? repository.findAll() : repository.findBynames(name);
    }

    public CountryTeams findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country Team not found"));
    }

    public CountryTeams save(CountryTeams countryTeams){
        return repository.save(countryTeams);
    }

    public void delete(Long id){
        var countryTeams = findById(id);
        repository.delete(countryTeams);
    }

    public void update(CountryTeams countryTeamsUpdate){
        var countryTeams = findById(countryTeamsUpdate.getId());
        countryTeams.setDateTime(countryTeams.getDateTime());
        repository.update(countryTeamsUpdate);
    }


}
