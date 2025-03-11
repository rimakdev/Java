package com.example.Punto17;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

class AgendaEventos {
    private TreeMap<LocalDate, String> eventos;

    public AgendaEventos() {
        this.eventos = new TreeMap<>();
    }

    // Agregar un evento con su fecha
    public void agregarEvento(LocalDate fecha, String descripcion) {
        eventos.put(fecha, descripcion);
        System.out.println("Evento agregado: " + fecha + " - " + descripcion);
    }

    // Eliminar un evento por fecha
    public void eliminarEvento(LocalDate fecha) {
        if (eventos.remove(fecha) != null) {
            System.out.println("Evento eliminado: " + fecha);
        } else {
            System.out.println("No hay eventos en esa fecha.");
        }
    }

    // Mostrar todos los eventos ordenados por fecha
    public void mostrarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            System.out.println("\nEventos programados:");
            for (Map.Entry<LocalDate, String> entry : eventos.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    // Obtener el evento más próximo
    public void mostrarEventoMasProximo() {
        if (!eventos.isEmpty()) {
            Map.Entry<LocalDate, String> eventoProximo = eventos.firstEntry();
            System.out.println("Evento más próximo: " + eventoProximo.getKey() + " - " + eventoProximo.getValue());
        } else {
            System.out.println("No hay eventos próximos.");
        }
    }
}
