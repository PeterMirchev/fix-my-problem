package com.fixmyproblem.project.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {


    public String extractUsername(String token) {

        return  null;
    }

    private Claims extractAllClaims(String token) {

        return null;
    }
}
