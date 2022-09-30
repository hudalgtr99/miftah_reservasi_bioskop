package com.example.reservasibioskop.repository;

import com.example.reservasibioskop.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
}
