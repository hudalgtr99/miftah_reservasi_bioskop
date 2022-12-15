package org.binar.isekaibioskop.service.impl;

import org.binar.isekaibioskop.dto.UserDTO;
import org.binar.isekaibioskop.entity.Role;
import org.binar.isekaibioskop.entity.UserEntity;
import org.binar.isekaibioskop.exception.DataNotFoundException;
import org.binar.isekaibioskop.repository.RoleRepository;
import org.binar.isekaibioskop.repository.UserRepository;
import org.binar.isekaibioskop.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final String ENTITY = "userEntity";
    private final Logger log =  LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity registerNewUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created");
        roleRepository.save(userRole);

        UserEntity adminUser = new UserEntity();
        adminUser.setUsername("miftah01");
        adminUser.setEmail("miftah01@mail");
        adminUser.setPassword(getEncodedPassword("miftah01@pass"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        UserEntity user = new UserEntity();
        user.setUsername("dummy01");
        user.setEmail("dummy01@mail");
        user.setPassword(getEncodedPassword("dummy01@pass"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepository.save(user);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        log.info("Has successfully created user data!");
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(String username, UserEntity userEntity) {
        UserEntity result = userRepository.findById(username)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", username);
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
    public UserEntity delete(String username) {
        UserEntity result = userRepository.findById(username)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", username);
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
    public UserEntity findById(String username) {
        UserEntity userEntity = userRepository.findById(username)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", username);
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        log.info("Has successfully found user data from id " + username);
        return userEntity;
    }

//    @Override
//    public UserEntity findByUsername(String username) {
//        UserEntity byUsername = userRepository.findByUsername(username);
//        if (byUsername != null) {
//            log.info("Has successfully found user data from code " + username);
//            return byUsername;
//        }
//        DataNotFoundException exception = new DataNotFoundException(ENTITY, "username", username);
//        log.info("Error");
//        exception.setApiResponse();
//        throw exception;
//    }

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