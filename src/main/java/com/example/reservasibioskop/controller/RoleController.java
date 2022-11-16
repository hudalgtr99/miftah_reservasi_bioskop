//package com.example.reservasibioskop.controller;
//
//import com.example.reservasibioskop.entity.RoleEntity;
//import com.example.reservasibioskop.service.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RoleController {
//
//    @Autowired
//    private RoleService roleService;
//
//    @PostMapping({"/createNewRole"})
//    public RoleEntity createNewRole(@RequestBody RoleEntity roleEntity) {
//        return roleService.createNewRole(roleEntity);
//    }
//}