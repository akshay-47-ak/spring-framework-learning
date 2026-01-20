package com.example.demo.app;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String addUser(@RequestBody User user){
        Map<Integer,User> userDb = new HashMap<>();
        System.out.println(user.getProject());
        userDb.put(user.getId(),user);
        return "User Created";
    }


}
