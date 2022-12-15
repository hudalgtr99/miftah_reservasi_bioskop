package org.binar.isekaibioskop.service.impl;

import org.binar.isekaibioskop.dto.OrderDTO;
import org.binar.isekaibioskop.entity.OrderEntity;
import org.binar.isekaibioskop.entity.ScheduleEntity;
import org.binar.isekaibioskop.entity.UserEntity;
import org.binar.isekaibioskop.exception.DataNotFoundException;
import org.binar.isekaibioskop.repository.OrderRepository;
import org.binar.isekaibioskop.repository.ScheduleRepository;
import org.binar.isekaibioskop.repository.UserRepository;
import org.binar.isekaibioskop.service.OrderService;
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

    @Override
    public OrderEntity create(String userId, Long scheduleId) {
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


        OrderEntity orderEntity = OrderEntity.builder()
                .userDetails(userEntity)
                .scheduleDetails(scheduleEntity)
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