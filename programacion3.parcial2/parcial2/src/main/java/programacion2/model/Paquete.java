package programacion2.model;

import java.io.Serializable;

public class Paquete implements Serializable {
    private String codigo;
    private double peso;

    public Paquete() {
    }

    public Paquete(String codigo, double peso) {
        this.codigo = codigo;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
