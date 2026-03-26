package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecompensaTest {

    private Recompensa recompensa;

    @BeforeEach
    void setUp() {
        recompensa = new Recompensa("Gema Roja", 100, "gema");
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("Gema Roja", recompensa.getNombre());
        assertEquals(100, recompensa.getValor());
        assertEquals("gema", recompensa.getTipo());
    }

    @Test
    void testRegistrarYBorrar() {
        // Solo verificar que no lanza excepciones
        assertDoesNotThrow(() -> recompensa.registrar());
        assertDoesNotThrow(() -> recompensa.borrar());
    }

    @Test
    void testToString() {
        String expected = "Gema Roja (gema) valor: 100";
        assertEquals(expected, recompensa.toString());
    }
}