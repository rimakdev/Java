package programacion2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Envio implements Serializable {
    private String codigo;
    private Date fechaEnvio;
    private String zona;
    private double total;
    private String nombreCliente;
    private List<Paquete> paquetes;

    // Constructor vacío y con parámetros, getters y setters
    public Envio() {
    }

    public Envio(String codigo, Date fechaEnvio, String zona, double total, String nombreCliente,
            List<Paquete> paquetes) {
        this.codigo = codigo;
        this.fechaEnvio = fechaEnvio;
        this.zona = zona;
        this.total = total;
        this.nombreCliente = nombreCliente;
        this.paquetes = paquetes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
}
