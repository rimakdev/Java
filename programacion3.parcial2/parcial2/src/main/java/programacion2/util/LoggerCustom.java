package programacion2.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class LoggerCustom {
    public static void guardarRegistroLog(String mensajeLog, int nivel, String accion, String rutaArchivo) {
        java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(accion);
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler(rutaArchivo, true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);

            switch (nivel) {
                case 1:
                    LOGGER.log(Level.INFO, accion + "," + mensajeLog);
                    break;

                case 2:
                    LOGGER.log(Level.WARNING, accion + "," + mensajeLog);
                    break;

                case 3:
                    LOGGER.log(Level.SEVERE, accion + "," + mensajeLog);
                    break;

                default:
                    break;
            }

        } catch (SecurityException | IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            if (fileHandler != null) {
                fileHandler.close();
            }
        }
    }
}
