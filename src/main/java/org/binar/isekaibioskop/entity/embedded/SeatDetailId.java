package org.binar.isekaibioskop.entity.embedded;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class SeatDetailId implements Serializable {

    @Column(name = "Studios_id")
    private Long studiosId;

    @Column(name = "Seats_id")
    private Long seatsId;

}