package com.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CuentaManager {
    // Ruta al archivo que almacena las cuentas en disco
    private static final String CUENTAS_FILE = "demo\\cuentas.txt";

    // Mapa para almacenar las cuentas, donde la clave es el número de cuenta
    private Map<String, Cuenta> cuentas;

    // Constructor que inicializa el mapa de cuentas y carga las cuentas desde el
    // archivo
    public CuentaManager() throws IOException {
        cuentas = new HashMap<>(); // Inicializa el mapa vacío
        cargarCuentas(); // Carga las cuentas desde el archivo
    }

    /**
     * Método para cargar las cuentas desde el archivo de texto.
     * Si el archivo no existe, no realiza ninguna acción.
     */
    public void cargarCuentas() throws IOException {
        File file = new File(CUENTAS_FILE); // Referencia al archivo de cuentas
        if (!file.exists()) // Si el archivo no existe, se detiene el método
            return;

        // Lector para leer el contenido del archivo línea por línea
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) { // Lee cada línea hasta llegar al final
                // Crea una cuenta a partir de la línea leída
                Cuenta cuenta = Cuenta.fromString(line);
                // Agrega la cuenta al mapa usando su número como clave
                cuentas.put(cuenta.getNroCuenta(), cuenta);
            }
        }
    }

    /**
     * Método para guardar las cuentas en el archivo de texto.
     * Sobrescribe el archivo con el estado actual de las cuentas.
     */
    public void guardarCuentas() throws IOException {
        // Escritor para escribir el contenido en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUENTAS_FILE))) {
            for (Cuenta cuenta : cuentas.values()) { // Itera sobre todas las cuentas en el mapa
                writer.write(cuenta.toString()); // Convierte cada cuenta a texto y la escribe en el archivo
                writer.newLine(); // Agrega una nueva línea después de cada cuenta
            }
        }
    }

    /**
     * Retorna todas las cuentas almacenadas en un mapa.
     * 
     * @return Mapa de cuentas con el número de cuenta como clave.
     */
    public Map<String, Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * Busca una cuenta específica en el mapa por su número de cuenta.
     * 
     * @param numeroCuenta Número de cuenta a buscar.
     * @return La cuenta si existe, o null si no se encuentra.
     */
    public Cuenta buscarCuenta(String numeroCuenta) {
        return cuentas.get(numeroCuenta); // Retorna la cuenta asociada a la clave
    }

    /**
     * Realiza una transacción entre dos cuentas de manera sincronizada.
     * 
     * @param tipo                Tipo de transacción (por ejemplo,
     *                            "Transferencia").
     * @param numeroCuentaOrigen  Número de cuenta de origen.
     * @param numeroCuentaDestino Número de cuenta de destino.
     * @param monto               Monto a transferir.
     * @return true si la transacción se realizó exitosamente, false en caso
     *         contrario.
     */
    public synchronized boolean realizarTransaccion(String tipo, String numeroCuentaOrigen,
            String numeroCuentaDestino, double monto) {
        // Obtiene las cuentas de origen y destino desde el mapa
        Cuenta cuentaOrigen = cuentas.get(numeroCuentaOrigen);
        Cuenta cuentaDestino = cuentas.get(numeroCuentaDestino);

        // Verifica si ambas cuentas existen
        if (cuentaOrigen == null || cuentaDestino == null)
            return false;

        // Verifica el tipo de transacción
        if (tipo.equals("Transferencia")) {
            // Verifica si hay suficiente saldo en la cuenta de origen
            if (cuentaOrigen.getMonto() >= monto) {
                // Deduce el monto de la cuenta de origen
                cuentaOrigen.setMonto(cuentaOrigen.getMonto() - monto);
                // Agrega el monto a la cuenta de destino
                cuentaDestino.setMonto(cuentaDestino.getMonto() + monto);
                return true; // La transacción se realizó exitosamente
            }
        }
        return false; // La transacción no se pudo realizar
    }
}
