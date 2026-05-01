package com.example.demo1.modeo;

import com.example.demo1.interfases.ElementoDinamico;

/**
 * Clase que representa un objeto de utilería dentro del juego.
 * Puede moverse y ser utilizado por el jugador.
 */
public class Utileria extends EntidadJuego implements ElementoDinamico {

    /** Nombre del objeto de utilería */
    private String nombre;

    /** Descripción del objeto */
    private String descripcion;

    /** Posición en el eje X */
    private int posicionX;

    /** Posición en el eje Y */
    private int posicionY;

    /** utileria usada */
    private boolean usada;

    /**
     * Constructor de la clase Utileria
     * @param nombre Nombre del objeto
     * @param descripcion Descripción del objeto
     * @param posicionX Posición en X
     * @param posicionY Posición en Y
     */
    public Utileria(String nombre, String descripcion, int posicionX, int posicionY) {
        super(nombre, posicionX, posicionY);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.usada=false;
    }

    /**
     * Obtiene el nombre del objeto
     * @return nombre
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene la descripción del objeto
     * @return descripción
     */
    public String getDescripcion(){
        return descripcion;
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
     * Ejecuta la acción de usar el objeto
     */
    public void usar(){
        this.usada=true;
        System.out.println("Utileria usada: " +nombre);
    }

    /**
     * Mueve el objeto en una dirección específica
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
    }
}

