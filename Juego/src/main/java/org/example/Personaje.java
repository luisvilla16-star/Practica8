package org.example;

/**
 * Clase que representa un personaje dentro del juego.
 * Puede moverse, recibir daño y ser destruido.
 */
public class Personaje implements Destruible, ElementoDinamico {

    /** Nombre del personaje */
    private String nombre;

    /** Vida actual del personaje */
    private int vida;

    /** Posición en el eje X */
    private int posicionX;

    /** Posición en el eje Y */
    private int posicionY;

    /**
     * Constructor de la clase Personaje
     * @param nombre Nombre del personaje
     * @param vida Vida inicial
     * @param posicionX Posición en X
     * @param posicionY Posición en Y
     */
    public Personaje(String nombre,int vida,int posicionX,int posicionY) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    /**
     * Obtiene el nombre del personaje
     * @return nombre del personaje
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene la vida del personaje
     * @return vida actual
     */
    public int getVida(){
        return vida;
    }

    /**
     * Obtiene la posición en X
     * @return posición X
     */
    public int getPosicionX(){
        return posicionX;
    }

    /**
     * Obtiene la posición en Y
     * @return posición Y
     */
    public int getPosicionY(){
        return posicionY;
    }

    /**
     * Establece una nueva posición para el personaje
     * @param posicionX nueva posición en X
     * @param posicionY nueva posición en Y
     */
    public void setPosicion(int posicionX, int posicionY){
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    /**
     * Reduce la vida del personaje al recibir daño
     * @param dano cantidad de daño recibido
     */
    public void recibirDano(int dano){
        int nuevaVida = vida - dano;
        this.vida = nuevaVida;
    }

    /**
     * Mueve al personaje en una dirección específica
     * @param direccion dirección del movimiento (norte, sur, este, oeste)
     * @param distancia distancia a mover
     */
    @Override
    public void mover(String direccion, int distancia){

        if(direccion.equalsIgnoreCase("norte")){
            posicionY += distancia;

        } else if(direccion.equalsIgnoreCase("sur")){
            posicionY -= distancia;

        } else if(direccion.equalsIgnoreCase("este")){
            posicionX += distancia;

        } else if(direccion.equalsIgnoreCase("oeste")){
            posicionX -= distancia;

        } else {
            System.out.println("Direccion invalida");
        }

        System.out.println(nombre + " se movio a (" + posicionX + "," + posicionY + ")");
    }

    /**
     * Destruye al personaje estableciendo su vida en 0
     */
    @Override
    public void destruye() {
        vida = 0;
    }
}