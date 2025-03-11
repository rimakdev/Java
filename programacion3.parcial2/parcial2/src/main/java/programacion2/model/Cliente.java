package programacion2.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String zona;
    private List<String> codigosEnvios;

    public Cliente(String numeroIdentificacion, String tipoIdentificacion, String nombres, String apellidos,
            String telefono, String zona) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.zona = zona;
        this.codigosEnvios = new ArrayList<>();
    }

    public void agregarCodigoEnvio(String codigoEnvio) {
        codigosEnvios.add(codigoEnvio);
    }

    public String formatearCliente() {
        return numeroIdentificacion + "@" + tipoIdentificacion + "@" + nombres + "@" + apellidos + "@" + telefono + "@"
                + zona + "@" + String.join("%", codigosEnvios);
    }
}
