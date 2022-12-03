package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.dto.OrderDTO;
import org.binar.isekaibioskop.entity.OrderEntity;

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
