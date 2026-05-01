package com.example.demo1.modeo;

/**
 * Clase que representa al jugador dentro del juego.
 * Hereda de Personaje y agrega sistema de experiencia.
 */
public class Jugador extends Personaje {

    /** Experiencia acumulada del jugador */
    private int experiencia;

    /**
     * Constructor del jugador
     * @param nombre nombre del jugador
     * @param vida vida inicial
     * @param x posición en X
     * @param y posición en Y
     */
    public Jugador(String nombre, int vida, int x, int y) {
        super(nombre, vida, x, y);
        this.experiencia = 0;
    }

    /**
     * Obtiene la experiencia actual del jugador
     * @return experiencia acumulada
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Incrementa la experiencia del jugador
     * @param xp cantidad de experiencia ganada
     */
    public void ganarExperiencia(int xp) {
        experiencia += xp;
    }

    /**
     * Aplica daño al jugador y muestra un mensaje en consola
     * @param dano cantidad de daño recibido
     */
    @Override
    public void recibirDano(int dano) {
        super.recibirDano(dano);
        System.out.println("Jugador recibió daño: " + dano);
    }
}