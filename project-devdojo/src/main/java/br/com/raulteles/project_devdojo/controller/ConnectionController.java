package br.com.raulteles.project_devdojo.controller;

import external.dependecy.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("connections")
@Slf4j
@RequiredArgsConstructor
public class ConnectionController {
    private final Connection connections;

    @GetMapping
    public ResponseEntity<Connection> getconnection(){
        return ResponseEntity.ok(connections);
    }
}
