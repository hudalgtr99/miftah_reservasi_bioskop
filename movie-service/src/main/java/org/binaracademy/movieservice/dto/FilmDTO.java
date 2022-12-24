package org.binaracademy.movieservice.dto;

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
public class FilmDTO{
    String name;
    String description;
    Integer duration;
    String language;
    Boolean showStatus;
}