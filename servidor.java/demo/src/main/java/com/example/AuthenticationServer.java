package com.example;

import java.io.*;
import java.net.*;

public class AuthenticationServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor de Autenticación Iniciado...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // Leer credenciales del cliente
                    String username = in.readLine();
                    String password = in.readLine();

                    // Validar credenciales (ejemplo simple)
                    if (isValidUser(username, password)) {
                        out.println("OK");
                    } else {
                        out.println("ERROR");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidUser(String username, String password) {
        // Validación simple; en producción, conectarse a una base de datos
            return username.equals("usuario@quindio.edu.co") && password.equals("contrasenaSegura");
    }
}
