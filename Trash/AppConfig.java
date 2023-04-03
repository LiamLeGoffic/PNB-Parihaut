package com.pnbparihaut.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.validity}")
    private Long jwtValidity;

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil(jwtSecret, jwtValidity);
    }
}
