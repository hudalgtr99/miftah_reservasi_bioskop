package com.example.reservasibioskop.service.impl.embedded;

import com.example.reservasibioskop.dto.embedded.SeatDetailDTO;
import com.example.reservasibioskop.entity.OrderEntity;
import com.example.reservasibioskop.entity.embedded.SeatDetailEntity;
import com.example.reservasibioskop.repository.embedded.SeatDetailRepository;
import com.example.reservasibioskop.service.OrderService;
import com.example.reservasibioskop.service.embedded.SeatDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SeatDetailServiceImpl implements SeatDetailService {

    @Autowired
    OrderService orderService;

    @Autowired
    SeatDetailRepository seatDetailRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public SeatDetailEntity addSeatDetail(Long orderId, SeatDetailEntity seatDetailEntity) {
        final OrderEntity orderEntity = orderService.findById(orderId);
        if (orderEntity != null) {
            seatDetailEntity = seatDetailRepository.save(seatDetailEntity);
            if (orderEntity.getSeatDetailEntities() != null) {
                List<SeatDetailEntity> seatDetailEntities = orderEntity.getSeatDetailEntities();
                seatDetailEntities.add(seatDetailEntity);
                orderEntity.setSeatDetailEntities(seatDetailEntities);
            }
            else{
                orderEntity.setSeatDetailEntities(Collections.singletonList(seatDetailEntity));
            }
            orderService.create(orderEntity);
            return seatDetailEntity;
        }
        return null;
    }

    @Override
    public SeatDetailEntity mapToEntity(SeatDetailDTO seatDetailDTO) {
        return mapper.convertValue(seatDetailDTO, SeatDetailEntity.class);
    }

    @Override
    public SeatDetailDTO mapToDto(SeatDetailEntity seatDetailEntity) {
        return mapper.convertValue(seatDetailEntity, SeatDetailDTO.class);
    }
}
