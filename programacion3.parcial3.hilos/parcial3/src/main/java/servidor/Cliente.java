package servidor;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Cliente {
    public List<TrabajoGrado> obtenerTrabajos() {
        try (Socket socket = new Socket("localhost", 8080);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("obtenerTrabajos");
            return (List<TrabajoGrado>) input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Autor> obtenerAutores(int trabajoId) {
        try (Socket socket = new Socket("localhost", 8080);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("obtenerAutores:" + trabajoId);
            return (List<Autor>) input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

