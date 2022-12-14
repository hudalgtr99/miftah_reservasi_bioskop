package org.binar.isekaibioskop.controller.embedded;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.embedded.SeatDetailDTO;
import org.binar.isekaibioskop.entity.embedded.SeatDetailEntity;
import org.binar.isekaibioskop.entity.embedded.SeatDetailId;
import org.binar.isekaibioskop.response.ResponseMessage;
import org.binar.isekaibioskop.service.impl.embedded.SeatDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seatDetail")
public class SeatDetailController {

    @Autowired
    SeatDetailService seatDetailService;

    @Operation(summary = "Create an seat detail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the seat detail",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDetailEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody SeatDetailDTO seatDetailDTO){
        SeatDetailEntity request = seatDetailService.mapToEntity(seatDetailDTO);
        SeatDetailEntity seatDetailEntity = seatDetailService.create(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add seat detail with Id: " + seatDetailEntity.getSeatDetailId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all seat details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the seat detail",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDetailEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Seat Detail not found",
                    content = @Content) })
    @GetMapping("/get/all")
    public ResponseEntity<ResponseMessage> findAll(){
        List<SeatDetailDTO> result = seatDetailService.findAll().stream().map(seatDetailEntity -> seatDetailService.mapToDto(seatDetailEntity))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved all seat detail",
                result);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Get an seat detail by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the seatDetail",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDetailEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Seat Detail not found",
                    content = @Content) })
    @GetMapping("/getById/{seatDetailEntityId}")
    public ResponseEntity<ResponseMessage> findById(@PathVariable("seatDetailEntityId") SeatDetailId seatDetailEntityId){

        SeatDetailEntity seatDetailEntity = seatDetailService.findById(seatDetailEntityId);
        SeatDetailDTO result = seatDetailService.mapToDto(seatDetailEntity);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved seat detail with Id : " + seatDetailEntity.getSeatDetailId(), result
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Delete an seat detail by its Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the seat detail",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDetailEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Seat Detail not found",
                    content = @Content) })
    @DeleteMapping("delete/{seatDetailEntityId}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable SeatDetailId seatDetailEntityId){
        SeatDetailEntity result = seatDetailService.delete(seatDetailEntityId);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully deleted seatDetail with seatDetailEntityId : " + result.getSeatDetailId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
