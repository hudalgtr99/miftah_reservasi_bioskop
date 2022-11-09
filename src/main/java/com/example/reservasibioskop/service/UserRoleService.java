package com.example.reservasibioskop.service;

import com.example.reservasibioskop.entity.RoleEntity;
import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.repository.RoleRepository;
import com.example.reservasibioskop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserRoleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        RoleEntity adminRole = new RoleEntity();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        RoleEntity userRole = new RoleEntity();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        UserEntity adminUser = new UserEntity();
        adminUser.setUsername("Miftah");
        adminUser.setEmail(getEncodedPassword("hudalgtr99@gmail.com"));
        adminUser.setPassword("password");
        Set<RoleEntity> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        UserEntity user = new UserEntity();
        user.setUsername("dummy1");
        user.setEmail(getEncodedPassword("dummy1@user"));
        user.setPassword("dummy1");
        Set<RoleEntity> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepository.save(user);
    }

    public UserEntity registerNewUser(UserEntity userEntity) {
        RoleEntity roleEntity = roleRepository.findById("User").get();
        Set<RoleEntity> userRoles = new HashSet<>();
        userRoles.add(roleEntity);
        userEntity.setRole(userRoles);
        userEntity.setPassword(getEncodedPassword(userEntity.getPassword()));

        return userRepository.save(userEntity);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}