package com.example.reservasibioskop.entity.embedded;

import com.example.reservasibioskop.entity.SeatEntity;
import com.example.reservasibioskop.entity.StudioEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

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
