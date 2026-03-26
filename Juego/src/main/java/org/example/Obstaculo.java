package org.example;

/**
 * Clase que representa un obstáculo dentro del juego.
 * Puede causar daño y puede ser destruido.
 */
public class Obstaculo implements Destruible {

    /** Nombre del obstáculo */
    private String nombre;

    /** Daño que causa el obstáculo */
    private int dano;

    /** Posición en el eje X */
    private int posicionX;

    /** Posición en el eje Y */
    private int posicionY;

    /** Indica si el obstáculo ha sido destruido */
    private boolean destruido;

    /**
     * Constructor de la clase Obstaculo
     * @param nombre Nombre del obstáculo
     * @param dano Daño que causa
     * @param posicionX Posición en X
     * @param posicionY Posición en Y
     */
    public Obstaculo(String nombre, int dano, int posicionX, int posicionY) {
        this.nombre = nombre;
        this.dano = dano;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    /**
     * Obtiene el nombre del obstáculo
     * @return nombre del obstáculo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el daño del obstáculo
     * @return daño
     */
    public int getDano() {
        return dano;
    }

    /**
     * Obtiene la posición en X
     * @return posición X
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * Obtiene la posición en Y
     * @return posición Y
     */
    public int getPosicionY() {
        return posicionY;
    }

    /**
     * Destruye el obstáculo cambiando su estado
     */
    @Override
    public void destruye() {
        destruido = true;
    }

    /**
     * Indica si el obstáculo ha sido destruido
     * @return true si está destruido, false en caso contrario
     */
    public boolean isDestruido() {
        return destruido;
    }
}