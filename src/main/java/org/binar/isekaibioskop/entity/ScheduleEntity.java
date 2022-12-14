package org.binar.isekaibioskop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"createdAt", "updatedAt", "orderEntity"}, allowGetters = true)
@Table(name = "Schedules")
public class ScheduleEntity extends BaseEntity{

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "film_id")
    private FilmEntity filmDetails;

    @Column(name = "show_date")
    private String showDate;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    private BigDecimal price;

    @OneToOne(mappedBy = "scheduleDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private OrderEntity orderEntity;
}