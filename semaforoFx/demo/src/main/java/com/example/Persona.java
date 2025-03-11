package com.example;

public class Persona implements Runnable {
    private String nombre;
    private Gimnasio gimnasio;
    private Runnable esperandoTurnoAviso;
    private Runnable entrandoAviso;
    private Runnable saliendoAviso;

    public Persona(String nombre, Gimnasio gimnasio, Runnable esperandoTurnoAviso, Runnable entrandoAviso,
            Runnable saliendoAviso) {
        this.nombre = nombre;
        this.gimnasio = gimnasio;
        this.esperandoTurnoAviso = esperandoTurnoAviso;
        this.entrandoAviso = entrandoAviso;
        this.saliendoAviso = saliendoAviso;
    }

    @Override
    public void run() {
        try {
            // Ejecutar el callback de espera
            esperandoTurnoAviso.run();

            // Intentar entrar al gimnasio llamando al método 'entrar' en 'Gimnasio'
            gimnasio.entrar(nombre, esperandoTurnoAviso, entrandoAviso, saliendoAviso);

        } catch (InterruptedException e) {
            System.out.println(nombre + " ha sido interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}
