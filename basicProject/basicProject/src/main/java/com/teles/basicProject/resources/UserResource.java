package com.teles.basicProject.resources;

import com.teles.basicProject.entities.User;
import com.teles.basicProject.services.UserServices;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

