package com.example.Punto8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nEditor de Texto");
            System.out.println("1. Agregar cambio");
            System.out.println("2. Deshacer último cambio");
            System.out.println("3. Mostrar texto actual");
            System.out.println("4. Mostrar historial de cambios");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo texto: ");
                    String nuevoTexto = scanner.nextLine();
                    editor.agregarCambio(nuevoTexto);
                    break;
                case 2:
                    editor.deshacer();
                    break;
                case 3:
                    editor.mostrarTexto();
                    break;
                case 4:
                    editor.mostrarHistorial();
                    break;
                case 5:
                    System.out.println("Saliendo del editor...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
