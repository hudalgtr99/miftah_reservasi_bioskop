package org.binar.isekaibioskop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.binar.isekaibioskop.dto.SeatDTO;
import org.binar.isekaibioskop.dto.SeatDTO;
import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.exception.DataNotFoundException;
import org.binar.isekaibioskop.repository.SeatRepository;
import org.binar.isekaibioskop.repository.SeatRepository;
import org.binar.isekaibioskop.service.SeatService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {

    private static final String ENTITY = "seatEntity";
    private final Logger log =  LoggerFactory.getLogger(SeatServiceImpl.class);

    @Autowired
    SeatRepository seatRepository;

    @Override
    public SeatEntity create(SeatEntity seatEntity) {
        log.info("Has successfully created seat data!");
        return seatRepository.save(seatEntity);
    }

    @Override
    public SeatEntity update(Long id, SeatEntity seatEntity) {
        SeatEntity result = seatRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });

        result.setSeatRow(seatEntity.getSeatRow());
        result.setSeatNumber(seatEntity.getSeatNumber());
        result.setFullStatus(seatEntity.getFullStatus());
        seatRepository.save(result);
        log.info("Has successfully updated seat data!");
        return result;
    }

    @Override
    public SeatEntity delete(Long id) {
        SeatEntity result = seatRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        seatRepository.delete(result);
        log.info("Has successfully deleted seat data!");
        return result;
    }

    @Override
    public List<SeatEntity> findAll() {
        log.info("Has successfully found all seat data!");
        return seatRepository.findAll();
    }
    @Override
    public SeatEntity findById(Long id) {
        SeatEntity seatEntity = seatRepository.findById(id)
                .orElseThrow(() -> {
                    DataNotFoundException exception = new DataNotFoundException(ENTITY, "id", id.toString());
                    log.info("Error");
                    exception.setApiResponse();
                    throw exception;
                });
        log.info("Has successfully found seat data from id " + id);
        return seatEntity;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public SeatDTO mapToDto(SeatEntity seatEntity) {
        return mapper.map(seatEntity, SeatDTO.class);
    }

    @Override
    public SeatEntity mapToEntity(SeatDTO seatDTO) {
        return mapper.map(seatDTO, SeatEntity.class);
    }

}