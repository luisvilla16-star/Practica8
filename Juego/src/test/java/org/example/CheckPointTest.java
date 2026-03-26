package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckPointTest {

    @Test
    void testConstructorYGetters() {
        CheckPoint cp = new CheckPoint("Inicio", 100, 200);

        assertEquals("Inicio", cp.getNombre(), "El nombre debería ser 'Inicio'");
        assertEquals(100, cp.getPosicionX(), "La posición X debería ser 100");
        assertEquals(200, cp.getPosicionY(), "La posición Y debería ser 200");
        assertFalse(cp.isActivado(), "El checkpoint debería estar desactivado inicialmente");
    }

    @Test
    void testActivar() {
        CheckPoint cp = new CheckPoint("Meta", 50, 75);

        // Inicialmente desactivado
        assertFalse(cp.isActivado(), "El checkpoint debe estar desactivado inicialmente");

        // Activar checkpoint
        cp.activar();
        assertTrue(cp.isActivado(), "El checkpoint debe estar activado después de llamar a activar()");
    }
}