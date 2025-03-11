package programacion2.util;

import java.beans.XMLEncoder;
import java.io.*;

import programacion2.model.Envio;

public class PersistenciaEnvio {

    private final static String rutaLogs = Persistencia.obtenerRutaProperties("rutaArchivoLOG");

    public static void guardarEnvioBinario(Envio envio, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(envio);
            LoggerCustom.guardarRegistroLog("Envío guardado en binario", 1, "Guardar Binario",
                    "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\Persistencia\\envios.log");
        } catch (IOException e) {
            LoggerCustom.guardarRegistroLog(e.getMessage(), 3, "Error Guardar Binario",
                    "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\Persistencia\\envios.log");
        }
    }

    public static void guardarEnvioXML(Envio envio, String rutaArchivo) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(rutaArchivo)))) {
            encoder.writeObject(envio);
            LoggerCustom.guardarRegistroLog("Envío guardado en XML", 1, "Guardar XML",
                    "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\Persistencia\\envios.log");
        } catch (IOException e) {
            LoggerCustom.guardarRegistroLog(e.getMessage(), 3, "Error Guardar XML",
                    "C:\\Users\\JUAN ESTEBAN\\Desktop\\programacion3.parcial2\\Persistencia\\envios.log");
        }
    }
}
