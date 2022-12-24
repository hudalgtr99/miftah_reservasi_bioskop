package org.binaracademy.movieservice.repository;

import org.binaracademy.movieservice.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}