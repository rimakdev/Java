package com.example.Punto13;

class Paciente {
    private String nombre;
    private int prioridad; // 1 = Crítico, 2 = Urgente, 3 = Moderado, 4 = Leve

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return nombre + " (Prioridad: " + prioridad + ")";
    }
}