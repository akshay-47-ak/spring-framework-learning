package com.example.SpringSecurityDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String SayHello(){
        return "Hello";
    }

    @GetMapping("/admin/hello")
    public String SayAdminHello(){
        return "Hello, ADMIN";
    }

    @GetMapping("/user/hello")
    public String SayUserHello(){
        return "Hello ,USER";
    }


}
