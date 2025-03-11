package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class AuthenticationClientFX extends Application {

    private TextField usernameField;
    private PasswordField passwordField;
    private Label statusLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Autenticación");

        // Crear campos y etiquetas
        Label usernameLabel = new Label("Nombre de usuario:");
        usernameField = new TextField();

        Label passwordLabel = new Label("Contraseña:");
        passwordField = new PasswordField();

        Button loginButton = new Button("Iniciar sesión");
        loginButton.setOnAction(e -> authenticate());

        Button registerButton = new Button("registrarse");

        statusLabel = new Label();

        // Configurar diseño
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);

        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);

        grid.add(loginButton, 0, 2);
        grid.add(statusLabel, 0, 5);

        grid.add(registerButton, 1, 2);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void authenticate() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try (Socket socket = new Socket("localhost", 5000);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Enviar credenciales al servidor
            out.println(username);
            out.println(password);

            // Leer respuesta del servidor
            String response = in.readLine();
            if ("OK".equals(response)) {
                statusLabel.setText("OK");
            } else {
                statusLabel.setText("ERROR");
            }

        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Error de conexión con el servidor");
        }
    }
}
