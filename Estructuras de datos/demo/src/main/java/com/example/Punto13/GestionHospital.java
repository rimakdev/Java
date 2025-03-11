package com.example.Punto13;

import java.util.PriorityQueue;

class GestionHospital {
    private PriorityQueue<Paciente> colaPacientes;

    public GestionHospital() {
        this.colaPacientes = new PriorityQueue<>(new ComparadorPacientes());
    }

    // Agregar paciente a la cola
    public void agregarPaciente(String nombre, int prioridad) {
        if (prioridad < 1 || prioridad > 4) {
            System.out.println(" Prioridad inválida. Debe estar entre 1 y 4.");
            return;
        }
        Paciente nuevoPaciente = new Paciente(nombre, prioridad);
        colaPacientes.add(nuevoPaciente);
        System.out.println(" Paciente agregado: " + nuevoPaciente);
    }

    // Atender al siguiente paciente (el de mayor prioridad)
    public void atenderPaciente() {
        if (colaPacientes.isEmpty()) {
            System.out.println(" No hay pacientes en espera.");
        } else {
            Paciente atendido = colaPacientes.poll();
            System.out.println(" Atendiendo a: " + atendido);
        }
    }

    // Mostrar el siguiente paciente en la fila
    public void verSiguientePaciente() {
        if (colaPacientes.isEmpty()) {
            System.out.println("No hay pacientes en la lista.");
        } else {
            System.out.println(" Siguiente paciente: " + colaPacientes.peek());
        }
    }

    // Mostrar lista de pacientes en espera
    public void listarPacientes() {
        if (colaPacientes.isEmpty()) {
            System.out.println(" No hay pacientes en la lista.");
        } else {
            System.out.println(" Pacientes en espera:");
            for (Paciente p : colaPacientes) {
                System.out.println("   - " + p);
            }
        }
    }

    // Verificar si la cola está vacía
    public boolean hayPacientes() {
        return !colaPacientes.isEmpty();
    }
}