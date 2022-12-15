package org.binar.isekaibioskop.dto.embedded;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.entity.StudioEntity;
import org.binar.isekaibioskop.entity.embedded.SeatDetailId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SeatDetailDTO{
        SeatDetailId seatDetailId;
        StudioEntity studioEntity;
        SeatEntity seatEntity;
}