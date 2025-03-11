package notacion_polaca;

import java.util.ArrayList;

public class NotacionPolaca implements EscritorExpresionesInterface {

    @Override
    public ArrayList<String> reescribirExpresion(ArrayList<String> expresionNormal) {
        ArrayList<String> expresionPolaca = new ArrayList<>();
        ArrayList<String> operadores = new ArrayList<>();

        // recorre cada elemento del arraylist
        for (int i = 0; i < expresionNormal.size(); i++) {
            String elemento = expresionNormal.get(i);

            // Si el elemento no es un operador, se añade a la expresion
            if (!esOperador(elemento)) {
                expresionPolaca.add(elemento);
            } else {
                // compara su prioridad y lo añade
                while (!operadores.isEmpty()
                        && calcularPrioridad(operadores.get(operadores.size() - 1)) >= calcularPrioridad(elemento)) {
                    expresionPolaca.add(operadores.remove(operadores.size() - 1));
                }
                // Añade el operador actual a la pila de operadores
                operadores.add(elemento);
            }
        }

        // Agrega los operadores restantes de la pila a la expresión polaca
        while (!operadores.isEmpty()) {
            expresionPolaca.add(operadores.remove(operadores.size() - 1));
        }

        // Devuelve la expresión en notación polaca
        return expresionPolaca;
    }

    public int evaluarExpresion(ArrayList<String> expresion) {
        ArrayList<Integer> pila = new ArrayList<>();

        for (int i = 0; i < expresion.size(); i++) {
            String operador = expresion.get(i);

            // Si el operador no es un operador, lo convierte a entero y lo agrega a la pila
            if (!esOperador(operador)) {
                pila.add(Integer.parseInt(operador));
            } else {
                // realiza la opereacion y lo devuelve a la pila
                int numero2 = pila.remove(pila.size() - 1);
                int numero1 = pila.remove(pila.size() - 1);
                int resultado = aplicarOperador(operador, numero1, numero2);
                pila.add(resultado);
            }
        }

        // El resultado final estará en la cima de la pila
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
