package org.binaracademy.seatservice.entity.embedded;

import lombok.*;
import org.binaracademy.seatservice.entity.SeatEntity;
import org.binaracademy.seatservice.entity.StudioEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Seat_Details")
public class SeatDetailEntity{

    @EmbeddedId
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SeatDetail_id")
    private SeatDetailId seatDetailId;

    @MapsId("studiosId")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "Studios_id")
    private StudioEntity studioEntity;

    @MapsId("seatsId")
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "Seats_id")
    private SeatEntity seatEntity;

}