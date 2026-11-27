package Util;

import Conceptos.Cita;
import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Gestiona las operaciones del menú Util: Exportar, Importar y Limpiar.
 *
 * @author marcoperezr
 */
public class GestorImportExport {

    // borra los XML viejos en Export/ si existen y escribe los 4 nuevos
    public static void exportarTodo(ArrayList<Cliente> clientes, ArrayList<Servicio> servicios, ArrayList<Veterinario> veterinarios, ArrayList<Cita> citas) {
        // asegurar que la carpeta Export exista
        new File("Export").mkdirs();

        File archivoClientes = new File("Export/clientes.xml");
        File archivoServicios = new File("Export/servicios.xml");
        File archivoVeterinarios = new File("Export/veterinarios.xml");
        File archivoCitas = new File("Export/citas.xml");

        // eliminar archivos XML anteriores si existen
        if (archivoClientes.exists()) {
            archivoClientes.delete();
        }
        if (archivoServicios.exists()) {
            archivoServicios.delete();
        }
        if (archivoVeterinarios.exists()) {
            archivoVeterinarios.delete();
        }
        if (archivoCitas.exists()) {
            archivoCitas.delete();
        }

        // escribir los 4 archivos XML nuevos
        GuardadorXML.guardarClientes(clientes != null ? clientes : new ArrayList<>(), archivoClientes);
        GuardadorXML.guardarServicios(servicios != null ? servicios : new ArrayList<>(), archivoServicios);
        GuardadorXML.guardarVeterinarios(veterinarios != null ? veterinarios : new ArrayList<>(), archivoVeterinarios);
        GuardadorXML.guardarCitas(citas != null ? citas : new ArrayList<>(), archivoCitas);
    }

    // limpia memoria, lee los 4 XML de Export/ y reescribe los 4 archivos .DAT
    public static void importarTodo(ArrayList<Cliente> clientes, ArrayList<Servicio> servicios, ArrayList<Veterinario> veterinarios, ArrayList<Cita> citas) {
        // limpiar las listas actuales sin perder las referencias
        if (clientes != null) {
            clientes.clear();
        }
        if (servicios != null) {
            servicios.clear();
        }
        if (veterinarios != null) {
            veterinarios.clear();
        }
        if (citas != null) {
            citas.clear();
        }

        File archivoClientes = new File("Export/clientes.xml");
        File archivoServicios = new File("Export/servicios.xml");
        File archivoVeterinarios = new File("Export/veterinarios.xml");
        File archivoCitas = new File("Export/citas.xml");

        // cargar primero clientes, servicios y veterinarios
        if (clientes != null && archivoClientes.exists()) {
            try (FileInputStream fis = new FileInputStream(archivoClientes)) {
                clientes.addAll(CargadorXML.cargarListaClientes(fis));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (servicios != null && archivoServicios.exists()) {
            try (FileInputStream fis = new FileInputStream(archivoServicios)) {
                servicios.addAll(CargadorXML.cargarListaServicios(fis));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (veterinarios != null && archivoVeterinarios.exists()) {
            try (FileInputStream fis = new FileInputStream(archivoVeterinarios)) {
                veterinarios.addAll(CargadorXML.cargarListaVeterinarios(fis));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // cargar citas de último para resolver cliente_id y veterinario_id
        if (citas != null && archivoCitas.exists()) {
            try (FileInputStream fis = new FileInputStream(archivoCitas)) {
                citas.addAll(CargadorXML.cargarListaCitas(fis, clientes, veterinarios));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // reescribir los 4 archivos .DAT en Data/
        GestorDAT.guardarClientes(clientes);
        GestorDAT.guardarServicios(servicios);
        GestorDAT.guardarVeterinarios(veterinarios);
        GestorDAT.guardarCitas(citas);
    }

    // vacía las 4 listas en memoria y vacía los 4 .DAT (sin tocar Export/)
    public static void limpiarTodo(ArrayList<Cliente> clientes, ArrayList<Servicio> servicios, ArrayList<Veterinario> veterinarios, ArrayList<Cita> citas) {
        if (clientes != null) {
            clientes.clear();
        }
        if (servicios != null) {
            servicios.clear();
        }
        if (veterinarios != null) {
            veterinarios.clear();
        }
        if (citas != null) {
            citas.clear();
        }

        GestorDAT.limpiarTodosDAT();
    }
}
