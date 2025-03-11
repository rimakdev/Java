package com.example.Punto7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestión de Turnos en el Banco");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Agregar cliente urgente");
            System.out.println("4. Mostrar cola de espera");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    banco.agregarCliente(nombre);
                    break;
                case 2:
                    banco.atenderCliente();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del cliente urgente: ");
                    String nombreUrgente = scanner.nextLine();
                    banco.agregarClienteUrgente(nombreUrgente);
                    break;
                case 4:
                    banco.mostrarCola();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
