package org.binar.isekaibioskop.dto;

public record SeatDTO(Long id,
                      Character seatRow,
                      Integer seatNumber,
                      Boolean fullStatus) {
}