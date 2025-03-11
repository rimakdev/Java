package taller_semana_9;

public class Circulo extends figuraRegular implements IfiguraCirculo {

    // medida lados en el caso del circulo es el radio

    public Circulo(double medidaLados) {
        // super accede y llama a funciones del padre
        super(medidaLados);
    }

    @Override
    public void calcularArea() {
        double area = Math.PI * getMedidaLados() * getMedidaLados();
        System.out.println("El area del circulo es: " + area);
    }

    @Override
    public void calcularPerimetro() {
        double perimetro = 2 * (Math.PI * getMedidaLados());
        System.out.println("El perimetro del circulo es: " + perimetro);
    }

    @Override
    public void hallarDiametroCirculo() {
        double diametro = 2 * getMedidaLados();
        System.out.println("El diametro del circulo es: " + diametro);
    }

}