package com.example.Punto11;

import java.util.LinkedHashSet;

public class FavoritosMusica {
    private LinkedHashSet<String> cancionesFavoritas;

    public FavoritosMusica() {
        this.cancionesFavoritas = new LinkedHashSet<>();
    }

    // Agregar una canción a favoritos
    public void agregarCancion(String cancion) {
        if (cancionesFavoritas.add(cancion)) {
            System.out.println(cancion + " añadida a favoritos.");
        } else {
            System.out.println(cancion + " ya está en favoritos.");
        }
    }

    // Eliminar una canción de favoritos
    public void eliminarCancion(String cancion) {
        if (cancionesFavoritas.remove(cancion)) {
            System.out.println(cancion + " eliminada de favoritos.");
        } else {
            System.out.println(cancion + " no está en favoritos.");
        }
    }

    // Mostrar todas las canciones favoritas en orden de inserción
    public void mostrarFavoritas() {
        if (cancionesFavoritas.isEmpty()) {
            System.out.println("No hay canciones favoritas.");
        } else {
            System.out.println(" Canciones favoritas:");
            for (String cancion : cancionesFavoritas) {
                System.out.println("   - " + cancion);
            }
        }
    }

    // Verificar si una canción está en favoritos
    public void verificarFavorita(String cancion) {
        if (cancionesFavoritas.contains(cancion)) {
            System.out.println(cancion + " está en favoritos.");
        } else {
            System.out.println(cancion + " no está en favoritos.");
        }
    }
}
