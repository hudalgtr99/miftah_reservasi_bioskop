package com.example.reservasibioskop.service.impl;

import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.repository.UserRepository;
import com.example.reservasibioskop.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
//import java.time.LocalDateTime;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(Long id, UserEntity userEntity) {
        UserEntity result = findById(id);
        if (result != null) {
            result.setUsername(userEntity.getUsername());
            result.setEmail(userEntity.getEmail());
            result.setPassword(userEntity.getPassword());
//            result.setUpdatedAt(LocalDateTime.now());
            userRepository.save(userEntity);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        UserEntity result = findById(id);
        if (result != null) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> result = userRepository.findById(id);
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
