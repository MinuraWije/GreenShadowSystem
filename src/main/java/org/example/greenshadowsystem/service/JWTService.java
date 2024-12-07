package org.example.greenshadowsystem.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUsername(String token);
    String generateToken(UserDetails user);
    boolean validateToken(String token, UserDetails user);
    String refreshToken(UserDetails userDetails);
}
