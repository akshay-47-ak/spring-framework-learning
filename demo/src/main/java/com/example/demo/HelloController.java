package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloApi(){
        return "Hello World";
    }

    @GetMapping("/getUsers")
    public User getUsers(){
        return new User(1,"Akshay","PADM");
    }


}
