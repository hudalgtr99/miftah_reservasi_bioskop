package org.binar.isekaibioskop.entity;

//import org.hibernate.Hibernate;
//import java.util.Objects;

import lombok.*;
import javax.persistence.*;
//import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Seats")
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_row")
    private Character seatRow;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "full_status")
    private Boolean fullStatus;

}