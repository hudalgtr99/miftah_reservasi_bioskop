package com.example.reservasibioskop.dto;

//import java.time.LocalDateTime;

public record FilmDTO(
        Long code,
        String name,
        String description,
        Integer duration,
        String language,
        Boolean showStatus
//        LocalDateTime createdAt,
//        LocalDateTime updatedAt
        ) {

}
