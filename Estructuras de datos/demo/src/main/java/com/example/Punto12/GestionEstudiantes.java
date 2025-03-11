package com.example.Punto12;

import java.util.TreeSet;

public class GestionEstudiantes {
    private TreeSet<String> estudiantes;

    public GestionEstudiantes() {
        this.estudiantes = new TreeSet<>();
    }

    // Agregar un estudiante al TreeSet
    public void agregarEstudiante(String nombre) {
        if (estudiantes.add(nombre)) {
            System.out.println(" Estudiante " + nombre + " agregado.");
        } else {
            System.out.println("El estudiante " + nombre + " ya está en la lista.");
        }
    }

    // Eliminar un estudiante del TreeSet
    public void eliminarEstudiante(String nombre) {
        if (estudiantes.remove(nombre)) {
            System.out.println(" Estudiante " + nombre + " eliminado.");
        } else {
            System.out.println(" El estudiante " + nombre + " no está en la lista.");
        }
    }

    // Listar todos los estudiantes ordenados alfabéticamente
    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println(" No hay estudiantes en la lista.");
        } else {
            System.out.println(" Lista de estudiantes ordenada:");
            for (String estudiante : estudiantes) {
                System.out.println("   - " + estudiante);
            }
        }
    }

    // Obtener el primer estudiante (alfabéticamente)
    public void primerEstudiante() {
        if (!estudiantes.isEmpty()) {
            System.out.println(" Primer estudiante: " + estudiantes.first());
        } else {
            System.out.println(" No hay estudiantes registrados.");
        }
    }

    // Obtener el último estudiante (alfabéticamente)
    public void ultimoEstudiante() {
        if (!estudiantes.isEmpty()) {
            System.out.println(" Último estudiante: " + estudiantes.last());
        } else {
            System.out.println(" No hay estudiantes registrados.");
        }
    }

    // Verificar si un estudiante está en la lista
    public void verificarEstudiante(String nombre) {
        if (estudiantes.contains(nombre)) {
            System.out.println(nombre + " está en la lista.");
        } else {
            System.out.println(nombre + " no está en la lista.");
        }
    }
}
