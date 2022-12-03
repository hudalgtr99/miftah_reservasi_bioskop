package org.binar.isekaibioskop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.binar.isekaibioskop.dto.UserDTO;
import org.binar.isekaibioskop.entity.UserEntity;
import org.binar.isekaibioskop.repository.UserRepository;
import org.binar.isekaibioskop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity create(UserEntity userEntity) {
        UserEntity result = userRepository.save(userEntity);
        return result;
    }

    @Override
    public UserEntity update(String username, UserEntity userEntity) {
        UserEntity result = findById(username);
        if (result != null) {
            result.setEmail(userEntity.getEmail());
            result.setPassword(userEntity.getPassword());
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
        if (result.isPresent()) {
            return result.get();
        }
        return null;
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