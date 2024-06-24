package org.example.it355pz.crud;
import org.example.it355pz.crud.RecenzijaUpdate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecenzijaUpdateTest {

    @Test
    public void testNoArgsConstructor() {
        RecenzijaUpdate recenzijaUpdate = new RecenzijaUpdate();
        assertNotNull(recenzijaUpdate);
    }

    @Test
    public void testAllArgsConstructor() {
        RecenzijaUpdate recenzijaUpdate = new RecenzijaUpdate(1L, "Odličan film!", 4.5);
        assertEquals(1L, recenzijaUpdate.getIdRecenzija());
        assertEquals("Odličan film!", recenzijaUpdate.getTextRecenzije());
        assertEquals(4.5, recenzijaUpdate.getMarkRecenzije());
    }

    @Test
    public void testPartialArgsConstructor() {
        RecenzijaUpdate recenzijaUpdate = new RecenzijaUpdate("Odličan film!", 4.5);
        assertNull(recenzijaUpdate.getIdRecenzija());
        assertEquals("Odličan film!", recenzijaUpdate.getTextRecenzije());
        assertEquals(4.5, recenzijaUpdate.getMarkRecenzije());
    }

    @Test
    public void testSettersAndGetters() {
        RecenzijaUpdate recenzijaUpdate = new RecenzijaUpdate();
        recenzijaUpdate.setIdRecenzija(1L);
        recenzijaUpdate.setTextRecenzije("Odličan film!");
        recenzijaUpdate.setMarkRecenzije(4.5);

        assertEquals(1L, recenzijaUpdate.getIdRecenzija());
        assertEquals("Odličan film!", recenzijaUpdate.getTextRecenzije());
        assertEquals(4.5, recenzijaUpdate.getMarkRecenzije());
    }
}