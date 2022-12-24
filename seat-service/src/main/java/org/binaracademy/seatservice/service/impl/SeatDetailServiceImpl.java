package org.binaracademy.seatservice.service.impl;

import org.binaracademy.seatservice.dto.embedded.SeatDetailDTO;
import org.binaracademy.seatservice.entity.embedded.SeatDetailEntity;
import org.binaracademy.seatservice.entity.embedded.SeatDetailId;
import org.binaracademy.seatservice.exception.DataNotFoundException;
import org.binaracademy.seatservice.repository.embedded.SeatDetailRepository;
import org.binaracademy.seatservice.service.SeatDetailService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SeatDetailServiceImpl implements SeatDetailService {

    private static final String ENTITY = "seatDetailEntity";
    private final Logger log =  LoggerFactory.getLogger(SeatDetailServiceImpl.class);

    @Autowired
    SeatDetailRepository seatDetailRepository;

    @Override
    public SeatDetailEntity create(SeatDetailEntity seatDetailEntity) {
        log.info("Has successfully created seat detail data!");
        return seatDetailRepository.save(seatDetailEntity);
    }

    @Override
    public List<SeatDetailEntity> findAll() {
        log.info("Has successfully found all seat detail data!");
        return seatDetailRepository.findAll();
    }

    @Override
    public SeatDetailEntity findById(SeatDetailId seatDetailId) {
        SeatDetailEntity seatDetailEntity = seatDetailRepository.findById(seatDetailId)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "seatDetailId", seatDetailId.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        log.info("Has successfully found seat detail data from id " + seatDetailId);
        return seatDetailEntity;
    }

    public SeatDetailEntity delete(SeatDetailId seatDetailId) {
        SeatDetailEntity result = seatDetailRepository.findById(seatDetailId)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "seatDetailId", seatDetailId.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        seatDetailRepository.delete(result);
        log.info("Has successfully deleted city data!");
        return result;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public SeatDetailDTO mapToDto(SeatDetailEntity seatDetailEntity) {
        return mapper.map(seatDetailEntity, SeatDetailDTO.class);
    }

    @Override
    public SeatDetailEntity mapToEntity(SeatDetailDTO seatDetailDTO) {
        return mapper.map(seatDetailDTO, SeatDetailEntity.class);
    }

}