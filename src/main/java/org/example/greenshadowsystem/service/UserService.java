package org.example.greenshadowsystem.service;


import org.example.greenshadowsystem.dto.UserStatus;
import org.example.greenshadowsystem.dto.impl.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void saveuser(UserDTO userDTO);
    List<UserDTO> getAllUser();
    UserStatus getUser(String userDTO);
    void deleteUser(String userId);
    void updateUser(String userID,UserDTO userDTO);
    UserDetailsService userDetailsService();
}
