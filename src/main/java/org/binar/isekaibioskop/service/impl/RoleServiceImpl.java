package org.binar.isekaibioskop.service.impl;

import org.binar.isekaibioskop.entity.Role;
import org.binar.isekaibioskop.repository.RoleRepository;
import org.binar.isekaibioskop.service.RoleService;
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
