package org.binar.isekaibioskop.service.impl.embedded;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.binar.isekaibioskop.dto.embedded.SeatDetailDTO;
import org.binar.isekaibioskop.entity.OrderEntity;
import org.binar.isekaibioskop.entity.embedded.SeatDetailEntity;
import org.binar.isekaibioskop.repository.embedded.SeatDetailRepository;
import org.binar.isekaibioskop.service.OrderService;
import org.binar.isekaibioskop.service.embedded.SeatDetailService;
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