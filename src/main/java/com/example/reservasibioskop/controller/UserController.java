package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO request){
        final UserEntity userEntity = userService.mapToEntity(request);
        final UserEntity result = userService.create(userEntity);
        return userService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO request){
        final UserEntity userEntity = userService.mapToEntity(request);
        final UserEntity result = userService.update(id, userEntity);
        return userService.mapToDto(result);
    }
    
    @GetMapping("/all")
    public List<UserDTO> findAll(){
        return userService.findAll().stream().map(userService::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
