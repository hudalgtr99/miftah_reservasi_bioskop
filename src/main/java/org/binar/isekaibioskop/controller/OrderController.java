package org.binar.isekaibioskop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.OrderDTO;
import org.binar.isekaibioskop.entity.OrderEntity;
import org.binar.isekaibioskop.response.ResponseMessage;
import org.binar.isekaibioskop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    
    @Operation(summary = "Create an order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the order",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestParam String userId, Long scheduleId){
        OrderEntity request = orderService.create(userId, scheduleId);
        OrderDTO result = orderService.mapToDto(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add OrderEntity with id: " + result.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @GetMapping("/all")
    public ResponseEntity<ResponseMessage> findAll(){
        List<OrderDTO> result = orderService.findAll().stream().map(orderEntity -> orderService.mapToDto(orderEntity))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved all orderEntity",
                result);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Get an order by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> findById(@PathVariable("id") Long id){

        OrderEntity orderEntity = orderService.findById(id);
        OrderDTO result = orderService.mapToDto(orderEntity);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully retrieved order with id : " + orderEntity.getId(),
                result
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Operation(summary = "Delete an order by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the order",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        OrderEntity result = orderService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "successfully deleted order with id : " + result.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}