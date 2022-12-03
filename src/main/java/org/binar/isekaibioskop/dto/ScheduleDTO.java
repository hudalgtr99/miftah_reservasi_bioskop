package org.binar.isekaibioskop.dto;

import org.binar.isekaibioskop.entity.FilmEntity;

import java.math.BigDecimal;

public record ScheduleDTO(Long id,
                          FilmEntity filmEntity,
                          String showDate,
                          String startTime,
                          String endTime,
                          BigDecimal price) {
}