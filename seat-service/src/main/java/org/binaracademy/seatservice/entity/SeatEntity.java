package org.binaracademy.seatservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Table(name = "Seats")
public class SeatEntity extends BaseEntity{

    @Column(name = "seat_row")
    private String seatRow;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "full_status")
    private Boolean fullStatus;

}
