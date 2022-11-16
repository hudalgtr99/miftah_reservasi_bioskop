package com.example.reservasibioskop.service.impl;

import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.repository.UserRepository;
import com.example.reservasibioskop.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
//import java.time.LocalDateTime;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(String username, UserEntity userEntity) {
        UserEntity result = findById(username);
        if (result != null) {
            result.setEmail(userEntity.getEmail());
            result.setPassword(userEntity.getPassword());
//            result.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(String username) {
        UserEntity result = findById(username);
        if (result != null) {
            userRepository.deleteById(username);
            return true;
        }
        return false;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(String username) {
        Optional<UserEntity> result = userRepository.findById(username);
        return result.orElse(null);
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public UserDTO mapToDto(UserEntity userEntity) {
        return mapper.convertValue(userEntity, UserDTO.class);
    }

    @Override
    public UserEntity mapToEntity(UserDTO userDTO) {
        return mapper.convertValue(userDTO, UserEntity.class);
    }
}
