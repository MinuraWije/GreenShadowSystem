package org.example.greenshadowsystem.service;

import org.example.greenshadowsystem.dto.impl.UserDTO;
import org.example.greenshadowsystem.secure.JWTAuthResponse;
import org.example.greenshadowsystem.secure.Signin;

public interface AuthService {
    JWTAuthResponse signIn(Signin signIn);
    JWTAuthResponse signUp(UserDTO userDTO);
    JWTAuthResponse refreshToken(String accessToken);
}
