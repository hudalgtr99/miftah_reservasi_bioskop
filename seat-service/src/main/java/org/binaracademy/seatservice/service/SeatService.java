package org.binaracademy.seatservice.service;

import org.binaracademy.seatservice.dto.SeatDTO;
import org.binaracademy.seatservice.entity.SeatEntity;

import java.util.List;

public interface SeatService {
    SeatEntity create(SeatEntity seatEntity);
    SeatEntity update(Long id, SeatEntity seatEntity);
    SeatEntity delete(Long id);
    List<SeatEntity> findAll();
    SeatEntity findById(Long id);

    SeatDTO mapToDto(SeatEntity seatEntity);
    SeatEntity mapToEntity(SeatDTO seatDTO);
}