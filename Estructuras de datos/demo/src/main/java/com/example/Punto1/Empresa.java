package com.example.Punto1;

import java.util.TreeSet;

public class Empresa {
    private TreeSet<Producto> productos;

    public Empresa() {
        this.productos = new TreeSet<>();
    }

    public void agregarProducto(Producto producto) {
        if (productos.add(producto)) {
            System.out.println("Producto agregado: " + producto.getNombre());
        } else {
            System.out.println("El producto ya existe.");
        }
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null; // No encontrado
    }

    public void mostrarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}
