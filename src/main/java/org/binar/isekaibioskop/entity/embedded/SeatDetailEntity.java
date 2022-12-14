package org.binar.isekaibioskop.entity.embedded;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.binar.isekaibioskop.entity.OrderEntity;
import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.entity.StudioEntity;

import javax.persistence.*;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"orderEntity"}, allowGetters = true)
@Table(name = "Seat_Details")
public class SeatDetailEntity{

    @EmbeddedId
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

    @OneToOne(mappedBy = "seatDetailEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private OrderEntity orderEntity;
}