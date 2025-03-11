package taller_semana_9;

public interface IfiguraCuadrado {

    void calcularArea();

    default double calcularPerimetro(){
        double perimetro=0;
        return perimetro;
    };

    void hallarDiagonalCuadrados();
}
