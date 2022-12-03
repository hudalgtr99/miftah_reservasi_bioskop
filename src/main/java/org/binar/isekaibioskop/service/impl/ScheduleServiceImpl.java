package org.binar.isekaibioskop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.binar.isekaibioskop.dto.ScheduleDTO;
import org.binar.isekaibioskop.entity.FilmEntity;
import org.binar.isekaibioskop.entity.ScheduleEntity;
import org.binar.isekaibioskop.repository.ScheduleRepository;
import org.binar.isekaibioskop.service.FilmService;
import org.binar.isekaibioskop.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    FilmService filmService;

    @Override
    public ScheduleEntity addSchedule(Long filmCode, ScheduleEntity scheduleEntity) {
        FilmEntity filmEntity = filmService.findById(filmCode);
        if (filmEntity != null) {
            scheduleEntity = scheduleRepository.save(scheduleEntity);
            if (filmEntity.getScheduleEntities() != null) {
                List<ScheduleEntity> scheduleEntities = filmEntity.getScheduleEntities();
                scheduleEntities.add(scheduleEntity);
                filmEntity.setScheduleEntities(scheduleEntities);
            }
            else{
                filmEntity.setScheduleEntities(Collections.singletonList(scheduleEntity));
            }
            filmService.create(filmEntity);
            return scheduleEntity;
        }
        return null;
    }

    @Override
    public ScheduleEntity create(ScheduleEntity scheduleEntity) {
        ScheduleEntity result = scheduleRepository.save(scheduleEntity);
        return result;
    }

    @Override
    public ScheduleEntity update(Long id, ScheduleEntity scheduleEntity) {
        ScheduleEntity result = findById(id);
        if (result != null) {
            result.setShowDate(scheduleEntity.getShowDate());
            result.setStartTime(scheduleEntity.getStartTime());
            result.setEndTime(scheduleEntity.getEndTime());
            result.setPrice(scheduleEntity.getPrice());
            return scheduleRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        ScheduleEntity result = findById(id);
        if (result != null) {
            scheduleRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<ScheduleEntity> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public ScheduleEntity findById(Long id) {
        Optional<ScheduleEntity> result = scheduleRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ScheduleDTO mapToDto(ScheduleEntity scheduleEntity) {
        return mapper.convertValue(scheduleEntity, ScheduleDTO.class);
    }

    @Override
    public ScheduleEntity mapToEntity(ScheduleDTO scheduleDTO) {
        return mapper.convertValue(scheduleDTO, ScheduleEntity.class);
    }

}