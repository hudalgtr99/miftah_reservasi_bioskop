package org.binar.isekaibioskop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.ScheduleDTO;
import org.binar.isekaibioskop.entity.ScheduleEntity;
import org.binar.isekaibioskop.response.ResponseMessage;
import org.binar.isekaibioskop.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Operation(summary = "Create an schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody ScheduleDTO scheduleDTO){
        ScheduleEntity request = scheduleService.mapToEntity(scheduleDTO);
        ScheduleEntity scheduleEntity = scheduleService.create(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add user with id: " + scheduleEntity.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an schedule by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid schedule id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Schedule not found",
                    content = @Content) })
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

    @Operation(summary = "Get all schedules")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Schedule not found",
                    content = @Content) })
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

    @Operation(summary = "Get an schedule by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Schedule not found",
                    content = @Content) })
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

    @Operation(summary = "Delete an schedule by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Schedule not found",
                    content = @Content) })
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