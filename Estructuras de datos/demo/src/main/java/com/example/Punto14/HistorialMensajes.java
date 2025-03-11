package com.example.Punto14;

import java.util.ArrayDeque;
import java.util.Deque;

class HistorialMensajes {
    private static final int LIMITE = 10; // Máximo de mensajes almacenados
    private Deque<String> mensajes;

    public HistorialMensajes() {
        this.mensajes = new ArrayDeque<>();
    }

    // Agregar un nuevo mensaje al historial
    public void agregarMensaje(String mensaje) {
        if (mensajes.size() >= LIMITE) {
            mensajes.pollFirst(); // Eliminar el mensaje más antiguo
        }
        mensajes.addLast(mensaje); // Agregar el nuevo mensaje al final
        System.out.println(" Mensaje agregado: " + mensaje);
    }

    // Mostrar los últimos mensajes enviados
    public void mostrarHistorial() {
        if (mensajes.isEmpty()) {
            System.out.println(" No hay mensajes en el historial.");
        } else {
            System.out.println(" Historial de mensajes:");
            for (String msg : mensajes) {
                System.out.println("   - " + msg);
            }
        }
    }
}
