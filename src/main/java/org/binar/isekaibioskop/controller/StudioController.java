package org.binar.isekaibioskop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.StudioDTO;
import org.binar.isekaibioskop.entity.StudioEntity;
import org.binar.isekaibioskop.response.ResponseMessage;
import org.binar.isekaibioskop.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/studio")
public class StudioController {

    @Autowired
    StudioService studioService;

    @Operation(summary = "Create an studio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the studio",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudioEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody StudioDTO studioDTO){
        StudioEntity request = studioService.mapToEntity(studioDTO);
        StudioEntity studioEntity = studioService.create(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add studio with id: " + studioEntity.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an studio by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the studio",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudioEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid studio id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Studio not found",
                    content = @Content) })
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> update(@PathVariable Long id, @RequestBody StudioDTO studioDTO) {
        StudioEntity request = studioService.mapToEntity(studioDTO);
        StudioEntity studioEntity = studioService.update(id, request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully updated studio with id : " + studioEntity.getId()
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Get all studios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the studio",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudioEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Studio not found",
                    content = @Content) })
    @GetMapping("/get/all")
    public ResponseEntity<ResponseMessage> findAll(){
        List<StudioDTO> result = studioService.findAll().stream().map(studioEntity -> studioService.mapToDto(studioEntity))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved all studio",
                result);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Get an studio by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the studio",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudioEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Studio not found",
                    content = @Content) })
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseMessage> findById(@PathVariable("id") Long id){

        StudioEntity studioEntity = studioService.findById(id);
        StudioDTO result = studioService.mapToDto(studioEntity);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved studio with id : " + studioEntity.getId(), result
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Delete an studio by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the studio",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudioEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Studio not found",
                    content = @Content) })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        StudioEntity result = studioService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully deleted studio with id : " + result.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
