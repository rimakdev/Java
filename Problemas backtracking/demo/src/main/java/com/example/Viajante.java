package com.example;

public class Viajante {
    private static int numCiudades;
    private static int[][] grafo; // Matriz de costos entre ciudades
    private static boolean[] visitado; // Ciudades visitadas
    private static int costoMinimo = Integer.MAX_VALUE; // Costo mínimo inicializado a un valor alto

    public static void main(String[] args) {
        grafo = new int[][] {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };
        numCiudades = grafo.length;
        visitado = new boolean[numCiudades];

        // Iniciar el recorrido desde la primera ciudad (índice 0)
        visitado[0] = true;
        resolverViajante(0, 1, 0);

        System.out.println("El costo mínimo es: " + costoMinimo);
    }

    private static void resolverViajante(int ciudadActual, int contadorCiudades, int costoActual) {
        // Caso base: si se han visitado todas las ciudades
        if (contadorCiudades == numCiudades) {
            // Añadir el costo de regresar a la ciudad de origen
            costoActual += grafo[ciudadActual][0];
            // Actualizar el costo mínimo si es necesario
            if (costoActual < costoMinimo) {
                costoMinimo = costoActual;
            }
            return;
        }

        // Recorrer todas las ciudades
        for (int i = 0; i < numCiudades; i++) {
            // Si la ciudad no ha sido visitada y hay una ruta válida
            if (!visitado[i] && grafo[ciudadActual][i] > 0) {
                // Marcar la ciudad como visitada
                visitado[i] = true;
                // Llamada recursiva para visitar la siguiente ciudad
                resolverViajante(i, contadorCiudades + 1, costoActual + grafo[ciudadActual][i]);
                // Backtracking: desmarcar la ciudad para probar otra ruta
                visitado[i] = false;
            }
        }
    }
}
