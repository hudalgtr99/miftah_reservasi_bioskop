package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostConstruct
    public void initRoleAndUser() {
        userRoleService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public UserEntity registerNewUser(@RequestBody UserEntity userEntity) {
        return userRoleService.registerNewUser(userEntity);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
