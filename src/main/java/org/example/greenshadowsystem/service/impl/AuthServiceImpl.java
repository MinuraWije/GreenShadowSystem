package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.dao.UserDao;
import org.example.greenshadowsystem.dto.impl.UserDTO;
import org.example.greenshadowsystem.entity.impl.UserEntity;
import org.example.greenshadowsystem.exception.UserNotFoundException;
import org.example.greenshadowsystem.secure.JWTAuthResponse;
import org.example.greenshadowsystem.secure.Signin;
import org.example.greenshadowsystem.service.AuthService;
import org.example.greenshadowsystem.service.JWTService;
import org.example.greenshadowsystem.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserDao userDao;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JWTAuthResponse signIn(Signin signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        var user = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        var generateToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        //save user
        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        //generate the token and return it
        var generatedToken = jwtService.generateToken(savedUser);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        //extract username
        var username = jwtService.extractUsername(accessToken);
        //check the user availability in the DB
        var findUser = userDao.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.refreshToken(findUser);
        return JWTAuthResponse.builder().token(refreshToken).build();
    }
}
