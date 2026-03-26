package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtileriaTest {

    private Utileria utileria;

    @BeforeEach
    void setUp() {
        utileria = new Utileria("Linterna", "Ilumina el camino", 0, 0);
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("Linterna", utileria.getNombre());
        assertEquals("Ilumina el camino", utileria.getDescripcion());
        assertEquals(0, utileria.getPosicionX());
        assertEquals(0, utileria.getPosicionY());
    }

    @Test
    void testUsar() {
        // Solo verificamos que no lance excepción
        assertDoesNotThrow(() -> utileria.usar());
    }

    @Test
    void testMoverNorte() {
        utileria.mover("norte", 5);
        assertEquals(5, utileria.getPosicionY());
        assertEquals(0, utileria.getPosicionX());
    }

    @Test
    void testMoverSur() {
        utileria.mover("sur", 3);
        assertEquals(-3, utileria.getPosicionY());
        assertEquals(0, utileria.getPosicionX());
    }

    @Test
    void testMoverEste() {
        utileria.mover("este", 7);
        assertEquals(7, utileria.getPosicionX());
        assertEquals(0, utileria.getPosicionY());
    }

    @Test
    void testMoverOeste() {
        utileria.mover("oeste", 2);
        assertEquals(-2, utileria.getPosicionX());
        assertEquals(0, utileria.getPosicionY());
    }

    @Test
    void testMoverDireccionInvalida() {
        // No debe lanzar excepción aunque la dirección sea inválida
        assertDoesNotThrow(() -> utileria.mover("arriba-diagonal", 5));
    }
}