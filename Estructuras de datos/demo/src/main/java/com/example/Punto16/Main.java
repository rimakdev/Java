package com.example.Punto16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSUPERMERCADO - SISTEMA DE FACTURACIÓN");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar productos escaneados");
            System.out.println("4. Calcular total de la compra");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    supermercado.agregarProducto(nombre, precio);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    nombre = scanner.nextLine();
                    supermercado.eliminarProducto(nombre);
                    break;
                case 3:
                    supermercado.mostrarCarrito();
                    break;
                case 4:
                    System.out.println("Total de la compra: $" + supermercado.calcularTotal());
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
