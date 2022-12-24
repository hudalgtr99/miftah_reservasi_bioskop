package org.binaracademy.movieservice.service;

import org.binaracademy.movieservice.dto.ScheduleDTO;
import org.binaracademy.movieservice.entity.ScheduleEntity;
import org.binaracademy.movieservice.request.ScheduleRequest;

import java.util.List;

public interface ScheduleService {
    ScheduleEntity create(ScheduleRequest scheduleRequest);
    ScheduleEntity update(Long id, ScheduleEntity scheduleEntity);
    ScheduleEntity delete(Long id);
    List<ScheduleEntity> findAll();
    ScheduleEntity findById(Long id);

    ScheduleDTO mapToDto(ScheduleEntity scheduleEntity);
    ScheduleEntity mapToEntity(ScheduleDTO scheduleDTO);
}