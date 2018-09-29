package com.example.eliascapasso.alljobs.Clases;

public class Oficio {
    private int idOficio;
    private String nombreOficio;
    private int imagenOficio;

    public Oficio(int idOficio, String nombreOficio, int imagenOficio){
        this.nombreOficio = nombreOficio;
        this.imagenOficio = imagenOficio;
        this.idOficio = idOficio;
    }

    public int getId() {
        return idOficio;
    }

    public String getNombreOficio() {
        return nombreOficio;
    }

    public void setNombreOficio(String nombreOficio) {
        this.nombreOficio = nombreOficio;
    }

    public int getImagenOficio() {
        return imagenOficio;
    }

    public void setImagenOficio(int imagenOficio) {
        this.imagenOficio = imagenOficio;
    }
}
