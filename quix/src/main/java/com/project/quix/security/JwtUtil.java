package com.project.quix.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key;

    @Autowired
    public JwtUtil(Key key) {
        this.key = key;
    }

    public String generateToken(String email) {
        Date expirationDate = new Date(System.currentTimeMillis() + 60 * 60 * 8 * 1000);
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public Claims validateToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Date expirationDate = claims.getExpiration();
        System.out.println("Token expires at: " + expirationDate);

        return claims;
    }
}
