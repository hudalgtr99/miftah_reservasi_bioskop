package org.binaracademy.userservice.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.binaracademy.userservice.dto.UserDTO;
import org.binaracademy.userservice.entity.UserEntity;
import org.binaracademy.userservice.repository.UserRepository;
import org.binaracademy.userservice.response.ResponseMessage;
import org.binaracademy.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accesible to admin";
    }

    @GetMapping("/forUser" )
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accesible to the user";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody UserDTO userDTO){
        UserEntity request = userService.mapToEntity(userDTO);
        UserEntity userEntity = userService.create(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add user with id: " + userEntity.getUsername()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<ResponseMessage> update(@PathVariable String username, @RequestBody UserDTO userDTO) {
        UserEntity request = userService.mapToEntity(userDTO);
        UserEntity userEntity = userService.update(username, request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully updated user with id : " + userEntity.getUsername()
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<ResponseMessage> findAll(){
        List<UserDTO> result = userService.findAll().stream().map(userEntity -> userService.mapToDto(userEntity))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved all user",
                result);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseMessage> findById(@PathVariable("id") String username){

        UserEntity userEntity = userService.findById(username);
        UserDTO result = userService.mapToDto(userEntity);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved user with id : " + userEntity.getUsername(), result
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("delete/{username}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable String username){
        UserEntity result = userService.delete(username);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully deleted user with id : " + result.getUsername()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}