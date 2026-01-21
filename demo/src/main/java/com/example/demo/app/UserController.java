package com.example.demo.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    Map<Integer,User> userDb = new HashMap<>();

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){

        System.out.println(user.getProject());
        userDb.putIfAbsent(user.getId(),user);
        // return ResponseEntity.status(HttpStatus.CREATED).body(user);
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        if(userDb.containsKey(user.getId()))
            userDb.put(user.getId(),user);
        return "User Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        userDb.remove(id);
        return  "User Deleted";
    }

    @GetMapping
    public List<User> getUsers(){

        return new ArrayList<>(userDb.values());
    }

}
