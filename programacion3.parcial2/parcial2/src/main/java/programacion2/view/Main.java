package programacion2.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import programacion2.model.Paquete;

import programacion2.controllers.EnvioManager;

public class Main extends Application {
    private List<Paquete> listaPaquetes = new ArrayList<>();
    private EnvioManager envioManager = new EnvioManager();

    @Override
    public void start(Stage primaryStage) {
        // Crear los controles para los datos del cliente
        TextField txtNumeroIdentificacion = new TextField();
        txtNumeroIdentificacion.setPromptText("Número de identificación");

        TextField txtTipoIdentificacion = new TextField();
        txtTipoIdentificacion.setPromptText("Tipo de identificación (CC, TI, etc.)");

        TextField txtNombres = new TextField();
        txtNombres.setPromptText("Nombres");

        TextField txtApellidos = new TextField();
        txtApellidos.setPromptText("Apellidos");

        TextField txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono");

        TextField txtTotal = new TextField();
        txtTotal.setPromptText("Total");

        ComboBox<String> cmbZona = new ComboBox<>();
        cmbZona.getItems().addAll("rural", "urbano");
        cmbZona.setPromptText("Seleccione zona");

        TextField txtCodigoPaquete = new TextField();
        txtCodigoPaquete.setPromptText("Código del paquete");

        TextField txtPesoPaquete = new TextField();
        txtPesoPaquete.setPromptText("Peso del paquete");

        Button btnAgregarPaquete = new Button("Agregar Paquete");
        Button btnGuardar = new Button("Guardar");

        ListView<String> listViewPaquetes = new ListView<>();

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        HBox paqueteBox = new HBox(10, txtCodigoPaquete, txtPesoPaquete, btnAgregarPaquete);
        root.getChildren().addAll(new Label("Número de identificación:"), txtNumeroIdentificacion,
                new Label("Tipo de identificación:"), txtTipoIdentificacion,
                new Label("Nombres:"), txtNombres,
                new Label("Apellidos:"), txtApellidos,
                new Label("Teléfono:"), txtTelefono,
                new Label("Total:"), txtTotal,
                new Label("Zona:"), cmbZona,
                new Label("Agregar Paquete:"), paqueteBox,
                listViewPaquetes, btnGuardar);

        // Acciones
        btnAgregarPaquete.setOnAction(e -> {
            String codigo = txtCodigoPaquete.getText();
            double peso = Double.parseDouble(txtPesoPaquete.getText());

            Paquete paquete = new Paquete(codigo, peso);
            listaPaquetes.add(paquete);

            listViewPaquetes.getItems().add("Código: " + codigo + ", Peso: " + peso);
            txtCodigoPaquete.clear();
            txtPesoPaquete.clear();
        });

        btnGuardar.setOnAction(e -> {
            guardarEnvio(txtNumeroIdentificacion.getText(), txtTipoIdentificacion.getText(), txtNombres.getText(),
                    txtApellidos.getText(), txtTelefono.getText(), txtNombres.getText() + " " + txtApellidos.getText(),
                    Double.parseDouble(txtTotal.getText()), cmbZona.getValue(), listaPaquetes);
            listViewPaquetes.getItems().clear();
            listaPaquetes.clear();
        });

        // Mostrar la ventana
        Scene scene = new Scene(root, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de Envíos");
        primaryStage.show();
    }

    private void guardarEnvio(String numeroIdentificacion, String tipoIdentificacion, String nombres,
            String apellidos, String telefono, String cliente, double total,
            String zona, List<Paquete> listaPaquetes) {
        // Llamada al método actualizado de EnvioManager
        envioManager.guardarEnvio(numeroIdentificacion, tipoIdentificacion, nombres, apellidos, telefono,
                cliente, total, zona, listaPaquetes);

        // Mostrar alerta de éxito
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardado");
        alert.setHeaderText(null);
        alert.setContentText("Envío y cliente guardados correctamente.");
        alert.showAndWait();

        // Limpiar la lista de paquetes después de guardar
        listaPaquetes.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
