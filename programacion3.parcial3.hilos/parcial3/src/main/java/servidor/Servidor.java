package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            ArchivoUtil service = new ArchivoUtil();
            System.out.println("Servidor en ejecución...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {

                    String command = (String) input.readObject();
                    if (command.equals("obtenerTrabajos")) {
                        output.writeObject(service.obtenerTrabajosGrado());
                    } else if (command.startsWith("obtenerAutores")) {
                        int trabajoId = Integer.parseInt(command.split(":")[1]);
                        output.writeObject(service.obtenerAutoresPorTrabajo(trabajoId));
                    }
                    output.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
