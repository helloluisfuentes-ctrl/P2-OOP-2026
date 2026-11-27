package Util;

import Conceptos.Veterinario;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Manejador SAX para leer veterinarios desde XML.
 *
 * @author marcoperezr
 */
public class SAXHandlerVeterinario extends DefaultHandler {

    // lista donde se guardan los veterinarios procesados
    private ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();

    // pilas y acumulador de texto
    private Stack<Veterinario> pilaVeterinarios = new Stack<>();
    private Stack<String> pilaEtiquetas = new Stack<>();
    private StringBuilder textoActual = new StringBuilder();

    public SAXHandlerVeterinario() {
    }

    @Override
    public void startDocument() throws SAXException {
        // nada
    }

    @Override
    public void endDocument() throws SAXException {
        // nada
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atributos) throws SAXException {
        this.pilaEtiquetas.push(qName);
        this.textoActual.setLength(0);

        if (qName.equalsIgnoreCase("veterinario")) {
            Veterinario veterinario = new Veterinario();
            veterinario.setIdentificacion(atributos.getValue("id"));
            this.pilaVeterinarios.push(veterinario);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.textoActual.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String valor = this.textoActual.toString().trim();

        if (!this.pilaVeterinarios.isEmpty()) {
            Veterinario veterinario = this.pilaVeterinarios.peek();
            if (qName.equalsIgnoreCase("nombre")) {
                veterinario.setNombre(valor);
            } else if (qName.equalsIgnoreCase("telefono")) {
                veterinario.setTelefono(valor);
            } else if (qName.equalsIgnoreCase("puesto")) {
                veterinario.setPuesto(valor);
            } else if (qName.equalsIgnoreCase("veterinario")) {
                this.listaVeterinarios.add(this.pilaVeterinarios.pop());
            }
        }

        if (!this.pilaEtiquetas.isEmpty()) {
            this.pilaEtiquetas.pop();
        }
        this.textoActual.setLength(0);
    }

    public ArrayList<Veterinario> getListaVeterinarios() {
        return this.listaVeterinarios;
    }
}
