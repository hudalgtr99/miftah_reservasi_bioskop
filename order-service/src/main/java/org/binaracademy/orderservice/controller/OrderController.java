package org.binaracademy.orderservice.controller;

import org.binaracademy.orderservice.dto.OrderDTO;
import org.binaracademy.orderservice.entity.OrderEntity;
import org.binaracademy.orderservice.response.ResponseMessage;
import org.binaracademy.orderservice.service.OrderService;
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

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestParam String userId, Long scheduleId, Long filmId){
        OrderEntity request = orderService.create(userId, scheduleId, filmId);
        OrderDTO result = orderService.mapToDto(request);
        ResponseMessage responseMessage = new ResponseMessage(
                Boolean.TRUE,
                "Successfully add OrderEntity with id: " + result.getId()
        );

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

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