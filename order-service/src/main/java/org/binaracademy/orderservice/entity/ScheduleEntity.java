package org.binaracademy.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt", "orderEntity"}, allowGetters = true)
@Table(name = "Schedules")
public class ScheduleEntity extends BaseEntity{


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