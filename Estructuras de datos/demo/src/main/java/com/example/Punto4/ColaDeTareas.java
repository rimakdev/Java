package com.example.Punto4;

import java.util.PriorityQueue;
import java.util.Queue;

public class ColaDeTareas {
    private Queue<Tarea> cola;

    public ColaDeTareas() {
        this.cola = new PriorityQueue<>();
    }

    public void agregarTarea(Tarea tarea) {
        cola.add(tarea);
        System.out.println("Tarea agregada: " + tarea);
    }

    public Tarea atenderTarea() {
        if (!cola.isEmpty()) {
            return cola.poll(); // Extrae la tarea con mayor prioridad
        }
        System.out.println("No hay tareas pendientes.");
        return null;
    }

    public void mostrarTareas() {
        System.out.println("Tareas en la cola:");
        for (Tarea t : cola) {
            System.out.println(t);
        }
    }
}
