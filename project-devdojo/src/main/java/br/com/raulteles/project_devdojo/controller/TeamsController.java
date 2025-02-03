package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.domain.Teams;
import br.com.raulteles.project_devdojo.controller.mapper.TeamsMapper;
import br.com.raulteles.project_devdojo.controller.request.TeamsPostRequest;
import br.com.raulteles.project_devdojo.controller.response.TeamsGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping(value = "teams")
public class TeamsController {

    private static final TeamsMapper MAPPER = TeamsMapper.INTANCE;

    @GetMapping("/pe")
    public ResponseEntity<List<TeamsGetResponse>> listTeams(@RequestParam(required = false) String teams){

        var teamGetResponseList = MAPPER.toResponseList(Teams.getTeamsPE());
        if(teams == null){return ResponseEntity.ok(teamGetResponseList);}
        var response =  teamGetResponseList.stream().filter(t -> t.getName().equalsIgnoreCase(teams)).toList();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/pe/filters")
    public ResponseEntity<List<TeamsGetResponse>> listAllPeParamList(@RequestParam(required = false) List<String> name){

        var teams = Teams.getTeamsPE();
        var teamGetReponseList = MAPPER.toResponseList(teams);
        if(name == null){
            return ResponseEntity.ok(teamGetReponseList);
        }

        var response =  teamGetReponseList.stream().filter(t -> name.stream().anyMatch(team -> t.getName().equalsIgnoreCase(team))).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pe/{id}")
    public ResponseEntity<TeamsGetResponse> findById(@PathVariable Long id){

        var teamsResponse = Teams.getTeamsPE().stream().filter(t -> t.getId().equals(id)).findFirst().map(MAPPER::toResponse).orElse(null);
        return ResponseEntity.ok().body(teamsResponse);
    }

    @PostMapping
    public ResponseEntity<TeamsGetResponse> save(@RequestBody TeamsPostRequest teamsPostRequest){
        var postRequest = MAPPER.toTeams(teamsPostRequest);
        var getResponse = MAPPER.toResponse(postRequest);

        Teams.getTeamsPE().add(postRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(getResponse);
    }

}
