package com.example;

public class SudokuSolver {
    private static final int N = 9; // Tamaño del tablero de Sudoku

    public static void main(String[] args) {
        // Ejemplo de tablero de Sudoku a resolver
        int[][] tablero = {
                { 0, 0, 0, 0, 7, 2, 0, 0, 5 },
                { 2, 7, 5, 0, 0, 0, 4, 8, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 0, 2, 6, 7, 0, 0, 1, 0, 9 },
                { 3, 0, 0, 2, 0, 0, 0, 0, 0 },
                { 1, 8, 0, 0, 0, 5, 0, 2, 0 },
                { 0, 0, 0, 1, 0, 0, 9, 5, 0 },
                { 9, 3, 0, 0, 0, 0, 0, 1, 4 },
                { 4, 0, 1, 9, 0, 8, 0, 0, 0 }
        };

        if (resolverSudoku(tablero)) {
            imprimirTablero(tablero);
        } else {
            System.out.println("No se encontró solución para el Sudoku.");
        }
    }

    private static boolean resolverSudoku(int[][] tablero) {
        // Buscar una celda vacía en el tablero
        for (int fila = 0; fila < N; fila++) {
            for (int col = 0; col < N; col++) {
                if (tablero[fila][col] == 0) { // Celda vacía encontrada
                    for (int num = 1; num <= N; num++) {
                        if (esSeguro(tablero, fila, col, num)) {
                            tablero[fila][col] = num; // Colocar número
                            if (resolverSudoku(tablero)) {
                                return true; // Si se encuentra solución, retornar true
                            }
                            tablero[fila][col] = 0; // Backtracking
                        }
                    }
                    return false; // No se encontró número válido, retornar false
                }
            }
        }
        return true; // No se encontraron celdas vacías, Sudoku resuelto
    }

    private static boolean esSeguro(int[][] tablero, int fila, int col, int num) {
        // Verificar si 'num' ya está presente en la fila o columna
        for (int x = 0; x < N; x++) {
            if (tablero[fila][x] == num || tablero[x][col] == num) {
                return false;
            }
        }

        // Verificar si 'num' ya está presente en la subcuadrícula 3x3
        int inicioFila = fila - fila % 3;
        int inicioCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i + inicioFila][j + inicioCol] == num) {
                    return false;
                }
            }
        }
        return true; // El número puede ser colocado
    }

    private static void imprimirTablero(int[][] tablero) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(tablero[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % 3 == 0) {
                System.out.print("");
            }
        }
    }
}
