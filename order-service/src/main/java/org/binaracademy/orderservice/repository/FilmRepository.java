package org.binaracademy.orderservice.repository;

import org.binaracademy.orderservice.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
}