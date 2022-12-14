package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.dto.UserDTO;
import org.binar.isekaibioskop.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity create(UserEntity userEntity);
    UserEntity update(Long id, UserEntity userEntity);
    UserEntity delete(Long id);
    List<UserEntity> findAll();
    UserEntity findById(Long id);
    UserEntity findByUsername(String username);

    UserDTO mapToDto(UserEntity userEntity);
    UserEntity mapToEntity(UserDTO userDTO);

}