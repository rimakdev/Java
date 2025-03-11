package servidor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtil {
    private List<TrabajoGrado> trabajosGrado;
    private List<Autor> autores;

    public ArchivoUtil() {
        trabajosGrado = new ArrayList<>();
        autores = new ArrayList<>();
        cargarTrabajosGrado();
        cargarAutores();
    }

    private void cargarTrabajosGrado() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src\\main\\java\\servidor\\resources\\trabajogrados.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] data = line.split("@");
                    if (data.length >= 4) {
                        int id = Integer.parseInt(data[0].trim());
                        String fecha = data[1].trim();
                        String titulo = data[2].trim();
                        String descripcion = data[3].trim();

                        // Creamos el trabajo de grado y lo añadimos a la lista
                        TrabajoGrado trabajo = new TrabajoGrado(id, fecha, titulo, descripcion, new ArrayList<>());
                        trabajosGrado.add(trabajo);
                    } else {
                        System.out.println("Línea malformateada en trabajogrados.txt: " + line);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void cargarAutores() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src\\main\\java\\servidor\\resources\\autores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] data = line.split("@");

                    if (data.length == 7) { // 7 campos, siendo el último el ID del trabajo
                        int id = Integer.parseInt(data[0].trim());
                        String nombre = data[1].trim();
                        String apellido = data[2].trim();
                        String cedula = data[3].trim();
                        String programa = data[4].trim();
                        String titulo = data[5].trim();
                        int trabajoId = Integer.parseInt(data[6].trim());

                        Autor autor = new Autor(id, nombre, apellido, cedula, programa, titulo);

                        // Asociar el autor al trabajo de grado correspondiente
                        for (TrabajoGrado trabajo : trabajosGrado) {
                            if (trabajo.getId() == trabajoId) { // Buscar el trabajo con ID correspondiente
                                trabajo.getAutores().add(autor); // Añadir el autor al trabajo
                                break;
                            }
                        }
                    } else {
                        System.out.println("Línea malformateada en autores.txt: " + line);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public List<TrabajoGrado> obtenerTrabajosGrado() {
        return trabajosGrado;
    }

    public List<Autor> obtenerAutoresPorTrabajo(int trabajoId) {
        return trabajosGrado.stream()
                .filter(t -> t.getId() == trabajoId)
                .findFirst()
                .map(TrabajoGrado::getAutores)
                .orElse(new ArrayList<>());
    }
}
