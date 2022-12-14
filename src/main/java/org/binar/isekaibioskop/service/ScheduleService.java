package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.dto.ScheduleDTO;
import org.binar.isekaibioskop.entity.ScheduleEntity;

import java.util.List;

public interface ScheduleService {
    ScheduleEntity create(ScheduleEntity scheduleEntity);
    ScheduleEntity update(Long id, ScheduleEntity scheduleEntity);
    ScheduleEntity delete(Long id);
    List<ScheduleEntity> findAll();
    ScheduleEntity findById(Long id);

    ScheduleDTO mapToDto(ScheduleEntity scheduleEntity);
    ScheduleEntity mapToEntity(ScheduleDTO scheduleDTO);
}