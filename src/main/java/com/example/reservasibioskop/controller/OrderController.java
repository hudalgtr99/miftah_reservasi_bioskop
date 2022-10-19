package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.dto.OrderDTO;
import com.example.reservasibioskop.entity.OrderEntity;
import com.example.reservasibioskop.service.OrderService;
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

    @PostMapping("/create")
    public OrderDTO create(@RequestBody OrderDTO request){
        final OrderEntity orderEntity = orderService.mapToEntity(request);
        final OrderEntity result = orderService.create(orderEntity);
        return orderService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public OrderDTO update(@PathVariable Long id, @RequestBody OrderDTO request){
        final OrderEntity orderEntity = orderService.mapToEntity(request);
        final OrderEntity result = orderService.update(id, orderEntity);
        return orderService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<OrderDTO> findAll(){
        return orderService.findAll().stream().map(orderService::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return orderService.delete(id);
    }
}
