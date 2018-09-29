package com.example.eliascapasso.alljobs.Clases;

import java.util.ArrayList;

public class Trabajador extends Usuario {
    private ArrayList<Integer> idsOficios = new ArrayList<Integer>();

    public Trabajador(int idOficio, String nombreApellido, int foto, String especialidad){
        super(nombreApellido, foto, especialidad); //TODO: setear el resto de atributos del usuario
        this.idsOficios.add(idOficio);
    }

    public ArrayList<Integer> getIdsOficios(){
        return idsOficios;
    }
}
