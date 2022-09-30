package com.example.reservasibioskop.dto;

import java.util.Date;

public record FilmDTO(
        Long code,
        String name,
        String description,
        Integer duration,
        String language,
        Boolean showStatus,
        Date createdAt,
        Date updatedAt
        ) {

}
