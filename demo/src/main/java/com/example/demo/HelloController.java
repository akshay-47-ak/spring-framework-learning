package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String helloApi(){
        return "Hello World";
    }

   // @GetMapping("/getUsers")
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public User getUsers(){
        return new User(1,"Akshay","PADM");
    }


}
