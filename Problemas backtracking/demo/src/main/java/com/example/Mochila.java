package com.example;

public class Mochila {
    private static int maxValor = 0; // Para almacenar el valor máximo obtenido

    public static void main(String[] args) {
        int[] pesos = { 2, 3, 4, 5 }; // Pesos de los elementos
        int[] valores = { 3, 4, 5, 6 }; // Valores de los elementos
        int capacidad = 5; // Capacidad máxima de la mochila

        // Llamar al método para resolver el problema con backtracking
        resolverMochilaBacktracking(pesos, valores, capacidad, 0, 0, 0);
        System.out.println("El valor máximo que se puede obtener es: " + maxValor);
    }

    // Método para resolver el problema de la mochila con backtracking
    private static void resolverMochilaBacktracking(int[] pesos, int[] valores, int capacidad, int indice,
            int valorActual, int pesoActual) {
        // Si el peso actual excede la capacidad, no continuar
        if (pesoActual > capacidad) {
            return;
        }

        // Actualizar el valor máximo
        if (valorActual > maxValor) {
            maxValor = valorActual;
        }

        // Recorrer todos los ítems restantes
        for (int i = indice; i < pesos.length; i++) {
            // Incluir el ítem actual y llamar recursivamente para el siguiente
            resolverMochilaBacktracking(pesos, valores, capacidad, i + 1, valorActual + valores[i],
                    pesoActual + pesos[i]);
        }
    }
}
