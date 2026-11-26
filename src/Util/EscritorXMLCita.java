package Util;

import Conceptos.Cita;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Escritor DOM para generar el XML de citas.
 *
 * @author marcoperezr
 */
public class EscritorXMLCita extends EscritorXML {

    public void escribirCitas(ArrayList<Cita> listaCitas, File archivo) {
        try {
            Document doc = crearNuevoDocumento();

            // etiqueta raíz <citas>
            Element raiz = doc.createElement("citas");
            doc.appendChild(raiz);

            // recorrer la lista y crear cada <cita>
            for (Cita cita : listaCitas) {
                Element citaElem = doc.createElement("cita");
                citaElem.setAttribute("id", cita.getIdentificacion());

                String clienteId = (cita.getCliente() != null) ? cita.getCliente().getIdentificacion() : "";
                String veterinarioId = (cita.getVeterinario() != null) ? cita.getVeterinario().getIdentificacion() : "";

                citaElem.appendChild(crearElementoTexto(doc, "cliente_id", clienteId));
                citaElem.appendChild(crearElementoTexto(doc, "fecha", cita.getFecha()));
                citaElem.appendChild(crearElementoTexto(doc, "veterinario_id", veterinarioId));
                citaElem.appendChild(crearElementoTexto(doc, "observaciones", cita.getObservaciones()));

                // bloque anidado <diagnosticos>
                Element diagnosticosContenedor = doc.createElement("diagnosticos");
                if (cita.getListaDiagnosticos() != null) {
                    for (String d : cita.getListaDiagnosticos()) {
                        diagnosticosContenedor.appendChild(crearElementoTexto(doc, "diagnostico", d));
                    }
                }
                citaElem.appendChild(diagnosticosContenedor);

                // bloque anidado <tratamientos>
                Element tratamientosContenedor = doc.createElement("tratamientos");
                if (cita.getListaTratamientos() != null) {
                    for (String t : cita.getListaTratamientos()) {
                        tratamientosContenedor.appendChild(crearElementoTexto(doc, "tratamiento", t));
                    }
                }
                citaElem.appendChild(tratamientosContenedor);

                raiz.appendChild(citaElem);
            }

            guardarDocumentoEnArchivo(doc, archivo);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
