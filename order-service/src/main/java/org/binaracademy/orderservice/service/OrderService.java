package org.binaracademy.orderservice.service;

import org.binaracademy.orderservice.dto.OrderDTO;
import org.binaracademy.orderservice.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    OrderEntity create(String userId, Long scheduleId, Long filmId);
    OrderEntity delete(Long id);
    List<OrderEntity> findAll();

    OrderEntity findById(Long id);

    OrderDTO mapToDto(OrderEntity orderEntity);
    OrderEntity mapToEntity(OrderDTO orderDTO);
}