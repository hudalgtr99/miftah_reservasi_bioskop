package org.binaracademy.seatservice.service.impl;

import org.binaracademy.seatservice.dto.StudioDTO;
import org.binaracademy.seatservice.entity.StudioEntity;
import org.binaracademy.seatservice.exception.DataNotFoundException;
import org.binaracademy.seatservice.repository.StudioRepository;
import org.binaracademy.seatservice.service.StudioService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudioServiceImpl implements StudioService {

    private static final String ENTITY = "studioEntity";
    private final Logger log =  LoggerFactory.getLogger(StudioServiceImpl.class);

    @Autowired
    StudioRepository studioRepository;

    @Override
    public StudioEntity create(StudioEntity studioEntity) {
        log.info("Has successfully created studio data!");
        return studioRepository.save(studioEntity);
    }

    @Override
    public StudioEntity update(Long id, StudioEntity studioEntity) {
        StudioEntity result = studioRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });

        result.setName(studioEntity.getName());
        result.setFullStatus(studioEntity.getFullStatus());
        studioRepository.save(result);
        log.info("Has successfully updated studio data!");
        return result;
    }

    @Override
    public StudioEntity delete(Long id) {
        StudioEntity result = studioRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        studioRepository.delete(result);
        log.info("Has successfully deleted studio data!");
        return result;
    }

    @Override
    public List<StudioEntity> findAll() {
        log.info("Has successfully found all studio data!");
        return studioRepository.findAll();
    }
    @Override
    public StudioEntity findById(Long id) {
        StudioEntity studioEntity = studioRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        log.info("Has successfully found studio data from id " + id);
        return studioEntity;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public StudioDTO mapToDto(StudioEntity studioEntity) {
        return mapper.map(studioEntity, StudioDTO.class);
    }

    @Override
    public StudioEntity mapToEntity(StudioDTO studioDTO) {
        return mapper.map(studioDTO, StudioEntity.class);
    }

}