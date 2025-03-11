package com.example.Punto4;

public class Main {
    public static void main(String[] args) {
        ColaDeTareas cola = new ColaDeTareas();

        cola.agregarTarea(new Tarea("Revisar correos", 5));
        cola.agregarTarea(new Tarea("Hacer reporte", 2));
        cola.agregarTarea(new Tarea("Atender reunión", 1));
        cola.agregarTarea(new Tarea("Responder mensajes", 4));

        System.out.println("\nAntes de atender tareas:");
        cola.mostrarTareas();

        System.out.println("\nAtendiendo tareas en orden de prioridad:");
        while (true) {
            Tarea tarea = cola.atenderTarea();
            if (tarea == null)
                break;
            System.out.println("Atendiendo: " + tarea);
        }
    }
}
