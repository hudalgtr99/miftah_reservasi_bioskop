package com.example.reservasibioskop.repository;

import com.example.reservasibioskop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
