package org.binar.isekaibioskop.dto.embedded;

import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.entity.StudioEntity;
import org.binar.isekaibioskop.entity.embedded.SeatDetailId;

public record SeatDetailDTO(
        SeatDetailId seatDetailId,
        StudioEntity studioEntity,
        SeatEntity seatEntity
){
}