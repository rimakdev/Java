package com.example;

public class Cuenta {
    private String id;
    private String nombreBanco;
    private String nroCuenta;
    private String tipoCuenta;
    private String cedulaUsuario;
    private double monto;

    public Cuenta(String id, String nombreBanco, String nroCuenta, String tipoCuenta, String cedulaUsuario,
            double monto) {
        this.id = id;
        this.nombreBanco = nombreBanco;
        this.nroCuenta = nroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.cedulaUsuario = cedulaUsuario;
        this.monto = monto;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return id + "," + nombreBanco + "," + nroCuenta + "," + tipoCuenta + "," + cedulaUsuario + "," + monto;
    }

    public static Cuenta fromString(String line) {
        String[] parts = line.split(",");
        return new Cuenta(parts[0], parts[1], parts[2], parts[3], parts[4], Double.parseDouble(parts[5]));
    }
}
