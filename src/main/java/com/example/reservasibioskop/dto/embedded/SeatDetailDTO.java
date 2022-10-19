package com.example.reservasibioskop.dto.embedded;

import com.example.reservasibioskop.entity.SeatEntity;
import com.example.reservasibioskop.entity.StudioEntity;
import com.example.reservasibioskop.entity.embedded.SeatDetailId;

//import java.time.LocalDateTime;

public record SeatDetailDTO(
        SeatDetailId seatDetailId,
        StudioEntity studioEntity,
        SeatEntity seatEntity
//        LocalDateTime createdAt,
//        LocalDateTime updatedAt
        ){
}
