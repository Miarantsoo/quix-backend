package com.project.quix.security;

import com.project.quix.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@Configuration
public class JwtUtilConfig {

    private final Key jwtKey;

    public JwtUtilConfig(Key jwtKey) {
        this.jwtKey = jwtKey;
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(jwtKey);
    }
}
