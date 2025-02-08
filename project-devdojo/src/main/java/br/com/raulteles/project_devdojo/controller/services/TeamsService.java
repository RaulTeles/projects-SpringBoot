package br.com.raulteles.project_devdojo.controller.services;

import br.com.raulteles.project_devdojo.controller.domain.Teams;
import br.com.raulteles.project_devdojo.controller.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeamsService {

    private final TeamsRepository repository;

    @Autowired
    public TeamsService(TeamsRepository repository){
        this.repository = repository;
    }

    public List<Teams> findAll(String name){
        return (name == null) ? repository.findAll() : repository.findName(name);
    }

    public List<Teams> findNames(List<String> name){
        return (name == null) ? repository.findAll() : repository.findByNames(name);
    }

    public Teams findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
    }

    public Teams save(Teams teams){
        return repository.save(teams);
    }

    public void delete(Long id){
        repository.delete(findById(id));
    }

    public void update(Teams teams){
        var updateTeams = findById(teams.getId());
        updateTeams.setDateTime(teams.getDateTime());
        repository.update(teams);
    }


}
