package com.example.reservasibioskop.repository;

import com.example.reservasibioskop.entity.StudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<StudioEntity, Long> {
}
