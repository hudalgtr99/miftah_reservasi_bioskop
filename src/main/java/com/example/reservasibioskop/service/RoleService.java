package com.example.reservasibioskop.service;

import com.example.reservasibioskop.entity.RoleEntity;
import com.example.reservasibioskop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity createNewRole(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }
}
