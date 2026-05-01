package com.example.demo1.modeo;

import com.example.demo1.interfases.Inventariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un inventario que almacena objetos tipo Inventariable.
 */
public class Inventario {

    /** Capacidad máxima del inventario */
    private int capacidadMaxima;

    /** Lista de items almacenados en el inventario */
    private List<Inventariable> items;

    /**
     * Constructor de la clase Inventario
     * @param capacidadMaxima Número máximo de elementos que puede almacenar
     */
    public Inventario(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.items = new ArrayList<>();
    }

    /**
     * Obtiene la capacidad máxima del inventario
     * @return capacidad máxima
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Obtiene la lista de items del inventario
     * @return lista de objetos Inventariable
     */
    public List<Inventariable> getItems() {
        return items;
    }

    /**
     * Agrega un item al inventario si hay espacio disponible
     * @param item objeto a agregar
     * @return true si se agregó correctamente, false si el inventario está lleno
     */
    public boolean agregarItem(Inventariable item) {
        if (items.size() < capacidadMaxima) {
            items.add(item);
            item.registrar();
            return true;
        } else {
            System.out.println("Inventario lleno");
            return false;
        }
    }

    /**
     * Elimina un item del inventario
     * @param item objeto a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarItem(Inventariable item) {
        if (items.remove(item)) {
            item.borrar();
            return true;
        } else {
            System.out.println("Item no encontrado");
            return false;
        }
    }

    /**
     * Muestra todos los items almacenados en el inventario
     */
    public void listarItems() {
        if (items.isEmpty()) {
            System.out.println("Inventario vacío");
        } else {
            for (Inventariable item : items) {
                System.out.println(item);
            }
        }
    }
}