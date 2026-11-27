package Util;

import Conceptos.Cita;
import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase utilitaria para cargar, guardar y limpiar los archivos binarios .DAT
 * mediante las clases *Input y *Output.
 *
 * @author marcoperezr
 */
public class GestorDAT {

    // cargar clientes desde Data/CLIENTES.DAT
    public static ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        ClienteInput entrada = new ClienteInput();
        try {
            entrada.abrir();
            Cliente obj;
            while ((obj = entrada.leer()) != null) {
                lista.add(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                entrada.cerrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    // guardar clientes en Data/CLIENTES.DAT
    public static void guardarClientes(ArrayList<Cliente> lista) {
        ClienteOutput salida = new ClienteOutput();
        try {
            salida.abrir();
            if (lista != null) {
                for (Cliente c : lista) {
                    salida.escribir(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                salida.cerrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // cargar servicios desde Data/SERVICIOS.DAT
    public static ArrayList<Servicio> cargarServicios() {
        ArrayList<Servicio> lista = new ArrayList<>();
        ServicioInput entrada = new ServicioInput();
        try {
            entrada.abrir();
            Servicio obj;
            while ((obj = entrada.leer()) != null) {
                lista.add(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                entrada.cerrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    // guardar servicios en Data/SERVICIOS.DAT
    public static void guardarServicios(ArrayList<Servicio> lista) {
        ServicioOutput salida = new ServicioOutput();
        try {
            salida.abrir();
            if (lista != null) {
                for (Servicio s : lista) {
                    salida.escribir(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                salida.cerrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // cargar veterinarios desde Data/VETERINARIOS.DAT
    public static ArrayList<Veterinario> cargarVeterinarios() {
        ArrayList<Veterinario> lista = new ArrayList<>();
        VeterinarioInput entrada = new VeterinarioInput();
        try {
            entrada.abrir();
            Veterinario obj;
            while ((obj = entrada.leer()) != null) {
                lista.add(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                entrada.cerrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    // guardar veterinarios en Data/VETERINARIOS.DAT
    public static void guardarVeterinarios(ArrayList<Veterinario> lista) {
        VeterinarioOutput salida = new VeterinarioOutput();
        try {
            salida.abrir();
            if (lista != null) {
                for (Veterinario v : lista) {
                    salida.escribir(v);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                salida.cerrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // cargar citas desde Data/CITAS.DAT
    public static ArrayList<Cita> cargarCitas() {
        ArrayList<Cita> lista = new ArrayList<>();
        CitaInput entrada = new CitaInput();
        try {
            entrada.abrir();
            Cita obj;
            while ((obj = entrada.leer()) != null) {
                lista.add(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                entrada.cerrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    // guardar citas en Data/CITAS.DAT
    public static void guardarCitas(ArrayList<Cita> lista) {
        CitaOutput salida = new CitaOutput();
        try {
            salida.abrir();
            if (lista != null) {
                for (Cita c : lista) {
                    salida.escribir(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                salida.cerrar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // vaciar los 4 archivos .DAT dejando el encabezado válido sin objetos
    public static void limpiarTodosDAT() {
        try {
            ClienteOutput salidaClientes = new ClienteOutput();
            salidaClientes.abrir();
            salidaClientes.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ServicioOutput salidaServicios = new ServicioOutput();
            salidaServicios.abrir();
            salidaServicios.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            VeterinarioOutput salidaVeterinarios = new VeterinarioOutput();
            salidaVeterinarios.abrir();
            salidaVeterinarios.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            CitaOutput salidaCitas = new CitaOutput();
            salidaCitas.abrir();
            salidaCitas.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // reemplazar las referencias deserializadas en citas por las instancias reales en memoria
    public static void vincularReferenciasCitas(ArrayList<Cita> citas, ArrayList<Cliente> clientes, ArrayList<Veterinario> veterinarios) {
        if (citas == null) {
            return;
        }

        for (Cita cita : citas) {
            // vincular cliente
            if (cita.getCliente() != null && clientes != null) {
                String idCliente = cita.getCliente().getIdentificacion();
                if (idCliente != null) {
                    for (Cliente c : clientes) {
                        if (idCliente.equalsIgnoreCase(c.getIdentificacion())) {
                            cita.setCliente(c);
                            break;
                        }
                    }
                }
            }

            // vincular veterinario (si la cita tiene uno asignado)
            if (cita.getVeterinario() != null && veterinarios != null) {
                String idVet = cita.getVeterinario().getIdentificacion();
                if (idVet != null) {
                    for (Veterinario v : veterinarios) {
                        if (idVet.equalsIgnoreCase(v.getIdentificacion())) {
                            cita.setVeterinario(v);
                            break;
                        }
                    }
                }
            }
        }
    }
}
