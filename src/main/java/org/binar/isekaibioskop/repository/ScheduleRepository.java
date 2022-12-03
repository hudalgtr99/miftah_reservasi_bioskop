package org.binar.isekaibioskop.repository;

import org.binar.isekaibioskop.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}