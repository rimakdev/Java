package programacion2.hilos;

public class PromedioAbajoDiagonal extends Thread {

    private final Matriz matriz;
    private double resultado;

    public PromedioAbajoDiagonal(Matriz matriz) {
        this.matriz = matriz;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
            resultado = matriz.PromedioAbajoDiagonal();
            System.out.println();
            System.out.println("El promedio total de la diagonal inferior es: " + resultado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getResultado() {
        return resultado;
    }
}