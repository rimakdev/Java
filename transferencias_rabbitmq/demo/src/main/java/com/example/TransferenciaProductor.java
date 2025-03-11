package com.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

/**
 * Clase que actúa como productor en el sistema de RabbitMQ.
 * Su responsabilidad es enviar mensajes de transferencias a la cola
 * especificada.
 */
public class TransferenciaProductor {
    // Nombre de la cola donde se enviarán las transferencias
    private static final String QUEUE_NAME = "transferencias_queue";

    /**
     * Envía un mensaje de transferencia a la cola RabbitMQ.
     * 
     * @param mensaje El mensaje que contiene los detalles de la transferencia.
     *                Formato esperado:
     *                TipoTransaccion@@CuentaOrigen@@CuentaDestino@@Monto.
     * @throws Exception Si ocurre algún error en la conexión o el envío del
     *                   mensaje.
     */
    public static void enviarTransferencia(String mensaje) throws Exception {
        // Crea una instancia de ConnectionFactory para configurar la conexión con
        // RabbitMQ
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // Se conecta al servidor local de RabbitMQ

        // Intenta establecer una conexión y un canal de comunicación con RabbitMQ
        try (Connection connection = factory.newConnection(); // Conexión al servidor RabbitMQ
                Channel channel = connection.createChannel()) { // Canal para enviar mensajes

            // Declara la cola si no existe. Debe coincidir con la configuración del
            // consumidor
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            // Publica el mensaje en la cola
            channel.basicPublish(
                    "", // Exchange vacío (se usa el predeterminado)
                    QUEUE_NAME, // Nombre de la cola donde se enviará el mensaje
                    null, // Sin propiedades adicionales para el mensaje
                    mensaje.getBytes(StandardCharsets.UTF_8) // Convierte el mensaje a bytes
            );

            // Mensaje de confirmación en la consola
            System.out.println("Transferencia enviada: " + mensaje);
        }
        // El bloque try-with-resources cierra automáticamente la conexión y el canal
    }
}
