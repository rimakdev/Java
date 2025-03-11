package com.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EstadoPersona {
    private final StringProperty nombre;
    private final StringProperty estado;

    public EstadoPersona(String nombre, String estado) {
        this.nombre = new SimpleStringProperty(nombre);
        this.estado = new SimpleStringProperty(estado);
    }

    // el property hace que en javaFx cambie el estado automaticamente
    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty estadoProperty() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }
}
