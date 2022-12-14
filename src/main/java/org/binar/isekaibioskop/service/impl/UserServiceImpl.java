package org.binar.isekaibioskop.service.impl;

import org.binar.isekaibioskop.dto.UserDTO;
import org.binar.isekaibioskop.entity.UserEntity;
import org.binar.isekaibioskop.exception.DataNotFoundException;
import org.binar.isekaibioskop.repository.UserRepository;
import org.binar.isekaibioskop.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final String ENTITY = "userEntity";
    private final Logger log =  LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity create(UserEntity userEntity) {
        log.info("Has successfully created user data!");
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(Long id, UserEntity userEntity) {
        UserEntity result = userRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });

        result.setUsername(userEntity.getUsername());
        result.setEmail(userEntity.getEmail());
        result.setPassword(userEntity.getPassword());
        userRepository.save(result);
        log.info("Has successfully updated user data!");
        return result;
    }

    @Override
    public UserEntity delete(Long id) {
        UserEntity result = userRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        userRepository.delete(result);
        log.info("Has successfully deleted user data!");
        return result;
    }

    @Override
    public List<UserEntity> findAll() {
        log.info("Has successfully found all user data!");
        return userRepository.findAll();
    }
    @Override
    public UserEntity findById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        log.info("Has successfully found user data from id " + id);
        return userEntity;
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity byUsername = userRepository.findByUsername(username);
        if (byUsername != null) {
            log.info("Has successfully found user data from code " + username);
            return byUsername;
        }
        DataNotFoundException exception = new DataNotFoundException(ENTITY, "username", username);
        log.info("Error");
        exception.setApiResponse();
        throw exception;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public UserDTO mapToDto(UserEntity userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }

    @Override
    public UserEntity mapToEntity(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntity.class);
    }

}