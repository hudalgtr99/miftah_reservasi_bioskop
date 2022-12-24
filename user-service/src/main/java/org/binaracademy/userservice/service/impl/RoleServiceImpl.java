package org.binaracademy.userservice.service.impl;

import org.binaracademy.userservice.entity.Role;
import org.binaracademy.userservice.repository.RoleRepository;
import org.binaracademy.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}