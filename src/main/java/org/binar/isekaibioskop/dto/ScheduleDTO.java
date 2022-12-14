package org.binar.isekaibioskop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binar.isekaibioskop.entity.FilmEntity;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ScheduleDTO{
    Long id;
    FilmDTO filmDetails;
    String showDate;
    String startTime;
    String endTime;
    BigDecimal price;
}