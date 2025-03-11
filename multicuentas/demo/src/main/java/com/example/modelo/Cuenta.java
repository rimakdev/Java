package com.example.modelo;

import com.example.TipoCuenta;

public class Cuenta {
    private String idCuenta; // ID único de la cuenta
    private String nombreBanco; // Nombre del banco
    private String nroCuenta; // Número de cuenta
    private TipoCuenta tipoCuenta; // Tipo de cuenta (AHORROS o CORRIENTE)
    private String cedulaUsuario; // Cédula del usuario asociado

    // Constructor
    public Cuenta(String idCuenta, String nombreBanco, String nroCuenta, TipoCuenta tipoCuenta, String cedulaUsuario) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.nroCuenta = nroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.cedulaUsuario = cedulaUsuario;
    }

    // Getters y Setters
    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
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

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    // Método toString para mostrar la cuenta en formato legible
    @Override
    public String toString() {
        return "Banco: " + nombreBanco + " | Cuenta: " + nroCuenta + " | Tipo: " + tipoCuenta;
    }
}
