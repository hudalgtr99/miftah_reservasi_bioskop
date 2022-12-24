package org.binaracademy.seatservice.repository;

import org.binaracademy.seatservice.entity.StudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<StudioEntity, Long> {
}