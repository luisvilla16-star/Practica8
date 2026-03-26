package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArmaTest {

    @Test
    void testConstructorYGetters() {
        Arma arma = new Arma("Espada", 50, 1.5);

        assertEquals("Espada", arma.getNombre(), "El nombre debería ser Espada");
        assertEquals(50, arma.getDano(), "El daño debería ser 50");
        assertEquals(1.5, arma.getAlcance(), 0.001, "El alcance debería ser 1.5");
    }

    @Test
    void testRegistrar() {
        Arma arma = new Arma("Arco", 30, 10.0);

        // Inicialmente fuera del inventario
        assertTrue(arma.toString().contains("Fuera del inventario"), "Debe estar fuera del inventario inicialmente");

        // Registrar el arma
        arma.registrar();
        assertTrue(arma.toString().contains("Dentro del inventario"), "Debe estar dentro del inventario después de registrar");
    }

    @Test
    void testBorrar() {
        Arma arma = new Arma("Hacha", 40, 2.0);

        // Registrar y luego borrar
        arma.registrar();
        assertTrue(arma.toString().contains("Dentro del inventario"), "Debe estar dentro del inventario después de registrar");

        arma.borrar();
        assertTrue(arma.toString().contains("Fuera del inventario"), "Debe estar fuera del inventario después de borrar");
    }

    @Test
    void testToString() {
        Arma arma = new Arma("Lanza", 25, 3.0);

        assertEquals("Lanza Fuera del inventario", arma.toString(), "toString inicial incorrecto");

        arma.registrar();
        assertEquals("Lanza Dentro del inventario", arma.toString(), "toString después de registrar incorrecto");
    }
}