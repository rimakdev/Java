package com.example.Punto13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionHospital hospital = new GestionHospital();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n HOSPITAL - GESTIÓN DE PACIENTES ");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Ver siguiente paciente");
            System.out.println("4. Listar pacientes en espera");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la prioridad (1=Crítico, 2=Urgente, 3=Moderado, 4=Leve): ");
                    int prioridad = scanner.nextInt();
                    hospital.agregarPaciente(nombre, prioridad);
                    break;
                case 2:
                    hospital.atenderPaciente();
                    break;
                case 3:
                    hospital.verSiguientePaciente();
                    break;
                case 4:
                    hospital.listarPacientes();
                    break;
                case 5:
                    System.out.println(" Saliendo del sistema...");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
