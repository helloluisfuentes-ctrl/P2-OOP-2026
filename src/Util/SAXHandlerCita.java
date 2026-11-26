package Util;

import Conceptos.Cita;
import Conceptos.Cliente;
import Conceptos.Veterinario;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Manejador SAX para leer citas desde XML y resolver referencias a clientes y veterinarios.
 *
 * @author marcoperezr
 */
public class SAXHandlerCita extends DefaultHandler {

    // lista donde se guardan las citas procesadas
    private ArrayList<Cita> listaCitas = new ArrayList<>();
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Veterinario> listaVeterinarios;

    // pilas y acumulador de texto para observaciones largas o multilínea
    private Stack<Cita> pilaCitas = new Stack<>();
    private Stack<String> pilaEtiquetas = new Stack<>();
    private StringBuilder textoActual = new StringBuilder();

    public SAXHandlerCita(ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios) {
        this.listaClientes = listaClientes;
        this.listaVeterinarios = listaVeterinarios;
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

        if (qName.equalsIgnoreCase("cita")) {
            Cita cita = new Cita();
            cita.setIdentificacion(atributos.getValue("id"));
            this.pilaCitas.push(cita);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.textoActual.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String valor = this.textoActual.toString().trim();

        if (!this.pilaCitas.isEmpty()) {
            Cita cita = this.pilaCitas.peek();

            if (qName.equalsIgnoreCase("cliente_id")) {
                if (!valor.isEmpty() && this.listaClientes != null) {
                    for (Cliente c : this.listaClientes) {
                        if (valor.equalsIgnoreCase(c.getIdentificacion())) {
                            cita.setCliente(c);
                            break;
                        }
                    }
                }
            } else if (qName.equalsIgnoreCase("fecha")) {
                cita.setFecha(valor);
            } else if (qName.equalsIgnoreCase("veterinario_id")) {
                if (valor.isEmpty()) {
                    cita.setVeterinario(null);
                } else if (this.listaVeterinarios != null) {
                    for (Veterinario v : this.listaVeterinarios) {
                        if (valor.equalsIgnoreCase(v.getIdentificacion())) {
                            cita.setVeterinario(v);
                            break;
                        }
                    }
                }
            } else if (qName.equalsIgnoreCase("observaciones")) {
                cita.setObservaciones(valor);
            } else if (qName.equalsIgnoreCase("diagnostico")) {
                if (!valor.isEmpty()) {
                    cita.AñadirDiagnostico(valor);
                }
            } else if (qName.equalsIgnoreCase("tratamiento")) {
                if (!valor.isEmpty()) {
                    cita.AñadirTratamiento(valor);
                }
            } else if (qName.equalsIgnoreCase("cita")) {
                this.listaCitas.add(this.pilaCitas.pop());
            }
        }

        if (!this.pilaEtiquetas.isEmpty()) {
            this.pilaEtiquetas.pop();
        }
        this.textoActual.setLength(0);
    }

    public ArrayList<Cita> getListaCitas() {
        return this.listaCitas;
    }
}
