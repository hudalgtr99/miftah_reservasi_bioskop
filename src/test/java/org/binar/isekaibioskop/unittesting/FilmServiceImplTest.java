package org.binar.isekaibioskop.unittesting;


import org.binar.isekaibioskop.entity.FilmEntity;
import org.binar.isekaibioskop.repository.FilmRepository;
import org.binar.isekaibioskop.service.impl.FilmServiceImpl;
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

class FilmServiceImplTest {
    @InjectMocks
    FilmServiceImpl filmServiceImpl;

    @Mock
    FilmRepository filmRepository;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Create film success")
    void MockTestCreateFilm() {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(Long.valueOf("1"));
        filmEntity.setName("Kanojo Okairishimasu");
        filmEntity.setShowStatus(true);
        Mockito.when(filmRepository.save(filmEntity)).thenReturn(filmEntity);
        Assertions.assertEquals(filmEntity, filmServiceImpl.create(filmEntity));
    }

    public static List<FilmEntity> getDataFilm() {
        List<FilmEntity> listFilm = new ArrayList<>();
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(Long.valueOf("1"));
        filmEntity.setName("Kanojo Okairishimasu");
        filmEntity.setShowStatus(true);
        filmEntity.setDuration(180);
        filmEntity.setLanguage("Japanese");
        filmEntity.setDescription("Anime Romance tentang rental Pacar");
        listFilm.add(filmEntity);
        return listFilm;
    }

    @Test
    @DisplayName("Getting all film Success")
    void MockTestGetAllFilmSuccess() {
        List<FilmEntity> filmEntities = getDataFilm();
        Mockito.when(filmRepository.findAll()).thenReturn(filmEntities);

        var actualValue = filmServiceImpl.findAll();
        Assertions.assertEquals(1, actualValue.size());
        Assertions.assertEquals("Kanojo Okairishimasu", actualValue.get(0).getName());
        Assertions.assertEquals("Japanese", actualValue.get(0).getLanguage());

    }

    @Test
    @DisplayName("Update film success")
    void MockTestUpdateFilm() {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(Long.valueOf("1"));
        filmEntity.setName("Kanojo Okairishimasu");
        filmEntity.setShowStatus(true);

        Mockito.when(filmRepository.findById(1L)).thenReturn(Optional.of(filmEntity));
        Mockito.when(filmRepository.save(filmEntity)).thenReturn(filmEntity);

        var actualValue = filmServiceImpl.update(1L, filmEntity);
        Assertions.assertEquals(1L, actualValue.getId());
        Assertions.assertEquals("Kanojo Okairishimasu", actualValue.getName());
    }

    @Test
    @DisplayName("Getting Film By Id")
    void MockTestFilmFindById() {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(Long.valueOf("1"));
        filmEntity.setName("Kanojo Okairishimasu");
        filmEntity.setShowStatus(true);

        Mockito.when(filmRepository.findById(Long.valueOf("1"))).thenReturn(Optional.of(filmEntity));

        var actualValue = filmServiceImpl.update(1L, filmEntity);
        Assertions.assertEquals(1L, actualValue.getId());
        Assertions.assertEquals("Kanojo Okairishimasu", actualValue.getName());
        Assertions.assertNotNull(actualValue);
    }


    @Test
    @DisplayName("Getting Film not found")
    void MockTestGetFilmNotFound() {
        Exception e = Assertions.assertThrows(Exception.class, () -> Mockito.verify(filmServiceImpl.findById(Long.valueOf("NOT FOUND"))));
        Assertions.assertNotNull(e.getMessage());
    }
}