package hilos;

import java.util.ArrayList;

class Consumidor implements Runnable {
    private Buffer buffer;
    private char[] palabraObjetivo;
    private char[] palabraActual;
    private ArrayList<Character> letrasSobrantes;

    public Consumidor(Buffer buffer, char[] palabraObjetivo) {
        this.buffer = buffer;
        this.palabraObjetivo = palabraObjetivo;
        this.palabraActual = new char[palabraObjetivo.length];
        this.letrasSobrantes = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            while (!palabraCompleta()) {
                char[] caracteres = buffer.consumir(); // Consume 1 caracter a la vez
                for (char c : caracteres) {
                    int pos = posicionEnPalabra(c);
                    if (pos != -1 && palabraActual[pos] != c) {
                        palabraActual[pos] = c; // Coloca el carácter en la posición correcta
                    } else {
                        letrasSobrantes.add(c); // Agrega a la lista de sobrantes
                    }
                }
                mostrarPalabraActual();
                Thread.sleep(1200); // Espera entre consumos
            }
            System.out.println("las letras sobrantes son: " + letrasSobrantes.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized boolean palabraCompleta() {
        return new String(palabraActual).equals(new String(palabraObjetivo));
    }

    private int posicionEnPalabra(char c) {
        for (int i = 0; i < palabraObjetivo.length; i++) {
            if (palabraObjetivo[i] == c && palabraActual[i] != c) {
                return i; // Retorna la posición correcta si el carácter es válido
            }
        }
        return -1;
    }

    private void mostrarPalabraActual() {
        System.out.println("Palabra actual: " + new String(palabraActual));
    }

}
