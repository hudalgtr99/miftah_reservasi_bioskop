package com.example.reservasibioskop.dto;

import com.example.reservasibioskop.entity.FilmEntity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public record ScheduleDTO(
        Long id,
        FilmEntity filmEntity,
        LocalDate showDate,
        LocalTime startTime,
        LocalTime endTime,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
        ) {
}
