package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO request){
        final UserEntity userEntity = userService.mapToEntity(request);
        final UserEntity result = userService.create(userEntity);
        return userService.mapToDto(result);
    }

    @PutMapping("/update/{username}")
    public UserDTO update(@PathVariable String username, @RequestBody UserDTO request){
        final UserEntity userEntity = userService.mapToEntity(request);
        final UserEntity result = userService.update(username, userEntity);
        return userService.mapToDto(result);
    }
    
    @GetMapping("/all")
    public List<UserDTO> findAll(){
        return userService.findAll().stream().map(userService::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{username}")
    public Boolean delete(@PathVariable String username){
        return userService.delete(username);
    }
}
