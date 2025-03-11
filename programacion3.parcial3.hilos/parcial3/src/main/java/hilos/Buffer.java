package hilos;

class Buffer {
    private final char[] buffer;
    private int capacidad;
    private int frente;
    private int fin;
    private int cantidad;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        this.buffer = new char[capacidad];
        this.frente = 0;
        this.fin = 0;
        this.cantidad = 0;
    }

    public synchronized void producir(char c) throws InterruptedException {
        while (cantidad == capacidad) {
            wait();
        }
        buffer[fin] = c;
        fin = (fin + 1) % capacidad;
        cantidad++;
        notifyAll();
    }

    public synchronized char[] consumir() throws InterruptedException {
        while (cantidad < 1) {
            wait();
        }
        char[] caracteres = new char[1];
        for (int i = 0; i < 1; i++) {
            caracteres[i] = buffer[frente];
            frente = (frente + 1) % capacidad;
            cantidad--;
        }
        notifyAll();
        return caracteres;
    }
}
