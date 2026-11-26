package Util;

import Conceptos.Cita;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Escribe objetos Cita serializados en Data/CITAS.DAT.
 *
 * @author marcoperezr
 */
public class CitaOutput {

    FileOutputStream archivo;
    ObjectOutputStream salida;

    public void abrir() throws IOException {
        // asegurar que la carpeta Data exista
        new File("Data").mkdirs();
        archivo = new FileOutputStream("Data/CITAS.DAT");
        salida = new ObjectOutputStream(archivo);
    }

    public void cerrar() throws IOException {
        if (salida != null) {
            salida.close();
        }
    }

    public void escribir(Cita cita) throws IOException {
        if (salida != null) {
            salida.writeObject(cita);
        }
    }
}
