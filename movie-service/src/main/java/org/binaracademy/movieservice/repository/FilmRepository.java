package org.binaracademy.movieservice.repository;

import org.binaracademy.movieservice.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
}
