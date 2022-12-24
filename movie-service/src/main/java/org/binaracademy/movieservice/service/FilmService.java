package org.binaracademy.movieservice.service;

import org.binaracademy.movieservice.dto.FilmDTO;
import org.binaracademy.movieservice.entity.FilmEntity;

import java.util.List;

public interface FilmService {
    FilmEntity create(FilmEntity filmEntity);
    FilmEntity update(Long code, FilmEntity filmEntity);
    FilmEntity delete(Long code);
    List<FilmEntity> findAll();
    FilmEntity findById(Long code);

    FilmDTO mapToDto(FilmEntity filmEntity);
    FilmEntity mapToEntity(FilmDTO filmDTO);


}