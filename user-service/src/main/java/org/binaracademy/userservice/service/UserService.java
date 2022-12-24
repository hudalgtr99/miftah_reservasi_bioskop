package org.binaracademy.userservice.service;

import org.binaracademy.userservice.dto.UserDTO;
import org.binaracademy.userservice.entity.UserEntity;

import java.util.List;

public interface UserService {
    void initRolesAndUser();

    UserEntity create(UserEntity userEntity);
    UserEntity update(String username, UserEntity userEntity);
    UserEntity delete(String username);
    List<UserEntity> findAll();
    UserEntity findById(String username);

    UserDTO mapToDto(UserEntity userEntity);
    UserEntity mapToEntity(UserDTO userDTO);

}