package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarioTest {

    private Inventario inventario;
    private Arma arma1;
    private Arma arma2;

    @BeforeEach
    void setUp() {
        inventario = new Inventario(2); // Capacidad máxima 2
        arma1 = new Arma("Espada", 50, 1.5);
        arma2 = new Arma("Arco", 30, 10.0);
    }

    @Test
    void testAgregarItem() {
        assertTrue(inventario.agregarItem(arma1), "Debe agregar el primer arma");
        assertTrue(arma1.toString().contains("Dentro del inventario"), "El arma1 debe estar registrada");

        assertTrue(inventario.agregarItem(arma2), "Debe agregar el segundo arma");
        assertTrue(arma2.toString().contains("Dentro del inventario"), "El arma2 debe estar registrada");

        // Intentar agregar un tercer arma (inventario lleno)
        Arma arma3 = new Arma("Hacha", 40, 2.0);
        assertFalse(inventario.agregarItem(arma3), "No debe poder agregar un tercer arma (inventario lleno)");
        assertFalse(arma3.toString().contains("Dentro del inventario"), "El arma3 no debe estar registrada");
    }

    @Test
    void testEliminarItem() {
        inventario.agregarItem(arma1);
        inventario.agregarItem(arma2);

        // Eliminar un item existente
        assertTrue(inventario.eliminarItem(arma1), "Debe eliminar arma1 correctamente");
        assertTrue(arma1.toString().contains("Fuera del inventario"), "arma1 debe estar borrada");

        // Intentar eliminar un item que no está
        Arma arma3 = new Arma("Hacha", 40, 2.0);
        assertFalse(inventario.eliminarItem(arma3), "No debe poder eliminar un item que no existe");
    }

    @Test
    void testGetItemsYCapacidad() {
        assertEquals(2, inventario.getCapacidadMaxima(), "Capacidad máxima debe ser 2");
        assertTrue(inventario.getItems().isEmpty(), "Inicialmente la lista de items debe estar vacía");

        inventario.agregarItem(arma1);
        assertEquals(1, inventario.getItems().size(), "Lista debe tener un item después de agregar");
    }
}