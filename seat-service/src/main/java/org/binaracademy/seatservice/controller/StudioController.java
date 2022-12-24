package org.binaracademy.seatservice.controller;

import org.binaracademy.seatservice.dto.StudioDTO;
import org.binaracademy.seatservice.entity.StudioEntity;
import org.binaracademy.seatservice.response.ResponseMessage;
import org.binaracademy.seatservice.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/studio")
public class StudioController {

    @Autowired
    StudioService studioService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody StudioDTO studioDTO){
        StudioEntity request = studioService.mapToEntity(studioDTO);
        StudioEntity studioEntity = studioService.create(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add studio with id: " + studioEntity.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> update(@PathVariable Long id, @RequestBody StudioDTO studioDTO) {
        StudioEntity request = studioService.mapToEntity(studioDTO);
        StudioEntity studioEntity = studioService.update(id, request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully updated studio with id : " + studioEntity.getId()
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<ResponseMessage> findAll(){
        List<StudioDTO> result = studioService.findAll().stream().map(studioEntity -> studioService.mapToDto(studioEntity))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved all studio",
                result);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseMessage> findById(@PathVariable("id") Long id){

        StudioEntity studioEntity = studioService.findById(id);
        StudioDTO result = studioService.mapToDto(studioEntity);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved studio with id : " + studioEntity.getId(), result
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        StudioEntity result = studioService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully deleted studio with id : " + result.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}