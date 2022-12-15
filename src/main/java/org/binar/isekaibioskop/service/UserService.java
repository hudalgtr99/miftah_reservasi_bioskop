package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.dto.UserDTO;
import org.binar.isekaibioskop.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity registerNewUser(UserEntity userEntity);
    void initRolesAndUser();

    UserEntity create(UserEntity userEntity);
    UserEntity update(String username, UserEntity userEntity);
    UserEntity delete(String username);
    List<UserEntity> findAll();
    UserEntity findById(String username);
//    UserEntity findByUsername(String username);

    UserDTO mapToDto(UserEntity userEntity);
    UserEntity mapToEntity(UserDTO userDTO);

}