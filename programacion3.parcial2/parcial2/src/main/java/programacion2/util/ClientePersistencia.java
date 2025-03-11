package programacion2.util;

import programacion2.model.Cliente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ClientePersistencia {

    public static void guardarCliente(Cliente cliente, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(cliente.formatearCliente());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
