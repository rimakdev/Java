package com.example.Punto9;

import java.util.Stack;

public class NavegadorWeb {
    private Stack<String> historial;
    private String paginaActual;

    public NavegadorWeb() {
        this.historial = new Stack<>();
        this.paginaActual = "Inicio";
    }

    // Visitar una nueva página
    public void visitarPagina(String nuevaPagina) {
        historial.push(paginaActual); // Guardar la página actual en la pila
        paginaActual = nuevaPagina;
        System.out.println("Visitando: " + paginaActual);
    }

    // Retroceder a la página anterior
    public void retroceder() {
        if (!historial.isEmpty()) {
            paginaActual = historial.pop(); // Volver a la última página visitada
            System.out.println("Regresando a: " + paginaActual);
        } else {
            System.out.println("No hay páginas anteriores.");
        }
    }

    // Mostrar la página actual
    public void mostrarPaginaActual() {
        System.out.println("Página actual: " + paginaActual);
    }

    // Mostrar historial de navegación
    public void mostrarHistorial() {
        System.out.println("Historial de navegación: " + historial);
    }
}
