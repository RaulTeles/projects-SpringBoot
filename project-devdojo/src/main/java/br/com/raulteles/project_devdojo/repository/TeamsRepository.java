package br.com.raulteles.project_devdojo.repository;

import br.com.raulteles.project_devdojo.domain.Teams;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamsRepository {

    private static final List<Teams> TEAMS_LIST = new ArrayList<>();

    static {
        var stz = Teams.builder().id(1L).name("Santa Cruz").dateTime(LocalDateTime.now()).build();
        var spt = Teams.builder().id(2L).name("Sport").dateTime(LocalDateTime.now()).build();
        var nau = Teams.builder().id(3L).name("Nautico").dateTime(LocalDateTime.now()).build();
        var ret = Teams.builder().id(4L).name("Retro").dateTime(LocalDateTime.now()).build();
        TEAMS_LIST.addAll(List.of(stz,spt,nau,ret));
    }

    public List<Teams> findAll(){
        return TEAMS_LIST;
    }

    public List<Teams> findName(String name){
        return TEAMS_LIST.stream().filter(teams -> teams.getName().equalsIgnoreCase(name)).toList();
    }

    public List<Teams> findByNames(List<String> name){
        return TEAMS_LIST.stream().filter(t -> name.stream().anyMatch(team -> t.getName().equalsIgnoreCase(team))).toList();
    }

    public Optional<Teams> findById(Long id){
        return TEAMS_LIST.stream().filter(teams -> teams.getId().equals(id)).findFirst();
    }

    public Teams save(Teams teams){
        TEAMS_LIST.add(teams);
        return teams;
    }

    public void delete(Teams teams){
        TEAMS_LIST.remove(teams);
    }

    public void update(Teams teams){
        delete(teams);
        save(teams);
    }




}
