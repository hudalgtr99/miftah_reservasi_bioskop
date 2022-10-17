package com.example.reservasibioskop.entity.embedded;

//import org.hibernate.Hibernate;
//import java.util.Objects;

import com.example.reservasibioskop.entity.SeatEntity;
import com.example.reservasibioskop.entity.StudioEntity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;


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

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        SeatDetailEntity that = (SeatDetailEntity) o;
//        return seatDetailId != null && Objects.equals(seatDetailId, that.seatDetailId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(seatDetailId);
//    }
}
