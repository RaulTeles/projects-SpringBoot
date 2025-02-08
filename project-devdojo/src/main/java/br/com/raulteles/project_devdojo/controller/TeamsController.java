package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.mapper.TeamsMapper;
import br.com.raulteles.project_devdojo.controller.request.TeamsPostRequest;
import br.com.raulteles.project_devdojo.controller.request.TeamsPutRequest;
import br.com.raulteles.project_devdojo.controller.response.TeamsGetResponse;
import br.com.raulteles.project_devdojo.controller.services.TeamsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "teams")
public class TeamsController {
    private static final TeamsMapper MAPPER = TeamsMapper.INTANCE;

    private final TeamsService service;

    @Autowired
    public TeamsController(TeamsService service) {
        this.service = service;
    }

    @GetMapping("/pe")
    public ResponseEntity<List<TeamsGetResponse>> listTeams(@RequestParam(required = false) String name){
        var teamGetResponseList = MAPPER.toResponseList(service.findAll(name));
        return ResponseEntity.ok(teamGetResponseList);
    }
    @GetMapping("/pe/filters")
    public ResponseEntity<List<TeamsGetResponse>> listAllPeParamList(@RequestParam(required = false) List<String> name){

        var teams = service.findNames(name);
        var teamGetReponseList = MAPPER.toResponseList(teams);
        return ResponseEntity.ok(teamGetReponseList);
    }

    @GetMapping("/pe/{id}")
    public ResponseEntity<TeamsGetResponse> findById(@PathVariable Long id){
        var teams = service.findById(id);
        var teamGetResponse = MAPPER.toResponse(teams);
        return ResponseEntity.ok().body(teamGetResponse);
    }

    @PostMapping
    public ResponseEntity<TeamsGetResponse> save(@RequestBody TeamsPostRequest teamsPostRequest){

        var teams = MAPPER.toTeams(teamsPostRequest);
        var teamSaved = service.save(teams);
        var getResponse = MAPPER.toResponse(teamSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(getResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody TeamsPutRequest putRequest){

        var teamsUpdate = MAPPER.toTeams(putRequest);
        service.update(teamsUpdate);
        return ResponseEntity.ok().build();
    }

}
