package org.binar.isekaibioskop.unittesting;

import org.binar.isekaibioskop.entity.StudioEntity;
import org.binar.isekaibioskop.repository.StudioRepository;
import org.binar.isekaibioskop.service.impl.StudioServiceImpl;
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

public class StudioServiceImplTest {
    @InjectMocks
    StudioServiceImpl studioServiceImpl;

    @Mock
    StudioRepository studioRepository;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Create studio success")
    void MockTestCreateStudio() {
        StudioEntity studioEntity = new StudioEntity();
        studioEntity.setId(Long.valueOf("1"));
        studioEntity.setName("Studio A");
        studioEntity.setFullStatus(true);
        Mockito.when(studioRepository.save(studioEntity)).thenReturn(studioEntity);
        Assertions.assertEquals(studioEntity, studioServiceImpl.create(studioEntity));
    }

    public static List<StudioEntity> getDataStudio() {
        List<StudioEntity> listStudio = new ArrayList<>();
        StudioEntity studioEntity = new StudioEntity();
        studioEntity.setId(Long.valueOf("1"));
        studioEntity.setName("Studio A");
        studioEntity.setFullStatus(true);
        listStudio.add(studioEntity);
        return listStudio;
    }

    @Test
    @DisplayName("Getting all studio Success")
    void MockTestGetAllStudioSuccess() {
        List<StudioEntity> studioEntities = getDataStudio();
        Mockito.when(studioRepository.findAll()).thenReturn(studioEntities);

        var actualValue = studioServiceImpl.findAll();
        Assertions.assertEquals(1, actualValue.size());
        Assertions.assertEquals("Studio A", actualValue.get(0).getName());

    }

    @Test
    @DisplayName("Update studio success")
    void MockTestUpdateStudio() {
        StudioEntity studioEntity = new StudioEntity();
        studioEntity.setId(Long.valueOf("1"));
        studioEntity.setName("Studio A");
        studioEntity.setFullStatus(true);

        Mockito.when(studioRepository.findById(1L)).thenReturn(Optional.of(studioEntity));
        Mockito.when(studioRepository.save(studioEntity)).thenReturn(studioEntity);

        var actualValue = studioServiceImpl.update(1L, studioEntity);
        Assertions.assertEquals(1L, actualValue.getId());
        Assertions.assertEquals("Studio A", actualValue.getName());
    }

    @Test
    @DisplayName("Getting Studio By Id")
    void MockTestStudioFindById() {
        StudioEntity studioEntity = new StudioEntity();
        studioEntity.setId(Long.valueOf("1"));
        studioEntity.setName("Studio A");
        studioEntity.setFullStatus(true);

        Mockito.when(studioRepository.findById(Long.valueOf("1"))).thenReturn(Optional.of(studioEntity));

        var actualValue = studioServiceImpl.update(1L, studioEntity);
        Assertions.assertEquals(1L, actualValue.getId());
        Assertions.assertEquals("Studio A", actualValue.getName());
        Assertions.assertNotNull(actualValue);
    }


    @Test
    @DisplayName("Getting Studio not found")
    void MockTestGetStudioNotFound() {
        Exception e = Assertions.assertThrows(Exception.class, () -> Mockito.verify(studioServiceImpl.findById(Long.valueOf("NOT FOUND"))));
        Assertions.assertNotNull(e.getMessage());
    }

}
