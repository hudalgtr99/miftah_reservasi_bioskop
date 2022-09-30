package com.example.reservasibioskop.repository.embedded;

import com.example.reservasibioskop.entity.embedded.SeatDetailEntity;
import com.example.reservasibioskop.entity.embedded.SeatDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatDetailRepository extends JpaRepository<SeatDetailEntity, SeatDetailId> {
}
