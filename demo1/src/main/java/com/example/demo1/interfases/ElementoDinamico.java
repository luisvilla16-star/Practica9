package com.example.demo1.interfases;

/**
 * Interfaz que representa un elemento dinámico dentro del juego.
 * Un elemento dinámico puede moverse en el escenario.
 */
public interface ElementoDinamico {

    /**
     * Método que permite mover el elemento en una dirección específica.
     * @param direccion Dirección del movimiento (ejemplo: "arriba", "abajo", "izquierda", "derecha")
     * @param distancia Distancia que se moverá el elemento
     */
    void mover(String direccion,int distancia);
}
