package org.binar.isekaibioskop.entity.embedded;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@Embeddable
public class SeatDetailId implements Serializable {

    @Column(name = "Studios_id")
    private Long studiosId;

    @Column(name = "Seats_id")
    private Long seatsId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SeatDetailId that = (SeatDetailId) o;
        return studiosId != null && Objects.equals(studiosId, that.studiosId)
                && seatsId != null && Objects.equals(seatsId, that.seatsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studiosId, seatsId);
    }
}