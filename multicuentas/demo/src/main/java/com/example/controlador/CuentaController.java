package com.example.controlador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.example.TipoCuenta;
import com.example.modelo.Cuenta;

public class CuentaController {

    // Ruta del archivo donde se almacenan las cuentas
    private static final String ARCHIVO_CUENTAS = "demo\\cuentas.txt";

    // Lista para almacenar las cuentas cargadas
    private List<Cuenta> cuentas;

    // Constructor de la clase
    public CuentaController() {
        this.cuentas = new ArrayList<>();
        cargarCuentas(); // Cargar cuentas desde el archivo al inicializar la clase
    }

    /**
     * Carga las cuentas desde el archivo "cuentas.txt".
     * 
     * @return una lista de cuentas cargadas desde el archivo
     */
    public void cargarCuentas() {
        File archivo = new File(ARCHIVO_CUENTAS);

        // Verificamos si el archivo existe
        if (!archivo.exists()) {
            System.out.println("El archivo de cuentas no existe.");
            return; // Si no existe, terminamos el método
        }

        // Intentamos leer el archivo y cargar los datos
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leemos línea por línea el archivo
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(","); // Dividimos la línea en partes usando la coma como delimitador
                if (partes.length == 5) { // Aseguramos que la línea tenga 5 partes: idCuenta, nombreBanco, nroCuenta,
                                          // tipoCuenta, cedulaUsuario
                    TipoCuenta tipoCuenta = TipoCuenta.valueOf(partes[3].trim()); // Convertimos el tipo de cuenta a un
                                                                                  // valor enum
                    cuentas.add(new Cuenta(partes[0], partes[1], partes[2], tipoCuenta, partes[4])); // Creamos la
                                                                                                     // cuenta y la
                                                                                                     // agregamos a la
                                                                                                     // lista
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar cuentas: " + e.getMessage()); // En caso de error, mostramos el mensaje
        }
    }

    /**
     * Agrega una nueva cuenta a la lista y al archivo.
     * 
     * @param cuenta la cuenta a agregar
     */
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta); // Agregar la cuenta a la lista de cuentas
        guardarCuentas(); // Guardamos las cuentas en el archivo
    }

    /**
     * Guarda las cuentas actuales en el archivo "cuentas.txt".
     */
    private void guardarCuentas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CUENTAS))) {
            for (Cuenta cuenta : cuentas) {
                // Escribimos los datos de cada cuenta en una línea del archivo
                writer.write(cuenta.getIdCuenta() + "," + cuenta.getNombreBanco() + "," + cuenta.getNroCuenta() + ","
                        + cuenta.getTipoCuenta() + "," + cuenta.getCedulaUsuario());
                writer.newLine(); // Nueva línea para la siguiente cuenta
            }
        } catch (IOException e) {
            System.out.println("Error al guardar cuentas: " + e.getMessage()); // En caso de error, mostramos el mensaje
        }
    }

    /**
     * Obtiene todas las cuentas de la lista.
     * 
     * @return lista de cuentas
     */
    public List<Cuenta> obtenerCuentas() {
        return cuentas;
    }

    /**
     * Obtiene las cuentas asociadas a un usuario basado en su cédula.
     * 
     * @param cedulaUsuario la cédula del usuario a buscar
     * @return lista de cuentas asociadas al usuario
     */
    public List<Cuenta> obtenerCuentasPorUsuario(String cedulaUsuario) {
        List<Cuenta> cuentasUsuario = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getCedulaUsuario().equals(cedulaUsuario)) {
                cuentasUsuario.add(cuenta); // Si la cédula coincide, agregamos la cuenta a la lista
            }
        }
        return cuentasUsuario;
    }

    /**
     * Elimina una cuenta de la lista y del archivo, buscando por el id de la
     * cuenta.
     * 
     * @param idCuenta el id de la cuenta a eliminar
     */
    public void eliminarCuenta(String idCuenta) {
        Cuenta cuentaAEliminar = null;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                cuentaAEliminar = cuenta;
                break; // Si encontramos la cuenta, salimos del ciclo
            }
        }

        if (cuentaAEliminar != null) {
            cuentas.remove(cuentaAEliminar); // Eliminamos la cuenta de la lista
            guardarCuentas(); // Guardamos las cuentas actualizadas en el archivo
            System.out.println("Cuenta eliminada con éxito.");
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public String generarIdCuenta() {
        return UUID.randomUUID().toString();
    }

    public String generarNumeroCuenta() {
        long numeroCuenta = ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L);
        return String.valueOf(numeroCuenta);
    }
}
