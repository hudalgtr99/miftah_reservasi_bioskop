package com.example.reservasibioskop.repository;

import com.example.reservasibioskop.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
}
