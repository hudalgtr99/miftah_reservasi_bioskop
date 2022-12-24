package org.binaracademy.movieservice.controller;

import org.binaracademy.movieservice.dto.ScheduleDTO;
import org.binaracademy.movieservice.entity.ScheduleEntity;
import org.binaracademy.movieservice.request.ScheduleRequest;
import org.binaracademy.movieservice.response.ResponseMessage;
import org.binaracademy.movieservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;


    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@Valid @RequestBody ScheduleRequest scheduleRequest) {

        ScheduleEntity scheduleEntity = scheduleService.create(scheduleRequest);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully add schedule with id : " + scheduleEntity.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> update(@PathVariable Long id, @RequestBody ScheduleDTO scheduleDTO) {
        ScheduleEntity request = scheduleService.mapToEntity(scheduleDTO);
        ScheduleEntity scheduleEntity = scheduleService.update(id, request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully updated schedule with id : " + scheduleEntity.getId()
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<ResponseMessage> findAll(){
        List<ScheduleDTO> result = scheduleService.findAll().stream().map(scheduleEntity -> scheduleService.mapToDto(scheduleEntity))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved all schedule",
                result);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseMessage> findById(@PathVariable("id") Long id){

        ScheduleEntity scheduleEntity = scheduleService.findById(id);
        ScheduleDTO result = scheduleService.mapToDto(scheduleEntity);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved schedule with id : " + scheduleEntity.getId(), result
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        ScheduleEntity result = scheduleService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully deleted schedule with id : " + result.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}