package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.dto.OrderDTO;
import org.binar.isekaibioskop.entity.OrderEntity;
import org.binar.isekaibioskop.entity.embedded.SeatDetailId;

import java.util.List;

public interface OrderService {

    OrderEntity create(String userId, Long scheduleId);
    OrderEntity delete(Long id);
    List<OrderEntity> findAll();

    OrderEntity findById(Long id);

    OrderDTO mapToDto(OrderEntity orderEntity);
    OrderEntity mapToEntity(OrderDTO orderDTO);
}
