package com.example.demo.app;

import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    Map<Integer,User> userDb = new HashMap<>();

    @PostMapping
    public String addUser(@RequestBody User user){

        System.out.println(user.getProject());
        userDb.putIfAbsent(user.getId(),user);
        return "User Created";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        if(userDb.containsKey(user.getId()))
            userDb.put(user.getId(),user);
        return "User Updated";
    }

}
