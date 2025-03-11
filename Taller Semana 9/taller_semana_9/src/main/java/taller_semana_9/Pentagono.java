package taller_semana_9;

public class Pentagono extends figuraRegular implements IfiguraRegular {

    public Pentagono(double medidaLados) {

        super(medidaLados);
    }

    @Override
    public void calcularArea() {
        double area = (5 * getMedidaLados() * (getMedidaLados() * 5)) / 2;
        System.out.println("El area del pentagono es: " + area);
    }

    @Override
    public void calcularPerimetro() {
        double perimetro = getMedidaLados() * 5;
        System.out.println("El perimetro del pentagono es: " + perimetro);
    }

    @Override
    public void sumarAngulosPoligonos() {
        // 5 es el numero de lados
        double longitud = 180 * (5 - 2);
        System.out.println("La suma de los angulos del pentagono es: " + longitud);
    }

    @Override
    public void hallarLongitudApotema() {
        double apotema = getMedidaLados() / (2 * Math.tan(Math.PI / 5));
        System.out.println("La longitud hacia el apotema del pentagono es: " + apotema);
    }
}
