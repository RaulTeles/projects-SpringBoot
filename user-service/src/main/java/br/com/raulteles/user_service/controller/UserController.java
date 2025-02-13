package br.com.raulteles.user_service.controller;


import br.com.raulteles.user_service.domain.User;
import br.com.raulteles.user_service.mapper.UserMapper;
import br.com.raulteles.user_service.responses.UserGetResponse;
import br.com.raulteles.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private final UserMapper MAPPER = UserMapper.INSTANCE;

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserGetResponse>> findAll(String firstName) {
        var users = service.findAll(firstName);
        var userGetResponseList = MAPPER.toUserGetResponseList(users);

        return ResponseEntity.ok(userGetResponseList);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody User user) {
        service.update(user);
        return ResponseEntity.ok().build();
    }

}
