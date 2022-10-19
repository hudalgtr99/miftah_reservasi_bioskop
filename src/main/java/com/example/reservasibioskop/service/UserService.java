package com.example.reservasibioskop.service;

import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity create(UserEntity userEntity);
    UserEntity update(Long id, UserEntity userEntity);
    Boolean delete(Long id);
    List<UserEntity> findAll();

    UserEntity findById(Long id);

    UserDTO mapToDto(UserEntity userEntity);
    UserEntity mapToEntity(UserDTO userDTO);
}
