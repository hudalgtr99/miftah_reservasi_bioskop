package org.binar.isekaibioskop.service.embedded;


import org.binar.isekaibioskop.dto.embedded.SeatDetailDTO;
import org.binar.isekaibioskop.entity.embedded.SeatDetailEntity;

public interface SeatDetailService {
    SeatDetailEntity addSeatDetail(Long orderId, SeatDetailEntity seatDetailEntity);

    SeatDetailEntity mapToEntity(SeatDetailDTO seatDetailDto);
    SeatDetailDTO mapToDto(SeatDetailEntity seatDetailEntity);
}