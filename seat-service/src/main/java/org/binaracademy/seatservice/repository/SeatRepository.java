package org.binaracademy.seatservice.repository;

import org.binaracademy.seatservice.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
}