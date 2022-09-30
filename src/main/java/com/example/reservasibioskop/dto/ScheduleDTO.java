package com.example.reservasibioskop.dto;

import com.example.reservasibioskop.entity.FilmEntity;

import java.sql.Time;
import java.util.Date;

public record ScheduleDTO(
        Long id,
        FilmEntity filmEntity,
        Date showDate,
        Time startTime,
        Time endTime,
        Date createdAt,
        Date updatedAt
        ) {
}
