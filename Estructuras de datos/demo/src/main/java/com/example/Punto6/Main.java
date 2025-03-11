package com.example.Punto6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestión de Inventario");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Listar productos por nombre");
            System.out.println("5. Listar productos por precio");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    inventario.agregarProducto(new Producto(codigo, nombre, precio));
                    break;
                case 2:
                    System.out.print("Ingrese código del producto a eliminar: ");
                    String codEliminar = scanner.nextLine();
                    inventario.eliminarProducto(codEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese código del producto a buscar: ");
                    String codBuscar = scanner.nextLine();
                    Producto encontrado = inventario.buscarProducto(codBuscar);
                    System.out.println(
                            encontrado != null ? "Producto encontrado: " + encontrado : "Producto no encontrado.");
                    break;
                case 4:
                    inventario.listarPorNombre();
                    break;
                case 5:
                    inventario.listarPorPrecio();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
