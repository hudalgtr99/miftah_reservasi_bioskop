package com.example.reservasibioskop.dto;

import java.util.Date;

public record UserDTO(
        Long id,
        String username,
        String email,
        String password,
        Date createdAt,
        Date updatedAt
        ) {
}
