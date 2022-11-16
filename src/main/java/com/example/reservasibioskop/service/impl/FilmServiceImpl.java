package com.example.reservasibioskop.service.impl;

import com.example.reservasibioskop.dto.FilmDTO;
import com.example.reservasibioskop.entity.FilmEntity;
import com.example.reservasibioskop.repository.FilmRepository;
import com.example.reservasibioskop.service.FilmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
//import java.time.LocalDateTime;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public FilmEntity create(FilmEntity filmEntity) {
        return filmRepository.save(filmEntity);
    }

    @Override
    public FilmEntity update(Long code, FilmEntity filmEntity) {
        FilmEntity result = findById(code);
        if (result != null) {
            result.setName(filmEntity.getName());
            result.setDescription(filmEntity.getDescription());
            result.setDuration(filmEntity.getDuration());
            result.setLanguage(filmEntity.getLanguage());
            result.setShowStatus(filmEntity.getShowStatus());
//            result.setUpdatedAt(LocalDateTime.now());
            return filmRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long code) {
        FilmEntity result = findById(code);
        if (result != null) {
            filmRepository.deleteById(code);
            return true;
        }
        return false;
    }

    @Override
    public List<FilmEntity> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public FilmEntity findById(Long code) {
        Optional<FilmEntity> result = filmRepository.findById(code);
        return result.orElse(null);
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public FilmDTO mapToDto(FilmEntity filmEntity) {
        return mapper.convertValue(filmEntity, FilmDTO.class);
    }

    @Override
    public FilmEntity mapToEntity(FilmDTO filmDTO) {
        return mapper.convertValue(filmDTO, FilmEntity.class);
    }


//    @Override
//    public void insertFilm(FilmEntity filmEntity){
//        filmRepository.save(filmEntity);
//    }

//    @Override
//    public List<Film> getAllFilm(){
//        return filmRepository.findAll();
//    }



}
