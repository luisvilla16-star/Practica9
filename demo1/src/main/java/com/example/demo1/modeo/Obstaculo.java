package com.example.demo1.modeo;


import com.example.demo1.interfases.Destruible;

/**
 * Clase que representa un obstáculo dentro del juego.
 * Puede causar daño y puede ser destruido.
 */
public class Obstaculo extends EntidadJuego implements Destruible {

    /** Nombre del obstáculo */
    private String nombre;

    /** Daño que causa el obstáculo */
    private int dano;

    /** Posición en el eje X */
    private int posicionX;

    /** Posición en el eje Y */
    private int posicionY;

    /** Indica si el obstáculo ha sido destruido */
    private boolean destruido;

    /** Indica la vida del obstaculo */
    private int vida;


    /**
     * Constructor de la clase Obstaculo
     * @param nombre Nombre del obstáculo
     * @param dano Daño que causa
     * @param posicionX Posición en X
     * @param posicionY Posición en Y
     * @param vida vida del obstaculo
     */
    public Obstaculo(String nombre, int dano, int posicionX, int posicionY,int vida) {
        super(nombre, posicionX, posicionY);
        this.nombre = nombre;
        this.dano = dano;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.vida=vida;
        this.destruido=false;
    }

    /**
     * Obtiene el nombre del obstáculo
     * @return nombre del obstáculo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el daño del obstáculo
     * @return daño
     */
    public int getDano() {
        return dano;
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
     * Obtiene la  vida
     * @return  vida
     */
    public int getVida(){
        return vida;
    }

    /**
     * Destruye el obstáculo cambiando su estado
     */
    @Override
    public void destruye() {
        if (!destruido) {
            destruido = true;
            vida=0;
            System.out.println("Obstaculo destruido: " + nombre);
        } else {
            System.out.println("Ya estaba destruido: " + nombre);
        }
    }
    public void recibirDano(int dano) {

        if (destruido) {
            System.out.println(nombre + " ya esta destruido");
            return;
        }
        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }
        System.out.println(nombre + " recibio " + dano + " de daño. Vida restante: " + vida);

        if (vida == 0) {
            destruye();
        }
    }

    /**
     * Indica si el obstáculo ha sido destruido
     * @return true si está destruido, false en caso contrario
     */
    public boolean isDestruido() {

        return destruido;
    }
}