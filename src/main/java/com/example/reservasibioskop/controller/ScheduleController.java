package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.dto.ScheduleDTO;
import com.example.reservasibioskop.entity.ScheduleEntity;
import com.example.reservasibioskop.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Operation(summary = "Create an schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
    @PostMapping("/create")
    public ScheduleDTO create(@RequestBody ScheduleDTO request){
        final ScheduleEntity scheduleEntity = scheduleService.mapToEntity(request);
        final ScheduleEntity result = scheduleService.create(scheduleEntity);
        return scheduleService.mapToDto(result);
    }

    @Operation(summary = "Update an schedule by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Schedule not found",
                    content = @Content) })
    @PutMapping("/update/{id}")
    public ScheduleDTO update(@PathVariable Long id, @RequestBody ScheduleDTO request){
        final ScheduleEntity scheduleEntity = scheduleService.mapToEntity(request);
        final ScheduleEntity result = scheduleService.update(id, scheduleEntity);
        return scheduleService.mapToDto(result);
    }

    @Operation(summary = "Get all schedules")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ScheduleEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Schedule not found",
                    content = @Content) })
    @GetMapping("/all")
    public List<ScheduleDTO> findAll(){
        return scheduleService.findAll().stream().map(scheduleService::mapToDto)
                .collect(Collectors.toList());
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
    @GetMapping("/{id}")
    public ScheduleEntity findOne(@PathVariable Long id){
        return scheduleService.findById(id);
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
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return scheduleService.delete(id);
    }

}
