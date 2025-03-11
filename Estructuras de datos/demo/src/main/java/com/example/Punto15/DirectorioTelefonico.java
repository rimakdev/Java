package com.example.Punto15;

import java.util.HashMap;
import java.util.Map;

class DirectorioTelefonico {
    private Map<String, String> directorio;

    public DirectorioTelefonico() {
        this.directorio = new HashMap<>();
    }

    // Agregar un contacto
    public void agregarContacto(String nombre, String telefono) {
        if (directorio.containsKey(nombre)) {
            System.out.println("El contacto ya existe. Actualizando número...");
        }
        directorio.put(nombre, telefono);
        System.out.println("Contacto agregado: " + nombre + " -> " + telefono);
    }

    // Buscar un contacto
    public void buscarContacto(String nombre) {
        if (directorio.containsKey(nombre)) {
            System.out.println(nombre + " -> " + directorio.get(nombre));
        } else {
            System.out.println("El contacto no existe.");
        }
    }

    // Eliminar un contacto
    public void eliminarContacto(String nombre) {
        if (directorio.remove(nombre) != null) {
            System.out.println("Contacto eliminado: " + nombre);
        } else {
            System.out.println("El contacto no existe.");
        }
    }

    // Listar todos los contactos
    public void mostrarContactos() {
        if (directorio.isEmpty()) {
            System.out.println("El directorio está vacío.");
        } else {
            System.out.println("Lista de contactos:");
            for (Map.Entry<String, String> entry : directorio.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
