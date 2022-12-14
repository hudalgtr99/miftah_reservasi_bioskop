package org.binar.isekaibioskop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Table(name = "Seats")
public class SeatEntity extends BaseEntity{

    @Column(name = "seat_row")
    private Character seatRow;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "full_status")
    private Boolean fullStatus;

}