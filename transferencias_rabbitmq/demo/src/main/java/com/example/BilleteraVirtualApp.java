package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BilleteraVirtualApp extends Application {
    // Manager para manejar las cuentas bancarias
    private CuentaManager cuentaManager;

    @Override
    public void start(Stage stage) throws IOException {
        // Inicializa el gestor de cuentas leyendo los datos desde el archivo de cuentas
        cuentaManager = new CuentaManager();

        // Crea e inicia un hilo demonio que consume mensajes de transferencias de
        // RabbitMQ
        Thread consumidorThread = new Thread(new TransferenciaConsumidor(cuentaManager));
        consumidorThread.setDaemon(true); // Hilo demonio para que se cierre automáticamente al cerrar la app
        consumidorThread.start();

        // Contenedor vertical con un espaciado de 10 píxeles entre sus elementos
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;"); // Agrega un padding de 20 píxeles alrededor del contenedor

        // Elementos de la interfaz gráfica
        Label labelTitulo = new Label("Billetera Virtual"); // Título principal
        Label labelCuentas = new Label("Cuentas:"); // Etiqueta para la lista de cuentas
        TextArea areaCuentas = new TextArea(); // Área de texto que muestra las cuentas disponibles
        areaCuentas.setEditable(false); // No permite editar el contenido del área de texto
        actualizarCuentas(areaCuentas); // Carga y muestra las cuentas en el área de texto

        // Campos de texto para ingresar la cuenta origen, cuenta destino y monto
        TextField campoOrigen = new TextField();
        campoOrigen.setPromptText("Cuenta Origen"); // Texto de ayuda que aparece cuando el campo está vacío

        TextField campoDestino = new TextField();
        campoDestino.setPromptText("Cuenta Destino");

        TextField campoMonto = new TextField();
        campoMonto.setPromptText("Monto");

        // Botón para enviar la transferencia
        Button btnEnviarTransferencia = new Button("Enviar Transferencia");
        Label labelResultado = new Label(); // Etiqueta para mostrar resultados o mensajes de error

        // Acción al presionar el botón de transferencia
        btnEnviarTransferencia.setOnAction(e -> {
            // Obtiene los valores ingresados en los campos de texto
            String origen = campoOrigen.getText();
            String destino = campoDestino.getText();
            String montoTexto = campoMonto.getText();

            // Validación: todos los campos deben estar llenos
            if (origen.isEmpty() || destino.isEmpty() || montoTexto.isEmpty()) {
                labelResultado.setText("Por favor, llena todos los campos.");
                return; // Detiene la ejecución del evento si hay campos vacíos
            }

            try {
                // Convierte el monto a un valor numérico
                double monto = Double.parseDouble(montoTexto);

                // Validación: el monto debe ser mayor a cero
                if (monto <= 0) {
                    labelResultado.setText("El monto debe ser positivo.");
                    return; // Detiene la ejecución si el monto es inválido
                }

                // Crea el mensaje en el formato esperado por RabbitMQ
                String mensaje = "Transferencia@@" + origen + "@@" + destino + "@@" + monto;

                // Envía el mensaje de transferencia al productor de RabbitMQ
                TransferenciaProductor.enviarTransferencia(mensaje);

                // Muestra un mensaje de éxito al usuario
                labelResultado.setText("Transferencia enviada a la cola.");
            } catch (NumberFormatException ex) {
                // Maneja errores de conversión del monto (si no es un número válido)
                labelResultado.setText("El monto debe ser un número válido.");
            } catch (Exception ex) {
                // Maneja otros errores al enviar la transferencia
                labelResultado.setText("Error al enviar transferencia: " + ex.getMessage());
            }
        });

        // Agrega todos los elementos a la interfaz gráfica
        root.getChildren().addAll(labelTitulo, labelCuentas, areaCuentas, campoOrigen, campoDestino, campoMonto,
                btnEnviarTransferencia, labelResultado);

        // Crea y configura la escena principal de la aplicación
        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene); // Establece la escena en la ventana principal
        stage.setTitle("Billetera Virtual"); // Establece el título de la ventana
        stage.show(); // Muestra la ventana al usuario
    }

    // Actualiza el área de texto con la lista de cuentas y sus saldos
    private void actualizarCuentas(TextArea areaCuentas) {
        StringBuilder builder = new StringBuilder(); // Construye el texto a mostrar
        for (Cuenta cuenta : cuentaManager.getCuentas().values()) {
            // Agrega información de cada cuenta en una nueva línea
            builder.append(cuenta.getNroCuenta() + " - ").append(cuenta.getNombreBanco() + " - ")
                    .append("Saldo Total: ")
                    .append(cuenta.getMonto()).append("\n");
        }
        areaCuentas.setText(builder.toString()); // Establece el texto en el área de texto
    }

    // Método principal que lanza la aplicación JavaFX
    public static void main(String[] args) {
        launch(); // Llama al método start para iniciar la app
    }
}
