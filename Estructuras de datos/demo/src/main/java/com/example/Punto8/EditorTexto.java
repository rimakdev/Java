package com.example.Punto8;

import java.util.Vector;

public class EditorTexto {
    private Vector<String> historial;
    private String textoActual;

    public EditorTexto() {
        this.historial = new Vector<>();
        this.textoActual = "";
    }

    // Agregar un nuevo cambio
    public void agregarCambio(String nuevoTexto) {
        historial.add(textoActual); // Guardar el estado actual antes del cambio
        textoActual = nuevoTexto;
        System.out.println("Cambio agregado: " + textoActual);
    }

    // Deshacer el último cambio
    public void deshacer() {
        if (!historial.isEmpty()) {
            textoActual = historial.remove(historial.size() - 1); // Recuperar el último estado guardado
            System.out.println("Último cambio deshecho.");
        } else {
            System.out.println("No hay cambios para deshacer.");
        }
    }

    // Mostrar el estado actual del texto
    public void mostrarTexto() {
        System.out.println("Texto actual: " + textoActual);
    }

    // Mostrar historial de cambios
    public void mostrarHistorial() {
        System.out.println("Historial de cambios: " + historial);
    }
}
