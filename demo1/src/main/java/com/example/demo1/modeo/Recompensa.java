package com.example.demo1.modeo;

import com.example.demo1.interfases.Inventariable;

/**
 * Clase que representa una recompensa dentro del juego.
 * Puede ser almacenada en un inventario.
 */
public class Recompensa implements Inventariable {

    /** Nombre de la recompensa */
    private String nombre;

    /** Valor de la recompensa */
    private int valor;

    /** Tipo de recompensa (ejemplo: oro, gema, objeto) */
    private String tipo;

    /**
     * Constructor de la clase Recompensa
     * @param nombre Nombre de la recompensa
     * @param valor Valor que tiene
     * @param tipo Tipo de recompensa
     */
    public Recompensa(String nombre, int valor, String tipo) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre de la recompensa
     * @return nombre de la recompensa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el valor de la recompensa
     * @return valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene el tipo de recompensa
     * @return tipo de recompensa
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Registra la recompensa en el inventario
     */
    @Override
    public void registrar() {
        System.out.println("Recompensa registrada: " + nombre);
    }

    /**
     * Elimina la recompensa del inventario
     */
    @Override
    public void borrar() {
        System.out.println("Recompensa eliminada: " + nombre);
    }

    /**
     * Devuelve una representación en texto de la recompensa
     * @return información de la recompensa
     */
    @Override
    public String toString() {
        return nombre + " (" + tipo + ") valor: " + valor;
    }
}