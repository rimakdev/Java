package com.example.modelo;

import java.util.UUID;

public class Usuario {
    private String id;
    private String email;
    private String password;
    private String telefono;
    private String nombre;
    private String cedula;
    private String direccion;

    public Usuario(String id, String email, String password, String telefono, String nombre, String cedula,
            String direccion) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public static Usuario crearUsuario(String nombre, String cedula, String telefono, String direccion, String email,
            String password) {
        return new Usuario(UUID.randomUUID().toString(), email, password, telefono, nombre, cedula, direccion);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getCedula()=" + getCedula()
                + ", getTelefono()=" + getTelefono() + ", getDireccion()=" + getDireccion() + ", getEmail()="
                + getEmail() + ", getPassword()=" + getPassword() + "]";
    }

}
