package com.example.SpringSecurityDemo;

import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

    private String jwtSecret="";

    private int jwtExpiresMs=172800000;

    public String getJwtFromHeader(){
        return "";
    }

    public String generateTockenFromUsername(){
        return "";
    }

    public boolean validateJwtTocken(){
        return true;
    }

}
