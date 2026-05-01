package com.example.demo1.modeo;

/**
 * Clase que representa un enemigo dentro del juego.
 * Hereda de Personaje y añade un nivel de dificultad.
 */
public class Enemigo extends Personaje {

    /**
     * Nivel del enemigo que determina su dificultad o fuerza.
     */
    private int nivel;

    /**
     * Constructor del enemigo con nombre, vida, posición y nivel.
     *
     * @param nombre nombre del enemigo
     * @param vida cantidad de vida del enemigo
     * @param x posición en el eje X
     * @param y posición en el eje Y
     * @param nivel nivel de dificultad del enemigo
     */
    public Enemigo(String nombre, int vida, int x, int y, int nivel) {
        super(nombre, vida, x, y);
        this.nivel = nivel;
    }

    /**
     * Obtiene el nivel del enemigo.
     *
     * @return nivel del enemigo
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Reduce la vida del enemigo cuando recibe daño.
     * También muestra un mensaje en consola.
     *
     * @param dano cantidad de daño recibido
     */
    @Override
    public void recibirDano(int dano) {
        super.recibirDano(dano);
        System.out.println("Enemigo atacado con daño: " + dano);
    }

    /**
     * Acción de ataque del enemigo.
     * Muestra un mensaje indicando su nivel de ataque.
     */
    public void atacar() {
        System.out.println("Enemigo ataca con nivel " + nivel);
    }
}