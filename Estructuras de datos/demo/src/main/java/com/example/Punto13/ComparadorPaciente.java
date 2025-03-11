package com.example.Punto13;

import java.util.Comparator;

class ComparadorPacientes implements Comparator<Paciente> {
    @Override
    public int compare(Paciente p1, Paciente p2) {
        return Integer.compare(p1.getPrioridad(), p2.getPrioridad());
    }
}