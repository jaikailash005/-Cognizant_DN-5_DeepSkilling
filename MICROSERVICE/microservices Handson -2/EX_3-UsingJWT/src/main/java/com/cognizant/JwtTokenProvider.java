package com.cognizant;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Autowired
    private JwtConfig jwtConfig;

    public String createToken(String username) {

        return "Dummy JWT Token for " + username;

    }

}