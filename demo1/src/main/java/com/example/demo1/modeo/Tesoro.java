package com.example.demo1.modeo;

/**
 * Clase que representa un tesoro dentro del juego.
 * Hereda de Recompensa y puede ser común o raro.
 */
public class Tesoro extends Recompensa {

    /**
     * Indica si el tesoro es raro o especial.
     */
    private boolean raro;

    /**
     * Constructor del tesoro con nombre, valor, tipo y rareza.
     *
     * @param nombre nombre del tesoro
     * @param valor valor del tesoro
     * @param tipo tipo de recompensa
     * @param raro indica si el tesoro es raro
     */
    public Tesoro(String nombre, int valor, String tipo, boolean raro) {
        super(nombre, valor, tipo);
        this.raro = raro;
    }

    /**
     * Indica si el tesoro es raro.
     *
     * @return true si es raro, false si no lo es
     */
    public boolean isRaro() {
        return raro;
    }

    /**
     * Activa el tesoro dentro del juego.
     * Muestra un mensaje en consola.
     */
    public void activarTesoro() {
        System.out.println("Tesoro activado: " + getNombre());
    }

    /**
     * Representación en texto del tesoro.
     * Incluye si es raro o no.
     *
     * @return descripción del tesoro
     */
    @Override
    public String toString() {
        return super.toString() + (raro ? " [RARO]" : "");
    }
}