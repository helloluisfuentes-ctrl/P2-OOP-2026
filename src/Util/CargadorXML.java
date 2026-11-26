package Util;

import Conceptos.Cita;
import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * Clase utilitaria para parsear y cargar información desde archivos XML con SAX.
 *
 * @author fuent
 */
public class CargadorXML {

    public static ArrayList<Veterinario> cargarListaVeterinarios(InputStream archivo) {
        ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();

        try {
            InputSource original = new InputSource(archivo);
            SAXHandlerVeterinario handler = new SAXHandlerVeterinario();

            // configuración del parser SAX
            SAXParserFactory categoria = SAXParserFactory.newInstance();
            SAXParser parser = categoria.newSAXParser();
            XMLReader lector = parser.getXMLReader();

            // asigna el manejador de eventos y parsea el archivo
            lector.setContentHandler(handler);
            lector.parse(original);

            listaVeterinarios = handler.getListaVeterinarios();
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        return listaVeterinarios;
    }

    public static ArrayList<Servicio> cargarListaServicios(InputStream archivo) {
        ArrayList<Servicio> listaServicios = new ArrayList<>();

        try {
            InputSource original = new InputSource(archivo);
            SAXHandlerServicio handler = new SAXHandlerServicio();

            // configuración del parser SAX
            SAXParserFactory categoria = SAXParserFactory.newInstance();
            SAXParser parser = categoria.newSAXParser();
            XMLReader lector = parser.getXMLReader();

            // asigna el manejador de eventos y parsea el archivo
            lector.setContentHandler(handler);
            lector.parse(original);

            listaServicios = handler.getListaServicios();
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        return listaServicios;
    }

    public static ArrayList<Cliente> cargarListaClientes(InputStream archivo) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {
            InputSource original = new InputSource(archivo);
            SAXHandlerCliente handler = new SAXHandlerCliente();

            // configuración del parser SAX
            SAXParserFactory categoria = SAXParserFactory.newInstance();
            SAXParser parser = categoria.newSAXParser();
            XMLReader lector = parser.getXMLReader();

            // asigna el manejador de eventos y parsea el archivo
            lector.setContentHandler(handler);
            lector.parse(original);

            listaClientes = handler.getListaClientes();
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        return listaClientes;
    }

    public static ArrayList<Cita> cargarListaCitas(InputStream archivo, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios) {
        ArrayList<Cita> listaCitas = new ArrayList<>();

        try {
            InputSource original = new InputSource(archivo);
            SAXHandlerCita handler = new SAXHandlerCita(listaClientes, listaVeterinarios);

            // configuración del parser SAX
            SAXParserFactory categoria = SAXParserFactory.newInstance();
            SAXParser parser = categoria.newSAXParser();
            XMLReader lector = parser.getXMLReader();

            // asigna el manejador de eventos y parsea el archivo
            lector.setContentHandler(handler);
            lector.parse(original);

            listaCitas = handler.getListaCitas();
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        return listaCitas;
    }
}
