package org.binar.isekaibioskop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.isekaibioskop.dto.OrderDTO;
import org.binar.isekaibioskop.entity.OrderEntity;
import org.binar.isekaibioskop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Create an order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the order",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content)})

    @PostMapping("/create")
    public OrderDTO create(@RequestBody OrderDTO request){
        final OrderEntity orderEntity = orderService.mapToEntity(request);
        final OrderEntity result = orderService.create(orderEntity);
        return orderService.mapToDto(result);
    }

    @Operation(summary = "Update an order by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the schedule",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @PutMapping("/update/{id}")
    public OrderDTO update(@PathVariable Long id, @RequestBody OrderDTO request){
        final OrderEntity orderEntity = orderService.mapToEntity(request);
        final OrderEntity result = orderService.update(id, orderEntity);
        return orderService.mapToDto(result);
    }

    @Operation(summary = "Get all orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content) })
    @GetMapping("/all")
    public List<OrderDTO> findAll(){
        return orderService.findAll().stream().map(orderService::mapToDto)
                .collect(Collectors.toList());
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
    public OrderEntity findOne(@PathVariable Long id){
        return orderService.findById(id);
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
    public Boolean delete(@PathVariable Long id){
        return orderService.delete(id);
    }
}