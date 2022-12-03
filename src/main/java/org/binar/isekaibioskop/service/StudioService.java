package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.dto.StudioDTO;
import org.binar.isekaibioskop.entity.StudioEntity;

import java.util.List;

public interface StudioService {
    StudioEntity create(StudioEntity studioEntity);
    StudioEntity update(Long id, StudioEntity studioEntity);
    Boolean delete(Long id);
    List<StudioEntity> findAll();
    StudioEntity findById(Long id);

    StudioDTO mapToDto(StudioEntity studioEntity);
    StudioEntity mapToEntity(StudioDTO studioDTO);
}