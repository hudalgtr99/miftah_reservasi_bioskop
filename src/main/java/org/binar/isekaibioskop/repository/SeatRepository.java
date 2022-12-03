package org.binar.isekaibioskop.repository;

import org.binar.isekaibioskop.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
}