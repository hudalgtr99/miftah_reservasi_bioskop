package org.binaracademy.movieservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Table(name = "Schedules")
public class ScheduleEntity extends BaseEntity{

    @Column(name = "show_date")
    private String showDate;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    private BigDecimal price;

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private FilmEntity filmDetail;

}