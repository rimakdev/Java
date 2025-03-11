package programacion2.hilos;

public class MainApp {
    public static void main(String[] args) {

        int [][] matrizDeprueba= {{60, 22, 41, 5},
                                  {13, 33, 44, 5},
                                  {89, 10, 100, 99},
                                  {5, 101, 6, 34}
        };

        Matriz matriz = new Matriz(matrizDeprueba);

        SumaArribaDiagonal sumaArriba = new SumaArribaDiagonal(matriz);
        PromedioAbajoDiagonal promedio = new PromedioAbajoDiagonal(matriz);

        Thread t1 = new Thread(sumaArriba);
        Thread t2 = new Thread(promedio);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();

            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        int a= sumaArriba.getResultado();
        double b= promedio.getResultado();
        double c= a*b;

        System.out.println("Resultado de la multiplicacion de a y b: " + c);
    }
}

