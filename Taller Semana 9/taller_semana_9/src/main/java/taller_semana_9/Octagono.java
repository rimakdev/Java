package taller_semana_9;

public class Octagono extends figuraRegular implements IfiguraRegular {

    public Octagono(double medidaLados) {

        super(medidaLados);
    }

    @Override
    public void calcularArea() {
        double area = 4 * getMedidaLados() * getMedidaLados() * Math.sin(Math.PI / 4);
        System.out.println("El area del octagono es: " + area);
    }

    @Override
    public void calcularPerimetro() {
        double perimetro = getMedidaLados() * 8;
        System.out.println("El perimetro del octagono es: " + perimetro);
    }

    @Override
    public void sumarAngulosPoligonos() {
        // 8 es el numero de lados
        double longitud = 180 * (8 - 2);
        System.out.println("La suma de los angulos del octagono es: " + longitud);
    }

    @Override
    public void hallarLongitudApotema() {
        double apotema = (getMedidaLados() / 2) * (1 + Math.sqrt(2));
        System.out.println("La longitud hacia el apotema del octagono es: " + apotema);
    }

}
