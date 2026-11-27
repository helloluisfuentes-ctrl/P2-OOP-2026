package Util;

import Conceptos.Cita;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Lee objetos Cita serializados desde Data/CITAS.DAT.
 *
 * @author marcoperezr
 */
public class CitaInput {

    FileInputStream archivo;
    ObjectInputStream entrada;

    public void abrir() throws IOException {
        File f = new File("Data/CITAS.DAT");
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

    public Cita leer() throws IOException, ClassNotFoundException {
        Cita cita = null;

        if (entrada != null) {
            try {
                cita = (Cita) entrada.readObject();
            } catch (EOFException e) {
                // fin del archivo
            }
        }
        return cita;
    }
}
