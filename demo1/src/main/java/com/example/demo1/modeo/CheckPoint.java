package com.example.demo1.modeo;

/**
 * Clase que representa un CheckPoint dentro del juego.
 * Un checkpoint permite guardar el progreso del jugador.
 */
public class CheckPoint {

    /** Nombre del checkpoint */
    private String nombre;

    /** Posición en el eje X */
    private int posicionX;

    /** Posición en el eje Y */
    private int posicionY;

    /** Indica si el checkpoint ha sido activado */
    private boolean activado;

    /**
     * Constructor de la clase CheckPoint
     * @param nombre Nombre del checkpoint
     * @param posicionX Posición en X
     * @param posicionY Posición en Y
     */
    public CheckPoint(String nombre,int posicionX, int posicionY) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.activado = false;
    }

    /**
     * Obtiene el nombre del checkpoint
     * @return nombre del checkpoint
     */
    public String getNombre(){
        return nombre;
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
     * Indica si el checkpoint está activado
     * @return true si está activado, false en caso contrario
     */
    public boolean isActivado() {
        return activado;
    }

    /**
     * Activa el checkpoint y muestra un mensaje en consola
     */
    public void activar() {
        activado = true;
        System.out.println("Checkpoint activado: " + nombre);
    }
}
