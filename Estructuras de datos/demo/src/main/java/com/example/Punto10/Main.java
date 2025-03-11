package com.example.Punto10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControlAcceso control = new ControlAcceso();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n Control de Acceso al Edificio");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Verificar acceso");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Mostrar empleados registrados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del empleado: ");
                    String idAgregar = scanner.nextLine();
                    control.registrarEmpleado(idAgregar);
                    break;
                case 2:
                    System.out.print("Ingrese el ID del empleado: ");
                    String idVerificar = scanner.nextLine();
                    control.verificarAcceso(idVerificar);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del empleado: ");
                    String idEliminar = scanner.nextLine();
                    control.eliminarEmpleado(idEliminar);
                    break;
                case 4:
                    control.mostrarEmpleados();
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
