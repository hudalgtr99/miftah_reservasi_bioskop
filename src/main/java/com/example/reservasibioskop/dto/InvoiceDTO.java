package com.example.reservasibioskop.dto;

public record InvoiceDTO(
        Long id,
        String username,
        String filmName,
        String showDate,
        String seatDetail,
        Integer price
) {
}
