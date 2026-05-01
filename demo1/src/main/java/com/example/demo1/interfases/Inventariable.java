package com.example.demo1.interfases;

/**
 * Interfaz que representa un objeto que puede ser gestionado en un inventario.
 */
public interface Inventariable {

    /**
     * Método para registrar (agregar) el objeto al inventario.
     */
    void registrar();

    /**
     * Método para borrar (eliminar) el objeto del inventario.
     */
    void borrar();
}