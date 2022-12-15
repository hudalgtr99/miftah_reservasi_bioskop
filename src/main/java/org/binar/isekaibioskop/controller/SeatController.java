package org.binar.isekaibioskop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.SeatDTO;
import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.response.ResponseMessage;
import org.binar.isekaibioskop.service.SeatService;
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

    @Operation(summary = "Create an seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the seat",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
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

    @Operation(summary = "Update an seat by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the seat",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid seat id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Seat not found",
                    content = @Content) })
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

    @Operation(summary = "Get all seats")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the seat",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Seat not found",
                    content = @Content) })
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

    @Operation(summary = "Get an seat by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the seat",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Seat not found",
                    content = @Content) })
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

    @Operation(summary = "Delete an seat by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the seat",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Seat not found",
                    content = @Content) })
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
