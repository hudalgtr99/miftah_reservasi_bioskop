package org.binar.isekaibioskop.repository.embedded;

import org.binar.isekaibioskop.entity.embedded.SeatDetailEntity;
import org.binar.isekaibioskop.entity.embedded.SeatDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatDetailRepository extends JpaRepository<SeatDetailEntity, SeatDetailId> {
}