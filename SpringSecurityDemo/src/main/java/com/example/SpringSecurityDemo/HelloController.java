package com.example.SpringSecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtils jwtUtils;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
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

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = null;
        try{
        authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "Could Not Authenticate";
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
             UserDetails userDetails = (UserDetails) authentication.getPrincipal();

             String jwtToken = jwtUtils.generateTokenFromUsername(userDetails.getUsername());

             return jwtToken;
    }


}
