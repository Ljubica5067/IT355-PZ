package org.example.it355pz.services;


import org.example.it355pz.crud.RecenzijaUpdate;
import org.example.it355pz.entity.Recenzija;
import org.example.it355pz.repository.RecenzijaRepository;
import org.example.it355pz.service.RecenzijaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecenzijaServiceTest {

    @Mock
    private RecenzijaRepository recenzijaRepository;

    @InjectMocks
    private RecenzijaService recenzijaService;

    private Recenzija recenzija;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recenzija = new Recenzija();
        recenzija.setIdRecenzija(1L);
        recenzija.setTextRecenzije("Odličan film!");
        recenzija.setMarkRecenzije(5.0);
    }

    @Test
    void registerRecenzija() {
        when(recenzijaRepository.save(any(Recenzija.class))).thenReturn(recenzija);
        Recenzija savedRecenzija = recenzijaService.registerRecenzija(recenzija);
        assertNotNull(savedRecenzija);
        assertEquals(recenzija.getTextRecenzije(), savedRecenzija.getTextRecenzije());
        verify(recenzijaRepository, times(1)).save(recenzija);
    }

    @Test
    void getRecenzije() {
        List<Recenzija> recenzijaList = new ArrayList<>();
        recenzijaList.add(recenzija);
        when(recenzijaRepository.findAll()).thenReturn(recenzijaList);
        List<Recenzija> recenzije = recenzijaService.getRecenzije();
        assertFalse(recenzije.isEmpty());
        assertEquals(1, recenzije.size());
        verify(recenzijaRepository, times(1)).findAll();
    }

    @Test
    void deleteRecenzija() {
        when(recenzijaRepository.existsById(anyLong())).thenReturn(true);
        boolean isDeleted = recenzijaService.deleteRecenzija(1L);
        assertTrue(isDeleted);
        verify(recenzijaRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateRecenzija() {
        RecenzijaUpdate recenzijaUpdate = new RecenzijaUpdate();
        recenzijaUpdate.setIdRecenzija(1L);
        recenzijaUpdate.setTextRecenzije("Izmenjen tekst recenzije");
        recenzijaUpdate.setMarkRecenzije(4.0);

        when(recenzijaRepository.findById(anyLong())).thenReturn(Optional.of(recenzija));

        String response = recenzijaService.updateRecenzija(recenzijaUpdate);

        assertNull(response);
        verify(recenzijaRepository, times(1)).findById(1L);
        verify(recenzijaRepository, times(1)).save(recenzija);
        assertEquals("Izmenjen tekst recenzije", recenzija.getTextRecenzije());
        assertEquals(4.0, recenzija.getMarkRecenzije());
    }
}
