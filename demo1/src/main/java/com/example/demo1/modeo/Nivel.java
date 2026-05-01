package com.example.demo1.modeo;

import com.example.demo1.interfases.ElementoDinamico;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un nivel dentro del juego.
 * Contiene obstáculos, checkpoints, elementos dinámicos y un inventario.
 */
public class Nivel {

    /** Nombre del nivel */
    private String nombre;

    /** Número del nivel */
    private int numero;

    /** Dificultad del nivel */
    private String dificultad;

    /** Lista de obstáculos del nivel */
    private List<Obstaculo> obstaculos;

    /** Lista de checkpoints del nivel */
    private List<CheckPoint> checkPoints;

    /** Lista de elementos dinámicos del nivel */
    private List<ElementoDinamico> elementosDinamicos;

    /** Inventario asociado al nivel */
    private Inventario inventario;

    /**
     * Constructor de la clase Nivel
     * @param nombre Nombre del nivel
     * @param numero Número del nivel
     * @param dificultad Nivel de dificultad
     * @param inventario Inventario asociado
     */
    public Nivel(String nombre, int numero, String dificultad, Inventario inventario) {
        this.nombre = nombre;
        this.numero = numero;
        this.dificultad = dificultad;
        this.inventario = inventario;
        this.obstaculos = new ArrayList<>();
        this.checkPoints = new ArrayList<>();
        this.elementosDinamicos = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del nivel
     * @return nombre del nivel
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene el número del nivel
     * @return número del nivel
     */
    public int getNumero() { return numero; }

    /**
     * Obtiene la dificultad del nivel
     * @return dificultad del nivel
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * Agrega un obstáculo al nivel
     * @param obstaculo objeto Obstaculo
     */
    public void agregarObstaculo(Obstaculo obstaculo) {
        obstaculos.add(obstaculo);
    }

    /**
     * Agrega un checkpoint al nivel
     * @param cp objeto CheckPoint
     */
    public void agregarCheckPoint(CheckPoint cp) {
        checkPoints.add(cp);
    }

    /**
     * Agrega un elemento dinámico al nivel
     * @param e objeto ElementoDinamico
     */
    public void agregarElementoDinamico(ElementoDinamico e) {
        elementosDinamicos.add(e);
    }

    /**
     * Mueve los elementos dinámicos en direcciones aleatorias
     */
    public void moverElementosDinamicos(String direccion,int distancia) {
        for (ElementoDinamico e : elementosDinamicos) {
            e.mover(direccion, distancia);
        }
    }

    /**
     * Muestra el estado actual del nivel
     */
    public void mostrarEstado() {
        System.out.println("Nivel: " + nombre + " (" + dificultad + ")");
        System.out.println("Obstaculos: " + obstaculos.size());
        System.out.println("CheckPoints: " + checkPoints.size());
        System.out.println("Elementos dinamicos: " + elementosDinamicos.size());
    }
}
