package com.example.reservasibioskop.dto;

import com.example.reservasibioskop.entity.ScheduleEntity;
import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.entity.embedded.SeatDetailEntity;

//import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        Long id,
        UserEntity userEntity,
        ScheduleEntity scheduleEntity,
        List<SeatDetailEntity> seatDetailEntities,
        Integer quantity
//        LocalDateTime createdAt,
//        LocalDateTime updatedAt
) {
}
