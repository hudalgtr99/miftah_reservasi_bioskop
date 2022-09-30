package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.dto.ScheduleDTO;
import com.example.reservasibioskop.dto.ScheduleDTO;
import com.example.reservasibioskop.entity.ScheduleEntity;
import com.example.reservasibioskop.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/create")
    public ScheduleDTO create(@RequestBody ScheduleDTO request){
        final ScheduleEntity scheduleEntity = scheduleService.mapToEntity(request);
        final ScheduleEntity result = scheduleService.create(scheduleEntity);
        return scheduleService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public ScheduleDTO update(@PathVariable Long id, @RequestBody ScheduleDTO request){
        final ScheduleEntity scheduleEntity = scheduleService.mapToEntity(request);
        final ScheduleEntity result = scheduleService.update(id, scheduleEntity);
        return scheduleService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<ScheduleDTO> findAll(){
        return scheduleService.findAll().stream().map(scheduleService::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return scheduleService.delete(id);
    }

}
