package org.binar.isekaibioskop.repository;

import org.binar.isekaibioskop.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
}