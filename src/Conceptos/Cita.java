/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author fuent
 */
public class Cita implements Serializable{
    
    private static final long serialVersionUID = 1L; //para que no de errores
    
    private String identificacion;
    private Cliente cliente;
    private Veterinario veterinario;
    private String fecha;
    private String observaciones;
    private ArrayList<String> listaDiagnosticos;
    private ArrayList<String> listaTratamientos;

    public Cita() {
        this.identificacion = "";
        this.cliente = null;
        this.veterinario = null;
        this.fecha = "";
        this.observaciones = "";
        this.listaDiagnosticos = new ArrayList<>();
        this.listaTratamientos = new ArrayList<>();
    }
    
    //metodos listas
    public void AñadirDiagnostico(String diagnostico){
        this.listaDiagnosticos.add(diagnostico);
    }
    
    public void EliminarDiagnostico(String diagnostico){
        this.listaDiagnosticos.remove(diagnostico);
    }
    
    public void AñadirTratamiento(String tratamiento){
        this.listaTratamientos.add(tratamiento);
    }
    
    public void EliminarTratamiento(String tratamiento){
        this.listaTratamientos.remove(tratamiento);
    }

    public String getIdentificacion() {
        return identificacion;
    }

    //getters and setters
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.observaciones = Observaciones;
    }

    public ArrayList<String> getListaDiagnosticos() {
        return listaDiagnosticos;
    }

    public void setListaDiagnosticos(ArrayList<String> listaDiagnosticos) {
        this.listaDiagnosticos = listaDiagnosticos;
    }

    public ArrayList<String> getListaTratamientos() {
        return listaTratamientos;
    }

    public void setListaTratamientos(ArrayList<String> listaTratamientos) {
        this.listaTratamientos = listaTratamientos;
    }
    
    //toString

    @Override
    public String toString() {
        return identificacion;
    }
    
    
}
