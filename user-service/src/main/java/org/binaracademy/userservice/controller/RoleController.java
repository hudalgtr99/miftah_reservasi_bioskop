package org.binaracademy.userservice.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.binaracademy.userservice.entity.Role;
import org.binaracademy.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role){
        return roleService.createNewRole(role);
    }
}