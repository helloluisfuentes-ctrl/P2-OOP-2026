package Util;

import Conceptos.Servicio;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Lee objetos Servicio serializados desde Data/SERVICIOS.DAT.
 *
 * @author marcoperezr
 */
public class ServicioInput {

    FileInputStream archivo;
    ObjectInputStream entrada;

    public void abrir() throws IOException {
        File f = new File("Data/SERVICIOS.DAT");
        // si el archivo no existe o está vacío, dejar el stream en null
        if (!f.exists() || f.length() == 0) {
            archivo = null;
            entrada = null;
            return;
        }
        archivo = new FileInputStream(f);
        entrada = new ObjectInputStream(archivo);
    }

    public void cerrar() throws IOException {
        if (entrada != null) {
            entrada.close();
        }
    }

    public Servicio leer() throws IOException, ClassNotFoundException {
        Servicio servicio = null;

        if (entrada != null) {
            try {
                servicio = (Servicio) entrada.readObject();
            } catch (EOFException e) {
                // fin del archivo
            }
        }
        return servicio;
    }
}
