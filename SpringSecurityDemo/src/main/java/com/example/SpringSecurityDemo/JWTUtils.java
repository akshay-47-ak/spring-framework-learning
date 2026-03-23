package com.example.SpringSecurityDemo;

import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

    private String jwtSecret="";

    private int jwtExpiresMs=172800000;

}
