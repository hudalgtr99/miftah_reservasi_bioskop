package org.binar.isekaibioskop.entity.embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.entity.StudioEntity;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SeatDetailEntity that = (SeatDetailEntity) o;
        return seatDetailId != null && Objects.equals(seatDetailId, that.seatDetailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatDetailId);
    }
}