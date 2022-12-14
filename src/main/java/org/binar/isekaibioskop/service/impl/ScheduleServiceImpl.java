package org.binar.isekaibioskop.service.impl;

import org.binar.isekaibioskop.dto.ScheduleDTO;
import org.binar.isekaibioskop.entity.FilmEntity;
import org.binar.isekaibioskop.entity.ScheduleEntity;
import org.binar.isekaibioskop.entity.UserEntity;
import org.binar.isekaibioskop.exception.DataNotFoundException;
import org.binar.isekaibioskop.repository.FilmRepository;
import org.binar.isekaibioskop.repository.ScheduleRepository;
import org.binar.isekaibioskop.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {


    private static final String ENTITY = "scheduleEntity";
    private final Logger log =  LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    FilmRepository filmRepository;

    @Override
    public ScheduleEntity create(ScheduleEntity scheduleEntity) {
        log.info("Has successfully created schedule data!");
        return scheduleRepository.save(scheduleEntity);
    }

    @Override
    public ScheduleEntity update(Long id, ScheduleEntity scheduleEntity) {
        ScheduleEntity result = scheduleRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });

        result.setShowDate(scheduleEntity.getShowDate());
        result.setStartTime(scheduleEntity.getStartTime());
        result.setEndTime(scheduleEntity.getEndTime());
        result.setPrice(scheduleEntity.getPrice());
        scheduleRepository.save(result);
        log.info("Has successfully updated schedule data!");
        return result;
    }

    @Override
    public ScheduleEntity delete(Long id) {
        ScheduleEntity result = scheduleRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        scheduleRepository.delete(result);
        log.info("Has successfully deleted schedule data!");
        return result;
    }

    @Override
    public List<ScheduleEntity> findAll() {
        log.info("Has successfully found all schedule data!");
        return scheduleRepository.findAll();
    }
    @Override
    public ScheduleEntity findById(Long id) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        log.info("Has successfully found schedule data from id " + id);
        return scheduleEntity;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public ScheduleDTO mapToDto(ScheduleEntity scheduleEntity) {
        return mapper.map(scheduleEntity, ScheduleDTO.class);
    }

    @Override
    public ScheduleEntity mapToEntity(ScheduleDTO scheduleDTO) {
        return mapper.map(scheduleDTO, ScheduleEntity.class);
    }

}