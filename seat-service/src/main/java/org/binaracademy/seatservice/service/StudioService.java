package org.binaracademy.seatservice.service;

import org.binaracademy.seatservice.dto.StudioDTO;
import org.binaracademy.seatservice.entity.StudioEntity;

import java.util.List;

public interface StudioService {
    StudioEntity create(StudioEntity studioEntity);
    StudioEntity update(Long id, StudioEntity studioEntity);
    StudioEntity delete(Long id);
    List<StudioEntity> findAll();
    StudioEntity findById(Long id);

    StudioDTO mapToDto(StudioEntity studioEntity);
    StudioEntity mapToEntity(StudioDTO studioDTO);
}