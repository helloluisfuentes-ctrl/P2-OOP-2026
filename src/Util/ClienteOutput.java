package Util;

import Conceptos.Cliente;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Escribe objetos Cliente serializados en Data/CLIENTES.DAT.
 *
 * @author marcoperezr
 */
public class ClienteOutput {

    FileOutputStream archivo;
    ObjectOutputStream salida;

    public void abrir() throws IOException {
        // asegurar que la carpeta Data exista
        new File("Data").mkdirs();
        archivo = new FileOutputStream("Data/CLIENTES.DAT");
        salida = new ObjectOutputStream(archivo);
    }

    public void cerrar() throws IOException {
        if (salida != null) {
            salida.close();
        }
    }

    public void escribir(Cliente cliente) throws IOException {
        if (salida != null) {
            salida.writeObject(cliente);
        }
    }
}
