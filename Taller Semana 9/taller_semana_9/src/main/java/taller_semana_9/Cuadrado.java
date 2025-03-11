package taller_semana_9;

public class Cuadrado extends figuraRegular implements IfiguraCuadrado {

    public Cuadrado(double medidaLados) {

        super(medidaLados);
    }

    @Override
    public void calcularArea() {

        double area = getMedidaLados() * getMedidaLados();

        System.out.println("El area del cuadrado es: " + area);
    }

    @Override
    public double calcularPerimetro() {
        // el perimetro es la suma de sus 4 lados
        double perimetro = getMedidaLados() * 4;
        System.out.println("El perimetro del cuadrado es: " + perimetro);
        return perimetro;
    }

    @Override
    public void hallarDiagonalCuadrados() {
        double diagonal = Math.sqrt(Math.pow(getMedidaLados(), 2) + Math.pow(getMedidaLados(), 2));
        System.out.println("La medida de la diagonal del cuadrado es: " + diagonal);
    }
}
