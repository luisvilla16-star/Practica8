package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {

    private Personaje personaje;

    @BeforeEach
    void setUp() {
        // Crear personaje de ejemplo
        personaje = new Personaje("Guerrero", 100, 0, 0);
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("Guerrero", personaje.getNombre());
        assertEquals(100, personaje.getVida());
        assertEquals(0, personaje.getPosicionX());
        assertEquals(0, personaje.getPosicionY());
    }

    @Test
    void testSetPosicion() {
        personaje.setPosicion(5, 10);
        assertEquals(5, personaje.getPosicionX());
        assertEquals(10, personaje.getPosicionY());
    }

    @Test
    void testRecibirDano() {
        personaje.recibirDano(30);
        assertEquals(70, personaje.getVida());

        // Daño mayor que la vida actual
        personaje.recibirDano(100);
        assertEquals(-30, personaje.getVida()); // Si quieres evitar valores negativos, habría que modificar la clase
    }

    @Test
    void testMover() {
        personaje.mover("norte", 5);
        assertEquals(0, personaje.getPosicionX());
        assertEquals(5, personaje.getPosicionY());

        personaje.mover("sur", 3);
        assertEquals(0, personaje.getPosicionX());
        assertEquals(2, personaje.getPosicionY());

        personaje.mover("este", 4);
        assertEquals(4, personaje.getPosicionX());
        assertEquals(2, personaje.getPosicionY());

        personaje.mover("oeste", 1);
        assertEquals(3, personaje.getPosicionX());
        assertEquals(2, personaje.getPosicionY());
    }

    @Test
    void testDestruye() {
        personaje.destruye();
        assertEquals(0, personaje.getVida());
    }

    @Test
    void testNoLanzaExcepciones() {
        assertDoesNotThrow(() -> {
            personaje.mover("norte", 1);
            personaje.recibirDano(5);
            personaje.destruye();
            personaje.setPosicion(2, 2);
        });
    }
}