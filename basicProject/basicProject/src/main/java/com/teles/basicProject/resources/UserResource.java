package com.teles.basicProject.resources;

import com.teles.basicProject.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

//    Respostas de requisiões webs
    @GetMapping()
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Teles","telesraul@gmail.com","81986614229","1234");
        return ResponseEntity.ok().body(u);
    }
}

