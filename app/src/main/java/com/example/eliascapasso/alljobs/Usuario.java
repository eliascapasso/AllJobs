package com.example.eliascapasso.alljobs;

public class Usuario {
    private String nombreApellido;
    private int foto;
    private String tituloEspecialidad;

    public Usuario(String nombreApellido, int foto, String tituloEspecialidad) {
        this.nombreApellido = nombreApellido;
        this.foto = foto;
        this.tituloEspecialidad = tituloEspecialidad;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public int getFoto() {
        return foto;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTituloEspecialidad() {
        return tituloEspecialidad;
    }

    public void setTituloEspecialidad(String tituloEspecialidad) {
        this.tituloEspecialidad = tituloEspecialidad;
    }
}
