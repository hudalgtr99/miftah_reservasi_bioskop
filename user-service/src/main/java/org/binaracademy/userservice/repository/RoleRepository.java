package org.binaracademy.userservice.repository;

import org.binaracademy.userservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
