package org.example.it355pz.crud;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepertoarUpdateTest {

    @Test
    public void testNoArgsConstructor() {
        RepertoarUpdate repertoarUpdate = new RepertoarUpdate();
        assertNotNull(repertoarUpdate);
    }

    @Test
    public void testAllArgsConstructor() {
        RepertoarUpdate repertoarUpdate = new RepertoarUpdate(1L, "Film", "Reziser", "Zanr", 120, 8.5, "Projekcija", 10.0, "imgPath");
        assertEquals(1L, repertoarUpdate.getIdRepertoar());
        assertEquals("Film", repertoarUpdate.getFilm());
        assertEquals("Reziser", repertoarUpdate.getReziser());
        assertEquals("Zanr", repertoarUpdate.getZanr());
        assertEquals(120, repertoarUpdate.getTrajanje());
        assertEquals(8.5, repertoarUpdate.getOcena());
        assertEquals("Projekcija", repertoarUpdate.getProjekcija());
        assertEquals(10.0, repertoarUpdate.getCenaKarte());
        assertEquals("imgPath", repertoarUpdate.getImgRepertoar());
    }

    @Test
    public void testPartialArgsConstructor() {
        RepertoarUpdate repertoarUpdate = new RepertoarUpdate("Film", "Reziser", "Zanr", 120, 8.5, "Projekcija", 10.0, "imgPath");
        assertNull(repertoarUpdate.getIdRepertoar());
        assertEquals("Film", repertoarUpdate.getFilm());
        assertEquals("Reziser", repertoarUpdate.getReziser());
        assertEquals("Zanr", repertoarUpdate.getZanr());
        assertEquals(120, repertoarUpdate.getTrajanje());
        assertEquals(8.5, repertoarUpdate.getOcena());
        assertEquals("Projekcija", repertoarUpdate.getProjekcija());
        assertEquals(10.0, repertoarUpdate.getCenaKarte());
        assertEquals("imgPath", repertoarUpdate.getImgRepertoar());
    }

    @Test
    public void testSettersAndGetters() {
        RepertoarUpdate repertoarUpdate = new RepertoarUpdate();
        repertoarUpdate.setIdRepertoar(1L);
        repertoarUpdate.setFilm("Film");
        repertoarUpdate.setReziser("Reziser");
        repertoarUpdate.setZanr("Zanr");
        repertoarUpdate.setTrajanje(120);
        repertoarUpdate.setOcena(8.5);
        repertoarUpdate.setProjekcija("Projekcija");
        repertoarUpdate.setCenaKarte(10.0);
        repertoarUpdate.setImgRepertoar("imgPath");

        assertEquals(1L, repertoarUpdate.getIdRepertoar());
        assertEquals("Film", repertoarUpdate.getFilm());
        assertEquals("Reziser", repertoarUpdate.getReziser());
        assertEquals("Zanr", repertoarUpdate.getZanr());
        assertEquals(120, repertoarUpdate.getTrajanje());
        assertEquals(8.5, repertoarUpdate.getOcena());
        assertEquals("Projekcija", repertoarUpdate.getProjekcija());
        assertEquals(10.0, repertoarUpdate.getCenaKarte());
        assertEquals("imgPath", repertoarUpdate.getImgRepertoar());
    }
}