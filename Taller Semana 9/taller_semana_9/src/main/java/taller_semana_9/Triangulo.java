package taller_semana_9;

public class Triangulo extends figuraRegular implements IfiguraTriangulo {

    public Triangulo(double medidaLados) {
        super(medidaLados);
    }

    @Override
    public void hallarAlturaTriangulos() {
        double altura = (Math.sqrt(3) / 2) * getMedidaLados();
        System.out.println("La altura del triangulo es: " + altura);
    }

    @Override
    public void calcularArea() {
        double area = (getMedidaLados() * ((Math.sqrt(3) / 2) * getMedidaLados())) / 2;
        System.out.println("El area del triangulo es: " + area);
    }

    @Override
    public void calcularPerimetro() {
        // es la suma de sus 3 lados
        double perimetro = getMedidaLados() * 3;
        System.out.println("El perimetro del triangulo es: " + perimetro);
    }

}
