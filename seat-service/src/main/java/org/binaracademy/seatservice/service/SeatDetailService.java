package org.binaracademy.seatservice.service;

import org.binaracademy.seatservice.dto.embedded.SeatDetailDTO;
import org.binaracademy.seatservice.entity.embedded.SeatDetailEntity;
import org.binaracademy.seatservice.entity.embedded.SeatDetailId;

import java.util.List;

public interface SeatDetailService {
    SeatDetailEntity create(SeatDetailEntity seatDetailEntity);
    SeatDetailEntity delete(SeatDetailId seatDetailId);
    List<SeatDetailEntity> findAll();
    SeatDetailEntity findById(SeatDetailId seatDetailId);
    SeatDetailDTO mapToDto(SeatDetailEntity seatDetailEntity);
    SeatDetailEntity mapToEntity(SeatDetailDTO SeatDetailDTO);

}