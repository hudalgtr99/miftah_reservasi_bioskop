package com.example.reservasibioskop.service;

import com.example.reservasibioskop.dto.ScheduleDTO;
import com.example.reservasibioskop.entity.ScheduleEntity;

import java.util.List;

public interface ScheduleService {


    ScheduleEntity create(ScheduleEntity scheduleEntity);
    ScheduleEntity update(Long id, ScheduleEntity scheduleEntity);
    Boolean delete(Long id);
    List<ScheduleEntity> findAll();

    ScheduleEntity findById(Long id);

    ScheduleDTO mapToDto(ScheduleEntity scheduleEntity);
    ScheduleEntity mapToEntity(ScheduleDTO scheduleDTO);
}
