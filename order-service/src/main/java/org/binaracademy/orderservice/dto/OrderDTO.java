package org.binaracademy.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
