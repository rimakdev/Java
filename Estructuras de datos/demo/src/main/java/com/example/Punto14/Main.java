package com.example.Punto14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HistorialMensajes historial = new HistorialMensajes();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n MENSAJERÍA - HISTORIAL DE MENSAJES ");
            System.out.println("1. Enviar mensaje");
            System.out.println("2. Ver historial");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el mensaje: ");
                    String mensaje = scanner.nextLine();
                    historial.agregarMensaje(mensaje);
                    break;
                case 2:
                    historial.mostrarHistorial();
                    break;
                case 3:
                    System.out.println(" Saliendo...");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
