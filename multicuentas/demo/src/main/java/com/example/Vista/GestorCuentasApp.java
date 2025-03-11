package com.example.Vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;

import com.example.controlador.CuentaController;
import com.example.controlador.UsuarioController;
import com.example.modelo.Cuenta;
import com.example.modelo.Usuario;
import com.example.*;

import javafx.scene.layout.VBox;

import javafx.util.StringConverter;

public class GestorCuentasApp extends Application {
    // Declaración de los elementos de la interfaz
    private ComboBox<Usuario> comboBoxUsuarios; // ComboBox para seleccionar un usuario
    private TextField campoBanco; // Campo de texto para ingresar el nombre del banco
    private Button botonRegistrar; // Botón para registrar una nueva cuenta
    private Button botonConsultar; // Botón para consultar las cuentas asociadas
    private UsuarioController usuarioController; // Controlador para manejar los usuarios
    private CuentaController cuentaController; // Controlador para manejar las cuentas
    private ListView<String> listViewCuentas; // Lista para mostrar las cuentas asociadas al usuario seleccionado

    @Override
    public void start(Stage primaryStage) {
        // Inicializar los controladores
        usuarioController = new UsuarioController();
        cuentaController = new CuentaController();

        // Inicializar los componentes de la interfaz
        comboBoxUsuarios = new ComboBox<>(); // Crear el ComboBox de usuarios
        campoBanco = new TextField(); // Crear el campo de texto para ingresar el banco
        campoBanco.setPromptText("Nombre del banco"); // Establecer el texto de ayuda en el campo de texto

        botonRegistrar = new Button("Registrar Cuenta"); // Crear el botón de registrar cuenta
        botonConsultar = new Button("Consultar Cuentas"); // Crear el botón de consultar cuentas

        listViewCuentas = new ListView<>(); // Inicializar el ListView para mostrar las cuentas

        // Configurar las acciones de los botones
        configurarAccionesBotones();

        // Cargar los usuarios en el ComboBox
        cargarUsuariosEnComboBox();

        // Personalizar cómo se muestra un usuario en el ComboBox
        comboBoxUsuarios.setConverter(new StringConverter<>() {
            // Método para convertir un objeto Usuario a un String que se mostrará en el
            // ComboBox
            @Override
            public String toString(Usuario usuario) {
                // Si el usuario es nulo, retornar una cadena vacía
                if (usuario == null) {
                    return "";
                }
                // Si el usuario no es nulo, concatenar su nombre y cédula
                return usuario.getNombre() + " - " + usuario.getCedula();
            }

            // Este método no se necesita en este caso, por lo que retornamos null
            @Override
            public Usuario fromString(String string) {
                return null;
            }
        });

        // Crear la interfaz gráfica (layout) con un VBox
        VBox root = new VBox(10); // Crear un VBox con un espacio de 10 píxeles entre elementos
        root.setPadding(new Insets(10)); // Establecer el relleno de la caja a 10 píxeles
        // Agregar los elementos al VBox
        root.getChildren().addAll(
                new Label("Seleccione un usuario:"), // Etiqueta para el ComboBox
                comboBoxUsuarios, // ComboBox de usuarios
                new Label("Ingrese el banco:"), // Etiqueta para el campo de texto del banco
                campoBanco, // Campo de texto para el banco
                botonRegistrar, // Botón para registrar cuenta
                botonConsultar, // Botón para consultar cuentas
                new Label("Cuentas asociadas:"), // Etiqueta para la lista de cuentas
                listViewCuentas // El ListView donde se mostrarán las cuentas
        );

        // Crear la escena y agregarla al escenario (ventana)
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene); // Establecer la escena en la ventana principal
        primaryStage.setTitle("Gestor de Cuentas"); // Título de la ventana
        primaryStage.show(); // Mostrar la ventana
    }

    // Configuración de las acciones de los botones
    private void configurarAccionesBotones() {
        // Acción para registrar una nueva cuenta
        botonRegistrar.setOnAction(e -> registrarCuenta());
        // Acción para consultar las cuentas asociadas
        botonConsultar.setOnAction(e -> consultarCuentas());
    }

    // Método para cargar los usuarios desde el controlador y agregar al ComboBox
    private void cargarUsuariosEnComboBox() {
        // Obtener la lista de usuarios del controlador
        List<Usuario> usuarios = usuarioController.cargarUsuarios();

        // Si no se encontraron usuarios, mostrar una alerta
        if (usuarios.isEmpty()) {
            mostrarAlerta("Error", "No se han encontrado usuarios.");
        }

        // Limpiar el ComboBox antes de cargar nuevos usuarios
        comboBoxUsuarios.getItems().clear();
        // Agregar todos los usuarios al ComboBox
        comboBoxUsuarios.getItems().addAll(usuarios);
    }

    // Método para registrar una nueva cuenta
    private void registrarCuenta() {
        // Obtener el usuario seleccionado en el ComboBox
        Usuario usuarioSeleccionado = comboBoxUsuarios.getValue();

        // Validar si se ha seleccionado un usuario y si el campo del banco está vacío
        if (usuarioSeleccionado == null || campoBanco.getText().isEmpty()) {
            mostrarAlerta("Error", "Debe seleccionar un usuario y llenar el campo del banco.");
            return;
        }

        // Crear una nueva cuenta con un ID, nombre de banco y número de cuenta
        // generados
        Cuenta nuevaCuenta = new Cuenta(
                cuentaController.generarIdCuenta(), // Generar un ID de cuenta
                campoBanco.getText(), // Nombre del banco
                cuentaController.generarNumeroCuenta(), // Generar un número de cuenta aleatorio
                TipoCuenta.AHORROS// falta agregar el tipo de cuentaaaa que no se como y va aca
                , usuarioSeleccionado.getCedula() // Cédula del usuario seleccionado
        );

        // Guardar la cuenta utilizando el controlador de cuentas
        cuentaController.agregarCuenta(nuevaCuenta);
        ;

        // Mostrar un mensaje de éxito con el número de cuenta generado
        mostrarAlerta("Éxito", "Cuenta registrada exitosamente.\nNúmero de cuenta: " + nuevaCuenta.getNroCuenta());

        // Limpiar los campos de la interfaz para una nueva operación
        limpiarCampos();
    }

    // Método para consultar las cuentas asociadas al usuario seleccionado
    private void consultarCuentas() {
        // Obtener el usuario seleccionado en el ComboBox
        Usuario usuarioSeleccionado = comboBoxUsuarios.getValue();

        // Verificar si se ha seleccionado un usuario
        if (usuarioSeleccionado == null) {
            mostrarAlerta("Error", "Debe seleccionar un usuario.");
            return;
        }

        // Consultar las cuentas asociadas al usuario
        List<Cuenta> cuentas = cuentaController.obtenerCuentasPorUsuario(usuarioSeleccionado.getCedula());
        // Si el usuario no tiene cuentas, mostrar una alerta informativa
        if (cuentas.isEmpty()) {
            mostrarAlerta("Información", "El usuario no tiene cuentas asociadas.");
        } else {
            // Limpiar el ListView antes de agregar las nuevas cuentas
            listViewCuentas.getItems().clear();

            // Agregar cada cuenta al ListView en formato legible
            for (Cuenta cuenta : cuentas) {
                listViewCuentas.getItems().add(
                        "Banco: " + cuenta.getNombreBanco() + " | Número: " + cuenta.getNroCuenta());
            }
        }
    }

    // Método para mostrar una alerta con título y mensaje
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo); // Establecer el título de la alerta
        alert.setHeaderText(null); // No mostrar un encabezado
        alert.setContentText(mensaje); // Establecer el contenido del mensaje
        alert.showAndWait(); // Mostrar la alerta y esperar a que el usuario la cierre
    }

    // Método para limpiar los campos de entrada
    private void limpiarCampos() {
        campoBanco.clear(); // Limpiar el campo del nombre del banco
        comboBoxUsuarios.getSelectionModel().clearSelection(); // Limpiar la selección del ComboBox
    }

    // Método principal para lanzar la aplicación
    public static void main(String[] args) {
        launch(args);
    }
}
