package org.binaracademy.seatservice.controller;

import org.binaracademy.seatservice.dto.SeatDTO;
import org.binaracademy.seatservice.entity.SeatEntity;
import org.binaracademy.seatservice.response.ResponseMessage;
import org.binaracademy.seatservice.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    SeatService seatService;


    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody SeatDTO seatDTO){
        SeatEntity request = seatService.mapToEntity(seatDTO);
        SeatEntity seatEntity = seatService.create(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add seat with id: " + seatEntity.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> update(@PathVariable Long id, @RequestBody SeatDTO seatDTO) {
        SeatEntity request = seatService.mapToEntity(seatDTO);
        SeatEntity seatEntity = seatService.update(id, request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully updated seat with id : " + seatEntity.getId()
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<ResponseMessage> findAll(){
        List<SeatDTO> result = seatService.findAll().stream().map(seatEntity -> seatService.mapToDto(seatEntity))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved all seat",
                result);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseMessage> findById(@PathVariable("id") Long id){

        SeatEntity seatEntity = seatService.findById(id);
        SeatDTO result = seatService.mapToDto(seatEntity);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved seat with id : " + seatEntity.getId(), result
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        SeatEntity result = seatService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully deleted seat with id : " + result.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}