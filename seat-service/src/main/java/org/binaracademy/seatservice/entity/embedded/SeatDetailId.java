package org.binaracademy.seatservice.entity.embedded;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class SeatDetailId implements Serializable {

    @Column(name = "Studios_id")
    private Long studiosId;

    @Column(name = "Seats_id")
    private Long seatsId;

}