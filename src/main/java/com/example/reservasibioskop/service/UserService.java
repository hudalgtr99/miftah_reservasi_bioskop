package com.example.reservasibioskop.service;

import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity create(UserEntity userEntity);
    UserEntity update(String username, UserEntity userEntity);
    Boolean delete(String username);
    List<UserEntity> findAll();

    UserEntity findById(String username);

    UserDTO mapToDto(UserEntity userEntity);
    UserEntity mapToEntity(UserDTO userDTO);
}
