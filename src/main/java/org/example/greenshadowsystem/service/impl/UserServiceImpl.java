package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dao.UserDao;
import org.example.greenshadowsystem.dto.UserStatus;
import org.example.greenshadowsystem.dto.impl.UserDTO;
import org.example.greenshadowsystem.entity.impl.UserEntity;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.UserNotFoundException;
import org.example.greenshadowsystem.service.UserService;
import org.example.greenshadowsystem.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveuser(UserDTO userDTO) {
        /*UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        mapping.touserDTO(savedUser);*/
        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        if(savedUser == null){
            throw new DataPersistException("User not saved.");
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> allUsers = userDao.findAll();
        return mapping.asUserDTOList(allUsers);
    }

    @Override
    public UserStatus getUser(String userId) {
        if(userDao.existsById(userId)){
            UserEntity selectedUser = userDao.getReferenceById(userId);
            return mapping.touserDTO(selectedUser);
        }else{
            return new SelectedCustomErrorStatus(2, "User with id "+ userId + "not found.");
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> existedUser = userDao.findById(userId);
        if(!existedUser.isPresent()){
            throw new UserNotFoundException("User with id "+userId+" not found");
        }else {
            userDao.deleteById(userId);
        }
    }

    @Override
    public void updateUser(String userID, UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDao.findById(userID);
        if(tmpUser.isPresent()){
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
        }
    }

    @Override
    public UserDetailsService userDetailsService() {
        return userName ->
                userDao.findByEmail(userName)
                        .orElseThrow(()->new UserNotFoundException("User not found"));
    }
}
