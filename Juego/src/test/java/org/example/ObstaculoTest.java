package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObstaculoTest {

    private Obstaculo obstaculo;

    @BeforeEach
    void setUp() {
        // Crear un obstáculo de ejemplo
        obstaculo = new Obstaculo("Roca", 10, 5, 7);
    }

    @Test
    void testConstructorYGetters() {
        // Verificar que los getters devuelvan los valores correctos
        assertEquals("Roca", obstaculo.getNombre());
        assertEquals(10, obstaculo.getDano());
        assertEquals(5, obstaculo.getPosicionX());
        assertEquals(7, obstaculo.getPosicionY());
        assertFalse(obstaculo.isDestruido(), "El obstáculo no debe estar destruido al crearse");
    }

    @Test
    void testDestruye() {
        // Verificar que el método destruye cambia el estado
        obstaculo.destruye();
        assertTrue(obstaculo.isDestruido(), "El obstáculo debe estar destruido después de llamar destruye()");
    }

    @Test
    void testNoLanzaExcepciones() {
        assertDoesNotThrow(() -> {
            Obstaculo o = new Obstaculo("Tronco", 5, 2, 3);
            o.destruye();
            o.getNombre();
            o.getDano();
            o.getPosicionX();
            o.getPosicionY();
            o.isDestruido();
        });
    }
}