package org.binar.isekaibioskop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.FilmDTO;
import org.binar.isekaibioskop.entity.FilmEntity;
import org.binar.isekaibioskop.response.ResponseMessage;
import org.binar.isekaibioskop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Operation(summary = "Create an film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody FilmDTO filmDTO){
        FilmEntity request = filmService.mapToEntity(filmDTO);
        FilmEntity filmEntity = filmService.create(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add film with code: " + filmEntity.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an film by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid film id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content) })
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> update(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {
        FilmEntity request = filmService.mapToEntity(filmDTO);
        FilmEntity filmEntity = filmService.update(id, request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully updated film with id : " + filmEntity.getId()
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Get all films")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content) })
    @GetMapping("/get/all")
    public ResponseEntity<ResponseMessage> findAll(){
        List<FilmDTO> result = filmService.findAll().stream().map(filmEntity -> filmService.mapToDto(filmEntity))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved all film",
                result);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Get an film by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content) })
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseMessage> findById(@PathVariable("id") Long id){

        FilmEntity filmEntity = filmService.findById(id);
        FilmDTO result = filmService.mapToDto(filmEntity);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved film with id : " + filmEntity.getId(), result
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Delete an film by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content) })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        FilmEntity result = filmService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully deleted film with id : " + result.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}