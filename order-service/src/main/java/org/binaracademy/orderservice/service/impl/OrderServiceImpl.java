package org.binaracademy.orderservice.service.impl;

import org.binaracademy.orderservice.dto.OrderDTO;
import org.binaracademy.orderservice.entity.FilmEntity;
import org.binaracademy.orderservice.entity.OrderEntity;
import org.binaracademy.orderservice.entity.ScheduleEntity;
import org.binaracademy.orderservice.entity.UserEntity;
import org.binaracademy.orderservice.exception.DataNotFoundException;
import org.binaracademy.orderservice.repository.FilmRepository;
import org.binaracademy.orderservice.repository.OrderRepository;
import org.binaracademy.orderservice.repository.ScheduleRepository;
import org.binaracademy.orderservice.repository.UserRepository;
import org.binaracademy.orderservice.service.OrderService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private static final String ENTITY = "orderEntity";

    private final Logger log =  LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    FilmRepository filmRepository;

    @Override
    public OrderEntity create(String userId, Long scheduleId, Long filmId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException("userEntity", "id", userId);
                    exception.setApiResponse();
                    throw exception;
                });

        ScheduleEntity scheduleEntity = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException("scheduleEntity", "id", scheduleId.toString());
                    exception.setApiResponse();
                    throw exception;
                });

        FilmEntity filmEntity = filmRepository.findById(filmId)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException("filmEntity", "id", filmId.toString());
                    exception.setApiResponse();
                    throw exception;
                });


        OrderEntity orderEntity = OrderEntity.builder()
                .userDetails(userEntity)
                .scheduleDetails(scheduleEntity)
                .filmDetails(filmEntity)
                .build();

        return orderRepository.save(orderEntity);
    }

    @Override
    public OrderEntity delete(Long id) {
        OrderEntity result = orderRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        orderRepository.delete(result);
        log.info("Has successfully deleted order data!");
        return result;
    }

    @Override
    public List<OrderEntity> findAll() {
        log.info("Has successfully found all order data!");
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity findById(Long id) {
        OrderEntity orderEntity= orderRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        log.info("Has successfully found order data from id " + id);
        return orderEntity;
    }


    ModelMapper mapper = new ModelMapper();

    @Override
    public OrderDTO mapToDto(OrderEntity orderEntity) {
        return mapper.map(orderEntity, OrderDTO.class);
    }

    @Override
    public OrderEntity mapToEntity(OrderDTO orderDTO) {
        return mapper.map(orderDTO, OrderEntity.class);
    }
}