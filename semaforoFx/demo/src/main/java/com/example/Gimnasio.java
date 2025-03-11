package com.example;

import java.util.concurrent.Semaphore;

public class Gimnasio {
    private Semaphore semaforo;

    public Gimnasio(int capacidad) {
        semaforo = new Semaphore(capacidad);
    }

    public void entrar(String nombre, Runnable esperaTurnoAviso, Runnable entradaAviso,
            Runnable salidaAviso)
            throws InterruptedException {
        // Mostrar que la persona está en espera activa
        esperaTurnoAviso.run();

        // Intentar adquirir un permiso para entrar al gimnasio
        semaforo.acquire();
        System.out.println(nombre + " ha entrado al gimnasio.");

        // Actualizar interfaz al entrar
        entradaAviso.run();

        // Simular tiempo dentro del gimnasio
        Thread.sleep((long) (Math.random() * 30000));

        System.out.println(nombre + " ha salido del gimnasio.");

        // Liberar el permiso y actualizar interfaz al salir
        semaforo.release();
        salidaAviso.run();
    }
}
