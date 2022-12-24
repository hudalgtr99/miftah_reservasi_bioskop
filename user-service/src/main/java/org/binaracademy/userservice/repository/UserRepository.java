package org.binaracademy.userservice.repository;

import org.binaracademy.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}