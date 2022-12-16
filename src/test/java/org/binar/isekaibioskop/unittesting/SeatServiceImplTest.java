package org.binar.isekaibioskop.unittesting;

import org.binar.isekaibioskop.entity.SeatEntity;
import org.binar.isekaibioskop.repository.SeatRepository;
import org.binar.isekaibioskop.service.impl.SeatServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SeatServiceImplTest {
    @InjectMocks
    SeatServiceImpl seatServiceImpl;

    @Mock
    SeatRepository seatRepository;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Create seat success")
    void MockTestCreateSeat() {
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setId(Long.valueOf("1"));
        seatEntity.setSeatRow("Seat A");
        seatEntity.setSeatNumber(1);
        seatEntity.setFullStatus(true);
        Mockito.when(seatRepository.save(seatEntity)).thenReturn(seatEntity);
        Assertions.assertEquals(seatEntity, seatServiceImpl.create(seatEntity));
    }

    public static List<SeatEntity> getDataSeat() {
        List<SeatEntity> listSeat = new ArrayList<>();
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setId(Long.valueOf("1"));
        seatEntity.setSeatRow("Seat A");
        seatEntity.setSeatNumber(1);
        seatEntity.setFullStatus(true);
        listSeat.add(seatEntity);
        return listSeat;
    }

    @Test
    @DisplayName("Getting all seat Success")
    void MockTestGetAllSeatSuccess() {
        List<SeatEntity> seatEntities = getDataSeat();
        Mockito.when(seatRepository.findAll()).thenReturn(seatEntities);

        var actualValue = seatServiceImpl.findAll();
        Assertions.assertEquals(1, actualValue.size());
        Assertions.assertEquals("Seat A", actualValue.get(0).getSeatRow());
        Assertions.assertEquals(1, actualValue.get(0).getSeatNumber());
    }

    @Test
    @DisplayName("Update seat success")
    void MockTestUpdateSeat() {
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setId(Long.valueOf("1"));
        seatEntity.setSeatRow("Seat A");
        seatEntity.setSeatNumber(1);
        seatEntity.setFullStatus(true);

        Mockito.when(seatRepository.findById(1L)).thenReturn(Optional.of(seatEntity));
        Mockito.when(seatRepository.save(seatEntity)).thenReturn(seatEntity);

        var actualValue = seatServiceImpl.update(1L, seatEntity);
        Assertions.assertEquals(1L, actualValue.getId());
        Assertions.assertEquals("Seat A", actualValue.getSeatRow());
        Assertions.assertEquals(1, actualValue.getSeatNumber());
    }

    @Test
    @DisplayName("Getting Seat By Id")
    void MockTestSeatFindById() {
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setId(Long.valueOf("1"));
        seatEntity.setSeatRow("Seat A");
        seatEntity.setSeatNumber(1);
        seatEntity.setFullStatus(true);

        Mockito.when(seatRepository.findById(Long.valueOf("1"))).thenReturn(Optional.of(seatEntity));

        var actualValue = seatServiceImpl.update(1L, seatEntity);
        Assertions.assertEquals(1L, actualValue.getId());
        Assertions.assertEquals("Seat A", actualValue.getSeatRow());
        Assertions.assertEquals(1, actualValue.getSeatNumber());
        Assertions.assertNotNull(actualValue);
    }


    @Test
    @DisplayName("Getting Seat not found")
    void MockTestGetSeatNotFound() {
        Exception e = Assertions.assertThrows(Exception.class, () -> Mockito.verify(seatServiceImpl.findById(Long.valueOf("NOT FOUND"))));
        Assertions.assertNotNull(e.getMessage());
    }

}
