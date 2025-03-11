package programacion2.hilos;

public class SumaArribaDiagonal extends Thread {

    private final Matriz matriz;
    private int resultado;

    public SumaArribaDiagonal(Matriz matriz) {
        this.matriz = matriz;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
            resultado = matriz.sumaArribaDiagonalRecursiva(0, 1);
            System.out.println("La suma total de la parte superior de la diagonal es: " + resultado);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getResultado() {
        return resultado;
    }

}