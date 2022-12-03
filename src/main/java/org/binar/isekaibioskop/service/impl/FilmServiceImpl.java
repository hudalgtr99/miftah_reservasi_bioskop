package org.binar.isekaibioskop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.binar.isekaibioskop.dto.FilmDTO;
import org.binar.isekaibioskop.entity.FilmEntity;
import org.binar.isekaibioskop.repository.FilmRepository;
import org.binar.isekaibioskop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;


    @Override
    public FilmEntity create(FilmEntity filmEntity) {
        FilmEntity result = filmRepository.save(filmEntity);
        return result;
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
        if (result.isPresent()) {
            return result.get();
        }
        return null;
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
}