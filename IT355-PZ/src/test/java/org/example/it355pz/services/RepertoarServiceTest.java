package org.example.it355pz.services;



import org.example.it355pz.crud.RepertoarUpdate;
import org.example.it355pz.entity.Repertoar;
import org.example.it355pz.repository.RepertoarRepository;
import org.example.it355pz.service.RepertoarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RepertoarServiceTest {

    @Mock
    private RepertoarRepository repertoarRepository;

    @InjectMocks
    private RepertoarService repertoarService;

    private Repertoar repertoar;

    @BeforeEach
    void setUp() {
        repertoar = new Repertoar();
        repertoar.setIdRepertoar(1L);
        repertoar.setFilm("Film 1");
        repertoar.setReziser("Reziser 1");
        repertoar.setZanr("Zanr 1");
        repertoar.setTrajanje(120);
        repertoar.setOcena(5.0);
        repertoar.setProjekcija("Projekcija 1");
        repertoar.setCenaKarte(500.00);
        repertoar.setImgRepertoar("img.jpg");
    }

    @Test
    void registerRepertoar() {
        when(repertoarRepository.save(any(Repertoar.class))).thenReturn(repertoar);
        Repertoar savedRepertoar = repertoarService.registerRepertoar(repertoar);
        assertNotNull(savedRepertoar);
        assertEquals(repertoar.getFilm(), savedRepertoar.getFilm());
        verify(repertoarRepository, times(1)).save(repertoar);
    }

    @Test
    void getRepertoare() {
        List<Repertoar> repertoarList = new ArrayList<>();
        repertoarList.add(repertoar);
        when(repertoarRepository.findAll()).thenReturn(repertoarList);
        List<Repertoar> repertoari = repertoarService.getRepertoare();
        assertFalse(repertoari.isEmpty());
        assertEquals(1, repertoari.size());
        verify(repertoarRepository, times(1)).findAll();
    }

    @Test
    void deleteRepertoar() {
        when(repertoarRepository.existsById(anyLong())).thenReturn(true);
        boolean isDeleted = repertoarService.deleteRepertoar(1L);
        assertTrue(isDeleted);
        verify(repertoarRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateRepertoar() {
        RepertoarUpdate repertoarUpdate = new RepertoarUpdate();
        repertoarUpdate.setIdRepertoar(1L);
        repertoarUpdate.setFilm("Updated Film");
        repertoarUpdate.setReziser("Updated Reziser");
        repertoarUpdate.setZanr("Updated Zanr");
        repertoarUpdate.setTrajanje(90);
        repertoarUpdate.setOcena(4.0);
        repertoarUpdate.setProjekcija("Updated Projekcija");
        repertoarUpdate.setCenaKarte(600.0);
        repertoarUpdate.setImgRepertoar("updated_img.jpg");

        when(repertoarRepository.findById(anyLong())).thenReturn(Optional.of(repertoar));

        String response = repertoarService.updateRepertoar(repertoarUpdate);

        assertNull(response);
        verify(repertoarRepository, times(1)).findById(1L);
        verify(repertoarRepository, times(1)).save(repertoar);
        assertEquals("Updated Film", repertoar.getFilm());
        assertEquals("Updated Reziser", repertoar.getReziser());
        assertEquals("Updated Zanr", repertoar.getZanr());
        assertEquals(90, repertoar.getTrajanje());
        assertEquals(4.0, repertoar.getOcena());
        assertEquals("Updated Projekcija", repertoar.getProjekcija());
        assertEquals(600.0, repertoar.getCenaKarte());
        assertEquals("updated_img.jpg", repertoar.getImgRepertoar());
    }
}
