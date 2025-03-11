package com.example.Punto16;

import java.util.LinkedHashMap;
import java.util.Map;

class Supermercado {
    private LinkedHashMap<String, Double> carrito;

    public Supermercado() {
        this.carrito = new LinkedHashMap<>();
    }

    // Agregar un producto al carrito
    public void agregarProducto(String nombre, double precio) {
        carrito.put(nombre, precio);
        System.out.println("Producto agregado: " + nombre + " - $" + precio);
    }

    // Eliminar un producto si fue escaneado por error
    public void eliminarProducto(String nombre) {
        if (carrito.remove(nombre) != null) {
            System.out.println("Producto eliminado: " + nombre);
        } else {
            System.out.println("El producto no está en el carrito.");
        }
    }

    // Mostrar todos los productos en el orden escaneado
    public void mostrarCarrito() {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("\nProductos en el carrito:");
            for (Map.Entry<String, Double> entry : carrito.entrySet()) {
                System.out.println(entry.getKey() + " - $" + entry.getValue());
            }
        }
    }

    // Calcular el total de la compra
    public double calcularTotal() {
        double total = 0;
        for (double precio : carrito.values()) {
            total += precio;
        }
        return total;
    }
}
