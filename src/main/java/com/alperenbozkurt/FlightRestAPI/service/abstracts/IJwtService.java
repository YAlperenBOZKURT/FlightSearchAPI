package com.alperenbozkurt.FlightRestAPI.service.abstracts;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.function.Function;

public interface IJwtService {

    String findUsername(String token);
    <T> T exportToken(java.lang.String token, Function<Claims, T> claimsTFunction);
    Key getKey();
    boolean tokenControl(String jwt, UserDetails userDetails);
    String generateToken(UserDetails user);


}
