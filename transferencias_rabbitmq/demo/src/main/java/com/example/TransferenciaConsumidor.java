package com.example;

import com.rabbitmq.client.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * Clase que implementa un consumidor para procesar transferencias de una cola
 * de RabbitMQ.
 * Utiliza un `CuentaManager` para realizar las transacciones y registra un
 * historial.
 */
public class TransferenciaConsumidor implements Runnable {
    // Nombre de la cola desde la cual se recibirán las transferencias
    private static final String QUEUE_NAME = "transferencias_queue";
    // Archivo donde se registra el historial de transferencias procesadas
    private static final String HISTORIAL_FILE = "demo\\historial_transferencias.txt";
    // Referencia al administrador de cuentas para realizar operaciones
    private CuentaManager cuentaManager;

    // Constructor que inicializa el consumidor con una instancia de CuentaManager
    public TransferenciaConsumidor(CuentaManager cuentaManager) {
        this.cuentaManager = cuentaManager;
    }

    /**
     * Método principal que se ejecuta cuando el hilo inicia.
     * Configura la conexión con RabbitMQ y empieza a escuchar la cola.
     */
    @Override
    public void run() {
        try {
            // Configura la conexión con el servidor RabbitMQ
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost"); // Se conecta al servidor local

            // Establece la conexión y el canal para comunicarse con RabbitMQ
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            // Declara la cola de RabbitMQ. Debe coincidir con la del productor
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            System.out.println("Consumidor iniciado y esperando transferencias...");

            // Callback para procesar mensajes cuando se reciben
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                // Convierte el mensaje recibido de bytes a cadena de texto
                String mensaje = new String(delivery.getBody(), StandardCharsets.UTF_8);
                procesarTransferencia(mensaje); // Procesa la transferencia
                System.out.println("Transferencia recibida: " + mensaje);
            };

            // Inicia el consumo de mensajes de la cola. AutoACK está habilitado.
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            // Manejo de errores en la configuración del consumidor
            System.err.println("Error en el consumidor: " + e.getMessage());
        }
    }

    /**
     * Procesa un mensaje recibido desde la cola, que representa una transferencia.
     * 
     * @param mensaje Formato esperado:
     *                TipoTransaccion@@CuentaOrigen@@CuentaDestino@@Monto
     *                sin este formato no funcionaa
     */
    private synchronized void procesarTransferencia(String mensaje) {
        // Divide el mensaje en partes según el separador "@@"
        String[] partes = mensaje.split("@@");
        String tipo = partes[0]; // Tipo de transacción (e.g., "Transferencia")
        String cuentaOrigen = partes[1]; // Número de cuenta de origen
        String cuentaDestino = partes[2]; // Número de cuenta de destino
        double monto = Double.parseDouble(partes[3]); // Monto a transferir

        // Realiza la transacción utilizando el CuentaManager
        boolean exito = cuentaManager.realizarTransaccion(tipo, cuentaOrigen, cuentaDestino, monto);

        if (exito) {
            // Si la transacción es exitosa, registra el historial
            System.out.println("Transferencia procesada correctamente.");
            registrarHistorial(tipo, cuentaOrigen, cuentaDestino, monto);
            try {
                // Guarda el estado actualizado de las cuentas
                cuentaManager.guardarCuentas();
            } catch (Exception e) {
                System.err.println("Error al guardar cuentas: " + e.getMessage());
            }
        } else {
            // Si falla, muestra un mensaje de error
            System.err.println("Transferencia fallida. Saldo insuficiente o cuentas no válidas.");
        }
    }

    /**
     * Registra la transferencia en el archivo de historial.
     * 
     * @param tipo          Tipo de transacción (e.g., "Transferencia").
     * @param cuentaOrigen  Número de cuenta de origen.
     * @param cuentaDestino Número de cuenta de destino.
     * @param monto         Monto transferido.
     */
    private void registrarHistorial(String tipo, String cuentaOrigen, String cuentaDestino, double monto) {
        // Construye una línea de texto para registrar en el historial
        String registro = tipo + "@@" + LocalDateTime.now() + "@@" + monto + "@@" +
                cuentaOrigen + "@@" + cuentaDestino + "\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORIAL_FILE, true))) {
            // Escribe el registro en el archivo, en modo de anexar al final
            writer.write(registro);
        } catch (IOException e) {
            // Manejo de errores al escribir en el archivo
            System.err.println("Error al registrar historial: " + e.getMessage());
        }
    }
}
