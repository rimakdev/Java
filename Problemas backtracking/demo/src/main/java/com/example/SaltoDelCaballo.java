package com.example;

public class SaltoDelCaballo {
    // Movimientos posibles del caballo en el eje X e Y
    private static final int[] movimientosFila = { -2, -1, 1, 2, 2, 1, -1, -2 };
    private static final int[] movimientosColumna = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private static final int N = 8; // Tamaño del tablero

    public static void main(String[] args) {
        resolverSaltoDelCaballo();
    }

    private static void resolverSaltoDelCaballo() {
        int[][] tablero = new int[N][N];

        // Inicializar el tablero con -1 (casillas no visitadas)
        for (int[] fila : tablero) {
            for (int i = 0; i < fila.length; i++) {
                fila[i] = -1;
            }
        }

        // La posición inicial del caballo
        int inicioX = 0;
        int inicioY = 0;

        // El primer movimiento del caballo es en la posición inicial
        tablero[inicioX][inicioY] = 0;

        // Llamada recursiva inicial
        if (resolverSaltoDelCaballoUtil(inicioX, inicioY, 1, tablero)) {
            imprimirSolucion(tablero);
        } else {
            System.out.println("No existe solución para el problema.");
        }
    }

    private static boolean resolverSaltoDelCaballoUtil(int x, int y, int contadorMovimientos, int[][] tablero) {
        // Caso base: si el caballo ha realizado N*N movimientos, se encontró una
        // solución
        if (contadorMovimientos == N * N) {
            return true;
        }

        // Intentar todos los posibles movimientos del caballo
        for (int i = 0; i < 8; i++) {
            int siguienteX = x + movimientosFila[i];
            int siguienteY = y + movimientosColumna[i];
            if (esSeguro(siguienteX, siguienteY, tablero)) {
                tablero[siguienteX][siguienteY] = contadorMovimientos; // Hacer el movimiento
                // Llamada recursiva
                if (resolverSaltoDelCaballoUtil(siguienteX, siguienteY, contadorMovimientos + 1, tablero)) {
                    return true;
                }
                // Backtracking
                tablero[siguienteX][siguienteY] = -1; // Deshacer el movimiento
            }
        }
        return false;
    }

    private static boolean esSeguro(int x, int y, int[][] tablero) {
        return (x >= 0 && x < N && y >= 0 && y < N && tablero[x][y] == -1);
    }

    private static void imprimirSolucion(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int casilla : fila) {
                System.out.printf("%2d ", casilla);
            }
            System.out.println();
        }
    }
}
