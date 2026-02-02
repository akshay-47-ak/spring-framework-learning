package com.example.springBootJPA.Controller;

import com.example.springBootJPA.Service.BrotherService;
import com.example.springBootJPA.Entity.Brothers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class BController {

    BrotherService brotherService;

    public BController(BrotherService brotherService){
        this.brotherService = brotherService;
    }

    @PostMapping
    public ResponseEntity<Brothers>createUser(@RequestBody Brothers brothers){
         Brothers user = brotherService.createUser(brothers);
         return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
