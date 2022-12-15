package org.binar.isekaibioskop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binar.isekaibioskop.entity.embedded.SeatDetailEntity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrderDTO{
        Long id;
        UserDTO userDetails;
        ScheduleDTO scheduleDetails;
        FilmDTO filmDetails;
}