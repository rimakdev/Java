package com.example.Punto15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DirectorioTelefonico directorio = new DirectorioTelefonico();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nDIRECTORIO TELEFÓNICO");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el número de teléfono: ");
                    String telefono = scanner.nextLine();
                    directorio.agregarContacto(nombre, telefono);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre a buscar: ");
                    nombre = scanner.nextLine();
                    directorio.buscarContacto(nombre);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    directorio.eliminarContacto(nombre);
                    break;
                case 4:
                    directorio.mostrarContactos();
                    break;
                case 5:
                    System.out.println("Saliendo del directorio...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
