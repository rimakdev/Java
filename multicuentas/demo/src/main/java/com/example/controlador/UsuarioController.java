package com.example.controlador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.modelo.Usuario;

public class UsuarioController {
    private static final String ARCHIVO_USUARIOS = "demo\\usuarios.txt";

    public List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        File archivo = new File(ARCHIVO_USUARIOS);

        if (!archivo.exists()) {
            System.out.println("El archivo de usuarios no existe.");
            return usuarios;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("@@");
                if (partes.length == 7) {
                    usuarios.add(new Usuario(
                            partes[0], // id
                            partes[1], // email
                            partes[2], // password
                            partes[3], // telefono
                            partes[4], // nombre
                            partes[5], // cedula
                            partes[6] // direccion
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }

        return usuarios;
    }

    public void guardarUsuario(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS, true))) {
            writer.write(usuario.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
        }
    }
}
