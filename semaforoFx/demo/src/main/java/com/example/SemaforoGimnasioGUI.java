package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SemaforoGimnasioGUI extends Application {
    private static final int CAPACIDAD_GIMNASIO = 3;
    private Gimnasio gimnasio = new Gimnasio(CAPACIDAD_GIMNASIO);
    private ObservableList<EstadoPersona> personas = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        // Configurar la tabla para mostrar el estado de cada persona
        TableView<EstadoPersona> table = new TableView<>(personas);
        TableColumn<EstadoPersona, String> colNombre = new TableColumn<>("Persona");
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());

        TableColumn<EstadoPersona, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(cellData -> cellData.getValue().estadoProperty());

        table.getColumns().addAll(colNombre, colEstado);

        // Crear objetos para cada persona en el gimnasio
        for (int i = 0; i < 6; i++) {
            String nombrePersona = "Persona " + (i + 1);
            EstadoPersona estadoPersona = new EstadoPersona(nombrePersona, "Fuera del gimnasio");
            personas.add(estadoPersona);

            Button btnEntrar = new Button("Intenta entrar " + nombrePersona);
            int index = i;

            // Configurar el botón para ejecutar el hilo individualmente
            btnEntrar.setOnAction(event -> {
                new Thread(new Persona(
                        nombrePersona, gimnasio,
                        () -> actualizarEstado(index, "Esperando su turno..."),
                        () -> actualizarEstado(index, "Dentro del gimnasio"),
                        () -> actualizarEstado(index, "Fuera del gimnasio"))).start();
            });

            root.getChildren().add(btnEntrar);
        }

        // Botón para que todos intenten entrar
        Button btnEntrarTodos = new Button("Entrar Todos");
        btnEntrarTodos.setOnAction(event -> {
            for (int i = 0; i < personas.size(); i++) {
                int index = i;
                String nombrePersona = personas.get(i).nombreProperty().get();

                // Ejecutar cada persona en un hilo separado
                new Thread(new Persona(
                        nombrePersona, gimnasio,
                        () -> actualizarEstado(index, "Esperando su turno..."),
                        () -> actualizarEstado(index, "Dentro del gimnasio"),
                        () -> actualizarEstado(index, "Fuera del gimnasio"))).start();
            }
        });

        root.getChildren().addAll(btnEntrarTodos, table);

        Scene scene = new Scene(root, 500, 600);
        primaryStage.setTitle("Simulación de Semáforo en Gimnasio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para actualizar el estado de una persona en la tabla
    private void actualizarEstado(int index, String estado) {
        personas.get(index).setEstado(estado);
    }
}
