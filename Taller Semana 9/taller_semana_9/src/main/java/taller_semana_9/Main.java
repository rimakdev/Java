package taller_semana_9;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n" + "--------------------------------------------");
        System.out.println("CIRCULO" + "\n");

        Circulo circulo = new Circulo(3);
        circulo.hallarDiametroCirculo();
        circulo.calcularArea();
        circulo.calcularPerimetro();

        System.out.println("\n" + "--------------------------------------------");
        System.out.println("CUADRADO" + "\n");

        Cuadrado cuadrado = new Cuadrado(4);
        cuadrado.calcularArea();
        cuadrado.calcularPerimetro();
        cuadrado.hallarDiagonalCuadrados();

        System.out.println("\n" + "--------------------------------------------");
        System.out.println("TRIANGULO" + "\n");

        Triangulo triangulo = new Triangulo(5);
        triangulo.calcularArea();
        triangulo.calcularPerimetro();
        triangulo.hallarAlturaTriangulos();

        System.out.println("\n" + "--------------------------------------------");
        System.out.println("PENTAGONO" + "\n");

        Pentagono pentagono = new Pentagono(6);
        pentagono.calcularArea();
        pentagono.calcularPerimetro();
        pentagono.sumarAngulosPoligonos();
        pentagono.hallarLongitudApotema();

        System.out.println("\n" + "--------------------------------------------");
        System.out.println("HEXAGONO" + "\n");

        Hexagono hexagono = new Hexagono(7);
        hexagono.calcularArea();
        hexagono.calcularPerimetro();
        hexagono.sumarAngulosPoligonos();
        hexagono.hallarLongitudApotema();

        System.out.println("\n" + "--------------------------------------------");
        System.out.println("OCTAGONO" + "\n");

        Octagono octagono = new Octagono(8);
        octagono.calcularArea();
        octagono.calcularPerimetro();
        octagono.sumarAngulosPoligonos();
        octagono.hallarLongitudApotema();

        System.out.println("\n" + "--------------------------------------------");

    }
}
