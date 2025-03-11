package programacion2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.io.InputStream;

public class Persistencia {

    // Ruta al archivo de propiedades
    private static final String PROPERTIES_PATH = "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\resources\\config.properties";

    public static String obtenerRutaProperties(String key) {
        Properties propiedades = new Properties();
        try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
            propiedades.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al cargar el archivo de propiedades: " + ex.getMessage());
        }

        // Comprobar si la propiedad existe
        String ruta = propiedades.getProperty(key);
        if (ruta == null) {
            throw new RuntimeException("La clave '" + key + "' no se encontró en el archivo de propiedades.");
        }

        return ruta;
    }
}
