package notacion_polaca;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> expresionNormal = new ArrayList<>();
        expresionNormal.add("2");
        expresionNormal.add("*");
        expresionNormal.add("3");
        expresionNormal.add("+");
        expresionNormal.add("4");

        NotacionPolaca calculadora = new NotacionPolaca();
        ArrayList<String> expresionPolaca = calculadora.reescribirExpresion(expresionNormal);
        System.out.println("Expresión en notación polaca: " + expresionPolaca);

        int resultado = calculadora.evaluarExpresion(expresionPolaca);
        System.out.println("Resultado: " + resultado); // resultado 10

        ArrayList<String> expresionNormalInversa = new ArrayList<>();
        expresionNormalInversa.add("2");
        expresionNormalInversa.add("*");
        expresionNormalInversa.add("3");
        expresionNormalInversa.add("+");
        expresionNormalInversa.add("4");

        NotacionPolacaInversa calcular = new NotacionPolacaInversa();
        ArrayList<String> expresionPolacaInversa = calcular.reescribirExpresion(expresionNormalInversa);
        System.out.println("Expresión en notación polaca inversa: " + expresionPolacaInversa);

        int resultadoInversa = calculadora.evaluarExpresion(expresionPolacaInversa);
        System.out.println("Resultado: " + resultadoInversa); // resultado 10
    }

}
