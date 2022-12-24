package org.binaracademy.seatservice.dto.embedded;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binaracademy.seatservice.entity.SeatEntity;
import org.binaracademy.seatservice.entity.StudioEntity;
import org.binaracademy.seatservice.entity.embedded.SeatDetailId;

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