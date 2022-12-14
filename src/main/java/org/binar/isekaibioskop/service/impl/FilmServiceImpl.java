package org.binar.isekaibioskop.service.impl;

import org.binar.isekaibioskop.dto.FilmDTO;
import org.binar.isekaibioskop.entity.FilmEntity;
import org.binar.isekaibioskop.exception.DataNotFoundException;
import org.binar.isekaibioskop.repository.FilmRepository;
import org.binar.isekaibioskop.service.FilmService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {


    private static final String ENTITY = "filmEntity";
    private final Logger log =  LoggerFactory.getLogger(FilmServiceImpl.class);

    @Autowired
    FilmRepository filmRepository;

    @Override
    public FilmEntity create(FilmEntity filmEntity) {
        log.info("Has successfully created film data!");
        return filmRepository.save(filmEntity);
    }

    @Override
    public FilmEntity update(Long id, FilmEntity filmEntity) {
        FilmEntity result = filmRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });

        result.setName(filmEntity.getName());
        result.setDescription(filmEntity.getDescription());
        result.setDuration(filmEntity.getDuration());
        result.setLanguage(filmEntity.getLanguage());
        result.setShowStatus(filmEntity.getShowStatus());
        filmRepository.save(result);
        log.info("Has successfully updated film data!");
        return result;
    }

    @Override
    public FilmEntity delete(Long id) {
        FilmEntity result = filmRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        filmRepository.delete(result);
        log.info("Has successfully deleted film data!");
        return result;
    }

    @Override
    public List<FilmEntity> findAll() {
        log.info("Has successfully found all film data!");
        return filmRepository.findAll();
    }
    @Override
    public FilmEntity findById(Long id) {
        FilmEntity filmEntity = filmRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        log.info("Has successfully found film data from id " + id);
        return filmEntity;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public FilmDTO mapToDto(FilmEntity filmEntity) {
        return mapper.map(filmEntity, FilmDTO.class);
    }

    @Override
    public FilmEntity mapToEntity(FilmDTO filmDTO) {
        return mapper.map(filmDTO, FilmEntity.class);
    }

}