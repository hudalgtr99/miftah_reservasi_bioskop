package com.example.reservasibioskop.service;

import com.example.reservasibioskop.dto.OrderDTO;
import com.example.reservasibioskop.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    OrderEntity create(OrderEntity orderEntity);
    OrderEntity update(Long id, OrderEntity orderEntity);
    Boolean delete(Long id);
    List<OrderEntity> findAll();

    OrderEntity findById(Long id);

    OrderDTO mapToDto(OrderEntity orderEntity);
    OrderEntity mapToEntity(OrderDTO orderDTO);
}
