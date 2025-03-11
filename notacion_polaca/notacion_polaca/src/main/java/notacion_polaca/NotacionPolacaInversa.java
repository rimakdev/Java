package notacion_polaca;

import java.util.ArrayList;

public class NotacionPolacaInversa implements EscritorExpresionesInterface {

    @Override
    public ArrayList<String> reescribirExpresion(ArrayList<String> expresionNormal) {
        ArrayList<String> expresionPolacaInversa = new ArrayList<>();
        ArrayList<String> operadores = new ArrayList<>();

        // recorre cada elemento del arraylist
        for (int i = expresionNormal.size() - 1; i >= 0; i--) {
            String elemento = expresionNormal.get(i);

            // Si el elemento no es un operador, se añade a la expresion
            if (!esOperador(elemento)) {
                expresionPolacaInversa.add(elemento);
            } else {
                // compara su prioridad y lo añade
                while (!operadores.isEmpty() &&
                        calcularPrioridad(operadores.get(operadores.size() - 1)) > calcularPrioridad(elemento)) {
                    expresionPolacaInversa.add(operadores.remove(operadores.size() - 1));
                }
                // Añade el operador actual a la pila de operadores
                operadores.add(elemento);
            }
        }

        // Agrega los operadores restantes de la pila a la expresión polaca inversa
        while (!operadores.isEmpty()) {
            expresionPolacaInversa.add(operadores.remove(operadores.size() - 1));
        }

        // Devuelve la expresión en notación polaca inversa
        return expresionPolacaInversa;
    }

    public int evaluarExpresion(ArrayList<String> expresion) {
        ArrayList<Integer> pila = new ArrayList<>();

        for (int i = expresion.size() - 1; i >= 0; i--) {
            String operador = expresion.get(i);

            if (!esOperador(operador)) {
                pila.add(Integer.parseInt(operador));
            } else {
                int numero1 = pila.remove(pila.size() - 1);
                int numero2 = pila.remove(pila.size() - 1);
                int resultado = aplicarOperador(operador, numero1, numero2);
                pila.add(resultado);
            }
        }

        return pila.get(0);
    }

    // aplica los operandos/operaciones
    private int aplicarOperador(String operador, int numero1, int numero2) {
        int resultado = 0;

        if (operador.equals("^")) {
            resultado = (int) Math.pow(numero1, numero2);
        } else if (operador.equals("*")) {
            resultado = numero1 * numero2;
        } else if (operador.equals("/")) {
            if (numero2 != 0) {
                resultado = numero1 / numero2;
            } else {
                System.out.println("Error: División por cero no permitida.");
            }
        } else if (operador.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operador.equals("-")) {
            resultado = numero1 - numero2;
        } else {
            System.out.println("Error: Operador no válido: " + operador);
        }

        return resultado;
    }
}
