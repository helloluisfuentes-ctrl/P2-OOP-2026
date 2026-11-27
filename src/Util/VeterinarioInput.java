package Util;

import Conceptos.Veterinario;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Lee objetos Veterinario serializados desde Data/VETERINARIOS.DAT.
 *
 * @author marcoperezr
 */
public class VeterinarioInput {

    FileInputStream archivo;
    ObjectInputStream entrada;

    public void abrir() throws IOException {
        File f = new File("Data/VETERINARIOS.DAT");
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

    public Veterinario leer() throws IOException, ClassNotFoundException {
        Veterinario veterinario = null;

        if (entrada != null) {
            try {
                veterinario = (Veterinario) entrada.readObject();
            } catch (EOFException e) {
                // fin del archivo
            }
        }
        return veterinario;
    }
}
