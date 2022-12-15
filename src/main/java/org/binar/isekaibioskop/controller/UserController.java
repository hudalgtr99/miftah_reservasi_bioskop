package org.binar.isekaibioskop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.UserDTO;
import org.binar.isekaibioskop.entity.UserEntity;
import org.binar.isekaibioskop.repository.UserRepository;
import org.binar.isekaibioskop.response.ResponseMessage;
import org.binar.isekaibioskop.service.UserService;
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

    @PostMapping("/registerNewUser")
    public UserEntity registerNewUser(@RequestBody UserEntity userEntity){
        return userService.registerNewUser(userEntity);
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

    @Operation(summary = "Create an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
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

    @Operation(summary = "Update an user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
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

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
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

    @Operation(summary = "Get an user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
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

//    @GetMapping("/getByUsername/{username}")
//    public ResponseEntity<ResponseMessage> findByUsername(@PathVariable("username") String username) {
//        UserEntity userEntity = userService.findByUsername(username);
//        UserDTO result = userService.mapToDto(userEntity);
//        ResponseMessage responseMessage = new ResponseMessage(
//                Boolean.TRUE,
//                "successfully retrieved user with username : " + userEntity.getUsername(),
//                result
//        );
//
//        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
//    }

    @Operation(summary = "Delete an user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
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