package com.example.reservasibioskop.service.impl;

import com.example.reservasibioskop.dto.ScheduleDTO;
import com.example.reservasibioskop.entity.ScheduleEntity;
import com.example.reservasibioskop.repository.ScheduleRepository;
import com.example.reservasibioskop.service.ScheduleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
//import java.time.LocalDateTime;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleEntity create(ScheduleEntity scheduleEntity) {
        return scheduleRepository.save(scheduleEntity);
    }

    @Override
    public ScheduleEntity update(Long id, ScheduleEntity scheduleEntity) {
        ScheduleEntity result = findById(id);
        if (result != null) {
            result.setShowDate(scheduleEntity.getShowDate());
            result.setStartTime(scheduleEntity.getStartTime());
            result.setEndTime(scheduleEntity.getEndTime());
            result.setPrice(scheduleEntity.getPrice());
//            result.setUpdatedAt(LocalDateTime.now());
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
        return result.orElse(null);
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
