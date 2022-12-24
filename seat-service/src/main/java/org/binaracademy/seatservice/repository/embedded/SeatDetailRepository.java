package org.binaracademy.seatservice.repository.embedded;

import org.binaracademy.seatservice.entity.embedded.SeatDetailEntity;
import org.binaracademy.seatservice.entity.embedded.SeatDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatDetailRepository extends JpaRepository<SeatDetailEntity, SeatDetailId> {
}