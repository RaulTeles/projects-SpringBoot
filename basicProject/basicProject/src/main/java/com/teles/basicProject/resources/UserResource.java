package com.teles.basicProject.resources;

import com.teles.basicProject.entities.User;
import com.teles.basicProject.services.UserServices;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Resource
public class UserResource {

    @Autowired
    private UserServices userServices;

//    Respostas de requisiões webs
    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userServices.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User obj){
        obj = userServices.insertUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getID()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userServices.deleteUser(id);
        //Resposta vazia (Sem corpo)
        return ResponseEntity.noContent().build();
    }
}

