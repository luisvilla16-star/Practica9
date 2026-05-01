package com.example.demo1.modeo;

import com.example.demo1.interfases.Inventariable;

/**
 * Clase que representa un arma dentro del juego.
 * Implementa la interfaz Inventariable para poder ser gestionada en un inventario.
 */
public class Arma implements Inventariable {

    /** Nombre del arma */
    private String nombre;

    /** Cantidad de daño que causa el arma */
    private int dano;

    /** Alcance del arma */
    private double alcance;

    /** Indica si el arma está en el inventario */
    private boolean enInventario;

    /**
     * Constructor de la clase Arma
     * @param nombre Nombre del arma
     * @param dano Daño que provoca
     * @param alcance Alcance del arma
     */
    public Arma(String nombre,int dano,double alcance) {
        this.nombre = nombre;
        this.dano = dano;
        this.alcance = alcance;
        this.enInventario=false;
    }

    /**
     * Obtiene el nombre del arma
     * @return nombre del arma
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el daño del arma
     * @return daño del arma
     */
    public int getDano() {
        return dano;
    }

    /**
     * Obtiene el alcance del arma
     * @return alcance del arma
     */
    public double getAlcance() {
        return alcance;
    }

    /**
     * Marca el arma como registrada en el inventario
     */
    @Override
    public void registrar() {
        enInventario = true;
        System.out.println("Arma registrada: "+nombre);
    }

    /**
     * Marca el arma como eliminada del inventario
     */
    @Override
    public void borrar() {
        enInventario = false;
        System.out.println("Arma eliminada: "+nombre);
    }

    /**
     * Devuelve una representación en texto del arma
     * indicando si está en el inventario o no
     * @return estado del arma
     */
    @Override
    public String toString() {
        if (enInventario) {
            return nombre + " Dentro del inventario";
        } else {
            return nombre + " Fuera del inventario";
        }
    }
}
