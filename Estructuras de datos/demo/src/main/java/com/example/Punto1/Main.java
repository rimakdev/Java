package com.example.Punto1;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        empresa.agregarProducto(new Producto("001", "Laptop", 1200.99));
        empresa.agregarProducto(new Producto("002", "Mouse", 25.50));
        empresa.agregarProducto(new Producto("003", "Teclado", 45.75));

        System.out.println("\nLista de productos:");
        empresa.mostrarProductos();

        System.out.println("\nBuscando producto con código '002':");
        Producto encontrado = empresa.buscarProducto("002");
        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
