package org.binar.isekaibioskop.repository;

import org.binar.isekaibioskop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}