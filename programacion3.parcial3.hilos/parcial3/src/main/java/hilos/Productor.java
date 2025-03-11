package hilos;

class Productor implements Runnable {
    private Buffer buffer;
    private char[] caracteres;
    private String tipo;
    private int espera;

    public Productor(Buffer buffer, char[] caracteres, String tipo, int espera) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.tipo = tipo;
        this.espera = espera;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                char c = caracteres[i];
                // Verifica el tipo y decide si el carácter puede ser producido
                if (tipo.equals("vocales") && esVocal(c) ||
                        tipo.equals("consonantes") && !esVocal(c) && Character.isLetter(c) ||
                        tipo.equals("numeros") && Character.isDigit(c)) {
                    buffer.producir(c); // Produce el carácter
                }
                i = (i + 1) % caracteres.length; // Continúa de nuevo desde el primer carácter
                Thread.sleep(espera); // Espera entre producciones
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean esVocal(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
