package org.binaracademy.orderservice.repository;

import org.binaracademy.orderservice.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}