package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.dto.FilmDTO;
import com.example.reservasibioskop.entity.FilmEntity;
import com.example.reservasibioskop.service.FilmService;
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

    @PostMapping("/create")
    public FilmDTO create(@RequestBody FilmDTO request){
        final FilmEntity filmEntity = filmService.mapToEntity(request);
        final FilmEntity result = filmService.create(filmEntity);
        return filmService.mapToDto(result);
    }

    @PutMapping("/update/{code}")
    public FilmDTO update(@PathVariable Long code, @RequestBody FilmDTO request){
        final FilmEntity filmEntity = filmService.mapToEntity(request);
        final FilmEntity result = filmService.update(code, filmEntity);
        return filmService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<FilmDTO> findAll(){
        return filmService.findAll().stream().map(filmService::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{code}")
    public Boolean delete(@PathVariable Long code){
        return filmService.delete(code);
    }
}
