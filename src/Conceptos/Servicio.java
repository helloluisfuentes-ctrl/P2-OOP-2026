/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.io.Serializable;

/**
 *
 * @author fuent
 */
public class Servicio implements Serializable {
    
    //Atributos
    private static final long serialVersionUID = 1L; //para que no de errores
    
    private String identificacion;
    private String nombre;
    private String precio;

    //Constructor

    public Servicio() {
        this.identificacion = "";
        this.nombre = "";
        this.precio = "";
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    //toString
    @Override
    public String toString() {
        return "Servicio{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
 
}
