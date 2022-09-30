package com.example.reservasibioskop.service;

import com.example.reservasibioskop.dto.FilmDTO;
import com.example.reservasibioskop.entity.FilmEntity;
import java.util.List;

public interface FilmService {

    FilmEntity create(FilmEntity filmEntity);
    FilmEntity update(Long code, FilmEntity filmEntity);
    Boolean delete(Long code);
    List<FilmEntity> findAll();

    FilmEntity findById(Long code);

    FilmDTO mapToDto(FilmEntity filmEntity);
    FilmEntity mapToEntity(FilmDTO filmDTO);
}
