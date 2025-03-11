package com.example.Punto6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Agregar producto al inventario
    public void agregarProducto(Producto producto) {
        if (!productos.contains(producto)) {
            productos.add(producto);
            System.out.println("Producto agregado: " + producto);
        } else {
            System.out.println("El producto con código " + producto.getCodigo() + " ya existe.");
        }
    }

    // Eliminar producto agotado por código
    public void eliminarProducto(String codigo) {
        productos.removeIf(producto -> producto.getCodigo().equals(codigo));
        System.out.println("Producto con código " + codigo + " eliminado.");
    }

    // Buscar producto por código
    public Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    // Listar productos ordenados por nombre
    public void listarPorNombre() {
        List<Producto> copia = new ArrayList<>(productos);
        copia.sort(Comparator.comparing(Producto::getNombre));
        System.out.println("Inventario ordenado por nombre:");
        copia.forEach(System.out::println);
    }

    // Listar productos ordenados por precio
    public void listarPorPrecio() {
        List<Producto> copia = new ArrayList<>(productos);
        copia.sort(Comparator.comparingDouble(Producto::getPrecio));
        System.out.println("Inventario ordenado por precio:");
        copia.forEach(System.out::println);
    }
}
