package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== INICIO DEL JUEGO =====\n");

        // ===== INVENTARIO =====
        Inventario inventario = new Inventario(5);

        Arma espada = new Arma("Espada", 50, 1.5);
        Arma arco = new Arma("Arco", 30, 10.0);

        Recompensa oro = new Recompensa("Oro", 100, "Moneda");
        Recompensa gema = new Recompensa("Gema", 500, "Especial");

        System.out.println("=== AGREGANDO ITEMS ===");
        inventario.agregarItem(espada);
        inventario.agregarItem(arco);
        inventario.agregarItem(oro);
        inventario.agregarItem(gema);

        System.out.println("\n=== INVENTARIO ACTUAL ===");
        inventario.listarItems();

        //  ELIMINAR ARMA Y MOSTRAR INVENTARIO AUTOMÁTICAMENTE
        System.out.println("\n=== ELIMINANDO ARCO ===");
        inventario.eliminarItem(arco);
        System.out.println("Inventario después de eliminar arco:");
        inventario.listarItems();

        //  ELIMINAR RECOMPENSA Y MOSTRAR INVENTARIO
        System.out.println("\n=== ELIMINANDO ORO ===");
        inventario.eliminarItem(oro);
        System.out.println("Inventario despues de eliminar oro:");
        inventario.listarItems();

        // ===== PERSONAJE =====
        System.out.println("\n=== PERSONAJE ===");
        Personaje jugador = new Personaje("Heroe", 100, 0, 0);

        jugador.mover("norte", 5);
        jugador.mover("este", 3);

        jugador.recibirDano(20);
        System.out.println("Vida actual: " + jugador.getVida());

        // ===== OBSTACULO =====
        System.out.println("\n=== OBSTACULO ===");
        Obstaculo roca = new Obstaculo("Roca", 10, 2, 2);

        roca.destruye();

        if (roca.isDestruido()) {
            System.out.println("El obstaculo " + roca.getNombre() + " fue destruido");
        }

        // ===== UTILERIA =====
        System.out.println("\n=== UTILERIA ===");
        Utileria barril = new Utileria("Barril", "Explosivo", 1, 1);

        barril.mover("sur", 2);
        barril.usar();

        // ===== NIVEL =====
        System.out.println("\n=== NIVEL ===");
        Nivel nivel = new Nivel("Bosque", 1, "Media", inventario);

        nivel.agregarObstaculo(roca);

        // ===== CHECKPOINT =====
        CheckPoint cp1 = new CheckPoint("CP1", 5, 5);
        nivel.agregarCheckPoint(cp1);
        cp1.activar();

        // ===== ELEMENTOS DINAMICOS =====
        nivel.agregarElementoDinamico(jugador);
        nivel.agregarElementoDinamico(barril);

        System.out.println("\n=== MOVIMIENTO ALEATORIO ===");
        nivel.moverElementosDinamicos();

        // ===== ESTADO DEL NIVEL =====
        System.out.println("\n=== ESTADO DEL NIVEL ===");
        nivel.mostrarEstado();

        // ===== DESTRUIR PERSONAJE =====
        System.out.println("\n=== DESTRUIR PERSONAJE ===");
        jugador.destruye();
        System.out.println("Vida despues de destruir: " + jugador.getVida());

        System.out.println("\n===== FIN DEL JUEGO =====");
    }
}