package Util;

import Conceptos.Servicio;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Escribe objetos Servicio serializados en Data/SERVICIOS.DAT.
 *
 * @author marcoperezr
 */
public class ServicioOutput {

    FileOutputStream archivo;
    ObjectOutputStream salida;

    public void abrir() throws IOException {
        // asegurar que la carpeta Data exista
        new File("Data").mkdirs();
        archivo = new FileOutputStream("Data/SERVICIOS.DAT");
        salida = new ObjectOutputStream(archivo);
    }

    public void cerrar() throws IOException {
        if (salida != null) {
            salida.close();
        }
    }

    public void escribir(Servicio servicio) throws IOException {
        if (salida != null) {
            salida.writeObject(servicio);
        }
    }
}
