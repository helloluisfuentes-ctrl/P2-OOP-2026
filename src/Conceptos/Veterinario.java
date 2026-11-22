/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import Conceptos.Servicio;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author fuent
 */
public class Veterinario implements Serializable{
    
    
    
    //Atributos
    private static final long serialVersionUID = 1L; //para que no de errores
    
    private String identificacion;
    private String nombre;
    private String puesto;
    private String telefono;
    private ArrayList<Servicio> listaServicios = new ArrayList();
    
    //Constructor

    public Veterinario() {
        this.identificacion = "";
        this.nombre = "";
        this.puesto = "";
        this.telefono = "";
    }
    
    
    
    //Getters and setters
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //toString
    @Override
    public String toString() {
        return  nombre;
    }
    
    //NO SE SI SE DEBE ELIMINAR LSITA SERVICIOS
    
   public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }
    
    //Añadir y eliminar servicio
    public void AñadirServicio(Servicio servicio){
        this.listaServicios.add(servicio);
    }
    
    public void EliminarServicio(Servicio servicio){
        this.listaServicios.remove(servicio);
    }
}
