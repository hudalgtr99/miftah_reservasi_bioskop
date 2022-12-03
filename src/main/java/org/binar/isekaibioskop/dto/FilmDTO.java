package org.binar.isekaibioskop.dto;

import java.util.List;

public record FilmDTO(Long code,
                      String name,
                      String description,
                      Integer duration,
                      String language,
                      Boolean showStatus,
                      List<ScheduleDTO> scheduleEntities) {
}