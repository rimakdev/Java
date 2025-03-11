package com.example.Punto12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionEstudiantes gestion = new GestionEstudiantes();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nUniversidad - Gestión de Estudiantes ");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Ver primer estudiante");
            System.out.println("5. Ver último estudiante");
            System.out.println("6. Verificar si un estudiante está registrado");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreAgregar = scanner.nextLine();
                    gestion.agregarEstudiante(nombreAgregar);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreEliminar = scanner.nextLine();
                    gestion.eliminarEstudiante(nombreEliminar);
                    break;
                case 3:
                    gestion.listarEstudiantes();
                    break;
                case 4:
                    gestion.primerEstudiante();
                    break;
                case 5:
                    gestion.ultimoEstudiante();
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreVerificar = scanner.nextLine();
                    gestion.verificarEstudiante(nombreVerificar);
                    break;
                case 7:
                    System.out.println(" Saliendo del sistema...");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
