package com.example;

public class NReinas {
    private static final int N = 8; // Tamaño del tablero y número de reinas

    public static void main(String[] args) {
        resolverNReinas();
    }

    private static void resolverNReinas() {
        int[][] tablero = new int[N][N];

        if (resolverNReinasUtil(tablero, 0)) {
            imprimirTablero(tablero);
        } else {
            System.out.println("No se encontró una solución para las " + N + " reinas.");
        }
    }

    private static boolean resolverNReinasUtil(int[][] tablero, int fila) {
        // Caso base: si todas las reinas están colocadas
        if (fila >= N) {
            return true;
        }

        // Intentar colocar la reina en todas las columnas de la fila actual
        for (int col = 0; col < N; col++) {
            if (esSeguro(tablero, fila, col)) {
                tablero[fila][col] = 1; // Colocar reina

                // Llamada recursiva para colocar la siguiente reina
                if (resolverNReinasUtil(tablero, fila + 1)) {
                    return true;
                }

                // Backtracking: deshacer el movimiento
                tablero[fila][col] = 0;
            }
        }
        return false; // No se puede colocar una reina en esta fila
    }

    private static boolean esSeguro(int[][] tablero, int fila, int col) {
        // Verificar la columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 1) {
                return false;
            }
        }

        // Verificar la diagonal superior izquierda
        for (int i = fila, j = col; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        // Verificar la diagonal superior derecha
        for (int i = fila, j = col; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
