package programacion2.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import programacion2.model.Envio;
import programacion2.model.Paquete;

import programacion2.util.PersistenciaEnvio;
import programacion2.util.*;

public class EnvioManager {

    public void guardarEnvio(String numeroIdentificacion, String tipoIdentificacion, String nombres,
            String apellidos, String telefono, String cliente, double total,
            String zona, List<Paquete> listaPaquetes) {
        // Crear el envío con un código aleatorio
        Envio envio = new Envio(UUID.randomUUID().toString(), new Date(), zona, total, cliente, listaPaquetes);

        // Guardar el envío en archivos binario y XML
        PersistenciaEnvio.guardarEnvioBinario(envio,
                "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\Persistencia\\envio.dat");
        PersistenciaEnvio.guardarEnvioXML(envio,
                "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\Persistencia\\envio.xml");

        // Guardar la información del cliente y el código del envío en un archivo .txt
        guardarClienteYEnvio(numeroIdentificacion, tipoIdentificacion, nombres, apellidos, telefono, zona,
                envio.getCodigo());
    }

    public void guardarClienteYEnvio(String numeroIdentificacion, String tipoIdentificacion, String nombres,
            String apellidos, String telefono, String zona, String codigoEnvio) {
        // Leer el archivo existente para verificar si el cliente ya tiene envíos
        StringBuilder datosCliente = new StringBuilder();
        String line;
        boolean clienteEncontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\Persistencia\\clientes.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split("@");
                if (datos[0].equals(numeroIdentificacion) && datos[1].equals(tipoIdentificacion)) {
                    // Si el cliente ya existe, añadir el nuevo código de envío
                    datosCliente.append(line).append("%").append(codigoEnvio).append("\n");
                    clienteEncontrado = true;
                } else {
                    // Mantener la línea original si no es el cliente actual
                    datosCliente.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Si el cliente no existe, añadirlo con su primer envío
        if (!clienteEncontrado) {
            datosCliente.append(numeroIdentificacion).append("@")
                    .append(tipoIdentificacion).append("@")
                    .append(nombres).append("@")
                    .append(apellidos).append("@")
                    .append(telefono).append("@")
                    .append(zona).append("@")
                    .append(codigoEnvio).append("\n");
        }

        // Guardar todos los datos de nuevo en el archivo
        try (FileWriter writer = new FileWriter(
                "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\Persistencia\\clientes.txt", false)) {
            writer.write(datosCliente.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
