package com.example.SpringSecurityDemo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTUtils {

    private String jwtSecret="";

    private int jwtExpiresMs=172800000;

    public String getJwtFromHeader(){
        return "";
    }

    public String generateTokenFromUsername(String userName){
        return Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime()+jwtExpiresMs))
                .signWith(key())
                .compact()
                ;
    }

    public boolean validateJwtToken(){
        return true;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

}
