package com.example.reservasibioskop.repository;

import com.example.reservasibioskop.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, String> {

}