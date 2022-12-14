package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.dto.SeatDTO;
import org.binar.isekaibioskop.entity.SeatEntity;

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