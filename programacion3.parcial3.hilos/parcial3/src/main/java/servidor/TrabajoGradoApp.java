package servidor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrabajoGradoApp extends Application {
    private Cliente cliente = new Cliente();
    private ListView<String> trabajosListView = new ListView<>();
    private ListView<String> autoresListView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        cargarTrabajos();

        trabajosListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                int trabajoId = Integer.parseInt(newVal.split(":")[0]);
                cargarAutores(trabajoId);
            }
        });

        VBox root = new VBox(trabajosListView, autoresListView);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    private void cargarTrabajos() {
        cliente.obtenerTrabajos()
                .forEach(trabajo -> trabajosListView.getItems().add(trabajo.getId() + ": " + trabajo.getTitulo()));
    }

    private void cargarAutores(int trabajoId) {
        autoresListView.getItems().clear();
        cliente.obtenerAutores(trabajoId)
                .forEach(autor -> autoresListView.getItems().add(autor.getNombre() + " " + autor.getApellidos()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
