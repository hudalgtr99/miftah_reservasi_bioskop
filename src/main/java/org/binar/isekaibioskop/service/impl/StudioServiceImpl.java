package org.binar.isekaibioskop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.binar.isekaibioskop.dto.StudioDTO;
import org.binar.isekaibioskop.entity.StudioEntity;
import org.binar.isekaibioskop.repository.StudioRepository;
import org.binar.isekaibioskop.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudioServiceImpl implements StudioService {

    @Autowired
    StudioRepository studioRepository;


    @Override
    public StudioEntity create(StudioEntity studioEntity) {
        StudioEntity result = studioRepository.save(studioEntity);
        return result;
    }

    @Override
    public StudioEntity update(Long id, StudioEntity studioEntity) {
        StudioEntity result = findById(id);
        if (result != null) {
            result.setName(studioEntity.getName());
            result.setFullStatus(studioEntity.getFullStatus());
            return studioRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        StudioEntity result = findById(id);
        if (result != null) {
            studioRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<StudioEntity> findAll() {
        return studioRepository.findAll();
    }

    @Override
    public StudioEntity findById(Long id) {
        Optional<StudioEntity> result = studioRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public StudioDTO mapToDto(StudioEntity studioEntity) {
        return mapper.convertValue(studioEntity, StudioDTO.class);
    }

    @Override
    public StudioEntity mapToEntity(StudioDTO studioDTO) {
        return mapper.convertValue(studioDTO, StudioEntity.class);
    }
}