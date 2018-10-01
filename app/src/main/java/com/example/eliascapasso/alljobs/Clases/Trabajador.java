package com.example.eliascapasso.alljobs.Clases;

import java.util.ArrayList;

public class Trabajador extends Usuario {
    private ArrayList<Oficio> listaOficios = new ArrayList<Oficio>();
    private ArrayList<Trabajo> listaTrabajos = new ArrayList<Trabajo>(); //TODO: Implementar
    private ArrayList<Empleador> listaEmpleadores = new ArrayList<Empleador>(); //TODO: Implementar
    private String tituloEspecialidad;

    public Trabajador(Oficio oficio, String nombreApellido, int foto, String especialidad){
        super(nombreApellido, foto); //TODO: setear el resto de atributos del usuario
        this.listaOficios.add(oficio);
        this.tituloEspecialidad = especialidad;
    }

    public ArrayList<Oficio> getListaOficios(){
        return listaOficios;
    }

    public String getTituloEspecialidad() {
        return tituloEspecialidad;
    }
}
