package programacion2.hilos;

public class Matriz {

    private final int[][] matriz;

    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int sumaArribaDiagonalRecursiva(int fila, int columna) {
        if (fila >= matriz.length) {
            return 0;
        }
        if (columna >= matriz[fila].length) {
            return sumaArribaDiagonalRecursiva(fila + 1, fila + 2);
        }
        return matriz[fila][columna] + sumaArribaDiagonalRecursiva(fila, columna + 1);
    }

    public double PromedioAbajoDiagonal() {
        int suma = 0;
        int cantidad = 0;
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
                suma += matriz[i][j];
                cantidad++;
            }
        }
        if (cantidad == 0) {
            return 0;
        } else {
            return (double) suma / cantidad;
        }
    }
}
