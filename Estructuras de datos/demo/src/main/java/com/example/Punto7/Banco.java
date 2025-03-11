package com.example.Punto7;

import java.util.LinkedList;

public class Banco {
    private LinkedList<String> colaClientes;

    public Banco() {
        this.colaClientes = new LinkedList<>();
    }

    // Agregar cliente al final de la cola
    public void agregarCliente(String nombre) {
        colaClientes.addLast(nombre);
        System.out.println("Cliente agregado: " + nombre);
    }

    // Atender al primer cliente de la cola
    public void atenderCliente() {
        if (!colaClientes.isEmpty()) {
            String clienteAtendido = colaClientes.removeFirst();
            System.out.println("Atendiendo a: " + clienteAtendido);
        } else {
            System.out.println("No hay clientes en espera.");
        }
    }

    // Insertar cliente con urgencia al inicio de la cola
    public void agregarClienteUrgente(String nombre) {
        colaClientes.addFirst(nombre);
        System.out.println("Cliente urgente agregado al inicio: " + nombre);
    }

    // Mostrar la lista de espera
    public void mostrarCola() {
        if (colaClientes.isEmpty()) {
            System.out.println("No hay clientes en espera.");
        } else {
            System.out.println("Cola de espera: " + colaClientes);
        }
    }
}
