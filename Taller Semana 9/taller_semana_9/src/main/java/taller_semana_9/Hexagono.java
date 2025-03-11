package taller_semana_9;

public class Hexagono extends figuraRegular implements IfiguraRegular {

    public Hexagono(double medidaLados) {

        super(medidaLados);
    }

    @Override
    public void calcularArea() {
        double area = (3 * Math.sqrt(3) * Math.pow(getMedidaLados(), 2)) / 2;
        System.out.println("El area del hexagono es: " + area);
    }

    @Override
    public void calcularPerimetro() {
        double perimetro = getMedidaLados() * 6;
        System.out.println("El perimetro del hexagono es: " + perimetro);
    }

    @Override
    public void sumarAngulosPoligonos() {
        // 6 es el numero de lados
        double longitud = 180 * (6 - 2);
        System.out.println("La suma de los angulos del hexagono es: " + longitud);
    }

    @Override
    public void hallarLongitudApotema() {
        double apotema = (getMedidaLados() / 2) * Math.sqrt(3);
        System.out.println("La longitud hacia el apotema del hexagono es: " + apotema);
    }
}
