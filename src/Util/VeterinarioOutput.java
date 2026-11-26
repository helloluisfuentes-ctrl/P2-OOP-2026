package Util;

import Conceptos.Veterinario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Escribe objetos Veterinario serializados en Data/VETERINARIOS.DAT.
 *
 * @author marcoperezr
 */
public class VeterinarioOutput {

    FileOutputStream archivo;
    ObjectOutputStream salida;

    public void abrir() throws IOException {
        // asegurar que la carpeta Data exista
        new File("Data").mkdirs();
        archivo = new FileOutputStream("Data/VETERINARIOS.DAT");
        salida = new ObjectOutputStream(archivo);
    }

    public void cerrar() throws IOException {
        if (salida != null) {
            salida.close();
        }
    }

    public void escribir(Veterinario veterinario) throws IOException {
        if (salida != null) {
            salida.writeObject(veterinario);
        }
    }
}
