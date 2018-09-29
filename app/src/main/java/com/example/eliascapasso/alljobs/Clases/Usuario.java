package com.example.eliascapasso.alljobs.Clases;

import java.util.Date;

public class Usuario {
    private static int id = 1;

    private String nombreApellido;
    private String nombreUsuario;
    private String email;
    private String pass;
    private Date fechaNacieminto;
    private int CP;
    private int foto;
    private String especialidad;

    public Usuario(String nombreApellido, int foto, String especialidad){
        this.nombreApellido = nombreApellido;
        this.foto = foto;
        this.especialidad = especialidad;

        id++;
    }

    public static int getId(){
        return id;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
