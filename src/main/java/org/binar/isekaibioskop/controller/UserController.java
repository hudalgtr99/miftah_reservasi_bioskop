package org.binar.isekaibioskop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.UserDTO;
import org.binar.isekaibioskop.entity.UserEntity;
import org.binar.isekaibioskop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "Create an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied",
                    content = @Content)})
    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO request){
        final UserEntity userEntity = userService.mapToEntity(request);
        final UserEntity result = userService.create(userEntity);
        return userService.mapToDto(result);
    }

    @Operation(summary = "Update an user by its username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @PutMapping("/update/{username}")
    public UserDTO update(@PathVariable String username, @RequestBody UserDTO request){
        final UserEntity userEntity = userService.mapToEntity(request);
        final UserEntity result = userService.update(username, userEntity);
        return userService.mapToDto(result);
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("/get/all")
    public List<UserDTO> findAll(){
        return userService.findAll().stream().map(userEntity -> userService.mapToDto(userEntity))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Get an user by its username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("/get/{username}")
    public UserEntity findOne(@PathVariable String username){
        return userService.findById(username);
    }

    @Operation(summary = "Delete an user by its username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @DeleteMapping("delete/{username}")
    public Boolean delete(@PathVariable String username){
        return userService.delete(username);
    }

}