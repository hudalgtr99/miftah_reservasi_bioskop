package org.binaracademy.movieservice.controller;

import org.binaracademy.movieservice.dto.FilmDTO;
import org.binaracademy.movieservice.entity.FilmEntity;
import org.binaracademy.movieservice.response.ResponseMessage;
import org.binaracademy.movieservice.service.FilmService;
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