package org.binar.isekaibioskop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.binar.isekaibioskop.dto.SeatDTO;
import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.repository.SeatRepository;
import org.binar.isekaibioskop.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;


    @Override
    public SeatEntity create(SeatEntity seatEntity) {
        SeatEntity result = seatRepository.save(seatEntity);
        return result;
    }

    @Override
    public SeatEntity update(Long id, SeatEntity seatEntity) {
        SeatEntity result = findById(id);
        if (result != null) {
            result.setSeatRow(seatEntity.getSeatRow());
            result.setSeatNumber(seatEntity.getSeatNumber());
            result.setFullStatus(seatEntity.getFullStatus());
            return seatRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        SeatEntity result = findById(id);
        if (result != null) {
            seatRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<SeatEntity> findAll() {
        return seatRepository.findAll();
    }

    @Override
    public SeatEntity findById(Long id) {
        Optional<SeatEntity> result = seatRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public SeatDTO mapToDto(SeatEntity seatEntity) {
        return mapper.convertValue(seatEntity, SeatDTO.class);
    }

    @Override
    public SeatEntity mapToEntity(SeatDTO seatDTO) {
        return mapper.convertValue(seatDTO, SeatEntity.class);
    }
}