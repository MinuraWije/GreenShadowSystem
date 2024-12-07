package org.example.greenshadowsystem.dto.impl;

import org.example.greenshadowsystem.dto.UserStatus;
import org.example.greenshadowsystem.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserStatus {
    private String email;
    private String password;
    private UserRole userRole;
}
