package com.example.Punto11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FavoritosMusica favoritos = new FavoritosMusica();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nAplicación de Música - Favoritos ");
            System.out.println("1. Agregar canción a favoritos");
            System.out.println("2. Eliminar canción de favoritos");
            System.out.println("3. Mostrar canciones favoritas");
            System.out.println("4. Verificar si una canción es favorita");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la canción: ");
                    String cancionAgregar = scanner.nextLine();
                    favoritos.agregarCancion(cancionAgregar);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la canción: ");
                    String cancionEliminar = scanner.nextLine();
                    favoritos.eliminarCancion(cancionEliminar);
                    break;
                case 3:
                    favoritos.mostrarFavoritas();
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la canción: ");
                    String cancionVerificar = scanner.nextLine();
                    favoritos.verificarFavorita(cancionVerificar);
                    break;
                case 5:
                    System.out.println(" Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
