package com.example.reservasibioskop.service.embedded;

import com.example.reservasibioskop.dto.embedded.SeatDetailDTO;
import com.example.reservasibioskop.entity.embedded.SeatDetailEntity;

public interface SeatDetailService {
    SeatDetailEntity addSeatDetail(Long orderId, SeatDetailEntity seatDetailEntity);

    SeatDetailEntity mapToEntity(SeatDetailDTO seatDetailDto);
    SeatDetailDTO mapToDto(SeatDetailEntity seatDetailEntity);
}
