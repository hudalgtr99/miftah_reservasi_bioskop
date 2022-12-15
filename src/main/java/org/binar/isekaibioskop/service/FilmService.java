package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.dto.FilmDTO;
import org.binar.isekaibioskop.entity.FilmEntity;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public interface FilmService {
    FilmEntity create(FilmEntity filmEntity);
    FilmEntity update(Long code, FilmEntity filmEntity);
    FilmEntity delete(Long code);
    List<FilmEntity> findAll();
    FilmEntity findById(Long code);

    FilmDTO mapToDto(FilmEntity filmEntity);
    FilmEntity mapToEntity(FilmDTO filmDTO);


}