package org.binaracademy.movieservice.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ScheduleRequest {

    private Long filmId;
    private String showDate;
    private String startTime;
    private String endTime;
    private BigDecimal price;

}