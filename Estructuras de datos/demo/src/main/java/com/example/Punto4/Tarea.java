package com.example.Punto4;

import java.util.Objects;

public class Tarea implements Comparable<Tarea> {
    private String descripcion;
    private int prioridad; // 1 = Alta prioridad, 10 = Baja prioridad

    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        return "Tarea{descripcion='" + descripcion + "', prioridad=" + prioridad + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tarea tarea = (Tarea) obj;
        return prioridad == tarea.prioridad && Objects.equals(descripcion, tarea.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, prioridad);
    }
}
