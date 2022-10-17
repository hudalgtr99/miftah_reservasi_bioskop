package com.example.reservasibioskop.dto;

import com.example.reservasibioskop.entity.FilmEntity;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.LocalDateTime;

public record ScheduleDTO(
        Long id,
        FilmEntity filmEntity,
        LocalDate showDate,
        LocalTime startTime,
        LocalTime endTime
//        LocalDateTime createdAt,
//        LocalDateTime updatedAt
        ) {
}
