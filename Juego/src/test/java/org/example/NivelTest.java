package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

// Clase de prueba que implementa la interfaz ElementoDinamico
class ElementoDinamicoMock implements ElementoDinamico {
    @Override
    public void mover(String direccion, int distancia) {
        // implementación mínima, no hace nada
    }
}

class NivelTest {

    private Nivel nivel;
    private Inventario inventario;

    @BeforeEach
    void setUp() {
        inventario = new Inventario(10); // Capacidad del inventario
        nivel = new Nivel("Bosque", 1, "Facil", inventario);
    }

    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> {
            nivel.getNombre();
            nivel.getNumero();
            nivel.getDificultad();
        });
    }

    @Test
    void testAgregarObstaculo() {
        assertDoesNotThrow(() -> {
            // Se usa el constructor correcto con 4 parámetros
            Obstaculo o = new Obstaculo("Roca", 10, 5, 5);
            nivel.agregarObstaculo(o);
            nivel.mostrarEstado();
        });
    }

    @Test
    void testAgregarCheckPoint() {
        assertDoesNotThrow(() -> {
            CheckPoint cp = new CheckPoint("CP1",20,20);
            nivel.agregarCheckPoint(cp);
            nivel.mostrarEstado();
        });
    }

    @Test
    void testAgregarElementoDinamicoYMovimiento() {
        assertDoesNotThrow(() -> {
            ElementoDinamico e = new ElementoDinamicoMock();
            nivel.agregarElementoDinamico(e);
            nivel.moverElementosDinamicos();
            nivel.mostrarEstado();
        });
    }
}