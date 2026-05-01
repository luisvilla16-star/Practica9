package com.example.demo1.modeo;

/**
 * Clase base que representa cualquier entidad dentro del juego.
 * Contiene la información común como nombre y posición.
 */
public class EntidadJuego {

    /**
     * Nombre de la entidad del juego.
     */
    protected String nombre;

    /**
     * Posición en el eje X dentro del juego.
     */
    protected int posicionX;

    /**
     * Posición en el eje Y dentro del juego.
     */
    protected int posicionY;

    /**
     * Constructor que inicializa una entidad del juego con su nombre y posición.
     *
     * @param nombre nombre de la entidad
     * @param posicionX posición inicial en X
     * @param posicionY posición inicial en Y
     */
    public EntidadJuego(String nombre, int posicionX, int posicionY) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    /**
     * Obtiene el nombre de la entidad.
     *
     * @return nombre de la entidad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la posición en el eje X.
     *
     * @return posición X
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * Obtiene la posición en el eje Y.
     *
     * @return posición Y
     */
    public int getPosicionY() {
        return posicionY;
    }
}