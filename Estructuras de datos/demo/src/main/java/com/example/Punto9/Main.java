package com.example.Punto9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NavegadorWeb navegador = new NavegadorWeb();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nNavegador Web");
            System.out.println("1. Visitar nueva página");
            System.out.println("2. Retroceder");
            System.out.println("3. Mostrar página actual");
            System.out.println("4. Mostrar historial");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la URL de la página: ");
                    String url = scanner.nextLine();
                    navegador.visitarPagina(url);
                    break;
                case 2:
                    navegador.retroceder();
                    break;
                case 3:
                    navegador.mostrarPaginaActual();
                    break;
                case 4:
                    navegador.mostrarHistorial();
                    break;
                case 5:
                    System.out.println("Saliendo del navegador...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
