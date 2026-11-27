/*
        Proyecto 2 POO
        Luis Carlos Fuentes Calvo 2026106554
        Marco Pérez Ramos 2026096083
*/

package Aplicacion;

import Conceptos.Cita;
import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
import Presentacion.Escritorio;
import Util.GestorDAT;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // cargar las 4 listas desde los archivos binarios .DAT en Data/
        ArrayList<Cliente> listaClientes = GestorDAT.cargarClientes();
        ArrayList<Servicio> listaServicios = GestorDAT.cargarServicios();
        ArrayList<Veterinario> listaVeterinarios = GestorDAT.cargarVeterinarios();
        ArrayList<Cita> listaCitas = GestorDAT.cargarCitas();

        // vincular referencias de clientes y veterinarios en las citas cargadas
        GestorDAT.vincularReferenciasCitas(listaCitas, listaClientes, listaVeterinarios);

        // inicializar la ventana principal y pasarle las listas
        Escritorio ventana = new Escritorio(listaClientes, listaServicios, listaVeterinarios, listaCitas);
        ventana.setVisible(true);
    }
}
