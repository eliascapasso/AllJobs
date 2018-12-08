package com.example.eliascapasso.alljobs.Modelo;

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

    /*public Usuario(String nombreApellido, String nombreUsuario, String email, String pass, Date fechaNacieminto, int CP, int foto) {
        this.nombreApellido = nombreApellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.pass = pass;
        this.fechaNacieminto = fechaNacieminto;
        this.CP = CP;
        this.foto = foto;
    }*///TODO:IMPLEMENTAR

    public Usuario(String nombreApellido, int foto){
        this.nombreApellido = nombreApellido;
        this.foto = foto;

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
}
