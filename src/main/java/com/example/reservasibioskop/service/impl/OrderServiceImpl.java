package com.example.reservasibioskop.service.impl;

import com.example.reservasibioskop.dto.OrderDTO;
import com.example.reservasibioskop.entity.OrderEntity;
import com.example.reservasibioskop.repository.OrderRepository;
import com.example.reservasibioskop.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderEntity create(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    @Override
    public OrderEntity update(Long id, OrderEntity orderEntity) {
        OrderEntity result = findById(id);
        if (result != null) {
            result.setUserEntity(orderEntity.getUserEntity());
            result.setScheduleEntity(orderEntity.getScheduleEntity());
            result.setSeatDetailEntities(orderEntity.getSeatDetailEntities());
            result.setQuantity(orderEntity.getQuantity());
//            result.setUpdatedAt(LocalDateTime.now());
            return orderRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        OrderEntity result = findById(id);
        if (result != null) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity findById(Long id) {
        Optional<OrderEntity> result = orderRepository.findById(id);
        return result.orElse(null);
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public OrderDTO mapToDto(OrderEntity orderEntity) {
        return mapper.convertValue(orderEntity, OrderDTO.class);
    }

    @Override
    public OrderEntity mapToEntity(OrderDTO orderDto) {
        return mapper.convertValue(orderDto, OrderEntity.class);
    }
}
