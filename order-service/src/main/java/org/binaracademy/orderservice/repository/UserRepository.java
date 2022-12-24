package org.binaracademy.orderservice.repository;

import org.binaracademy.orderservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}