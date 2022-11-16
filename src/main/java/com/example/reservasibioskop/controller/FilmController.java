package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.dto.FilmDTO;
import com.example.reservasibioskop.entity.FilmEntity;
import com.example.reservasibioskop.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/film")
public class FilmController {

    final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @Operation(summary = "Create an film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid code supplied",
                    content = @Content)})
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public FilmDTO create(@RequestBody FilmDTO request){
        final FilmEntity filmEntity = filmService.mapToEntity(request);
        final FilmEntity result = filmService.create(filmEntity);
        return filmService.mapToDto(result);
    }

    @Operation(summary = "Update an film by its code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid code supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content) })
    @PutMapping("/update/{code}")
    public FilmDTO update(@PathVariable Long code, @RequestBody FilmDTO request){
        final FilmEntity filmEntity = filmService.mapToEntity(request);
        final FilmEntity result = filmService.update(code, filmEntity);
        return filmService.mapToDto(result);
    }

    @Operation(summary = "Get all films")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content) })
    @GetMapping("/all")
    public List<FilmDTO> findAll(){
        return filmService.findAll().stream().map(filmService::mapToDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Get an film by its code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid code supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @GetMapping("/{code}")
    public FilmEntity findOne(@PathVariable Long code){
        return filmService.findById(code);
    }


    @Operation(summary = "Delete an film by its code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the film",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid code supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Film not found",
                    content = @Content) })
    @DeleteMapping("/delete/{code}")
    public Boolean delete(@PathVariable Long code){
        return filmService.delete(code);
    }
}
