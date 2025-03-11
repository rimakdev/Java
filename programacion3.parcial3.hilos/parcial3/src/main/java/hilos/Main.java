package hilos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(8); // Buffer de 8 caracteres
        ArrayList<Character> letrasSobrantes = new ArrayList<>();
        char[] palabraObjetivo = "otorrin0lar1ng010go".toCharArray();
        char[] caracteres = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

        Consumidor consumidor = new Consumidor(buffer, palabraObjetivo);
        Thread consumidorThread = new Thread(consumidor);

        Productor p3 = new Productor(buffer, caracteres, "numeros", 1000);
        Productor p2 = new Productor(buffer, caracteres, "consonantes", 2000);
        Productor p1 = new Productor(buffer, caracteres, "vocales", 300);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);

        t1.start();
        t2.start();
        t3.start();
        consumidorThread.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            consumidorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Guardar letras sobrantes en archivo
        // cambiar
        System.out.println(letrasSobrantes);

    }
}
