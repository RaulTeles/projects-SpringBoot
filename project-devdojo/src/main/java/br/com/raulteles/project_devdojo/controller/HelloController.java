package br.com.raulteles.project_devdojo.controller;

import br.com.raulteles.project_devdojo.controller.domain.Teams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RequestMapping
@RestController
@Slf4j
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello World!";
    }

    @PostMapping
    public Long save(@RequestBody Teams teams){
        log.info("'{}'",teams);
        return ThreadLocalRandom.current().nextLong(1,1000);
    }
}
