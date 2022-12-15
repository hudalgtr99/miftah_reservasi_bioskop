package org.binar.isekaibioskop.service.impl.embedded;

import org.binar.isekaibioskop.dto.embedded.SeatDetailDTO;
import org.binar.isekaibioskop.entity.embedded.SeatDetailEntity;
import org.binar.isekaibioskop.entity.embedded.SeatDetailId;

import java.util.List;

public interface SeatDetailService {
    SeatDetailEntity create(SeatDetailEntity seatDetailEntity);
    SeatDetailEntity delete(SeatDetailId seatDetailId);
    List<SeatDetailEntity> findAll();
    SeatDetailEntity findById(SeatDetailId seatDetailId);
    SeatDetailDTO mapToDto(SeatDetailEntity seatDetailEntity);
    SeatDetailEntity mapToEntity(SeatDetailDTO SeatDetailDTO);

}
