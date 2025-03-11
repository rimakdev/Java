package com.example.Punto17;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgendaEventos agenda = new AgendaEventos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nAGENDA DE EVENTOS");
            System.out.println("1. Agregar evento");
            System.out.println("2. Eliminar evento");
            System.out.println("3. Mostrar eventos ordenados");
            System.out.println("4. Mostrar evento más próximo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la fecha del evento (YYYY-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());
                    System.out.print("Ingrese la descripción del evento: ");
                    String descripcion = scanner.nextLine();
                    agenda.agregarEvento(fecha, descripcion);
                    break;
                case 2:
                    System.out.print("Ingrese la fecha del evento a eliminar (YYYY-MM-DD): ");
                    fecha = LocalDate.parse(scanner.nextLine());
                    agenda.eliminarEvento(fecha);
                    break;
                case 3:
                    agenda.mostrarEventos();
                    break;
                case 4:
                    agenda.mostrarEventoMasProximo();
                    break;
                case 5:
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
