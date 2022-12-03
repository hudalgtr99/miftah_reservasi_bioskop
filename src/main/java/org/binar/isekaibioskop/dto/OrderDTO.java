package org.binar.isekaibioskop.dto;

import org.binar.isekaibioskop.entity.FilmEntity;
import org.binar.isekaibioskop.entity.ScheduleEntity;
import org.binar.isekaibioskop.entity.UserEntity;
import org.binar.isekaibioskop.entity.embedded.SeatDetailEntity;

import java.util.List;

public record OrderDTO(
        Long id,
        UserEntity userEntity,
        FilmEntity filmEntity,
//        ScheduleEntity scheduleEntity,
        List<SeatDetailEntity> seatDetailEntities,
        Integer quantity
) {
}