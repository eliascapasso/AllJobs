package com.example.eliascapasso.alljobs.Clases;

public class Oficio {
    private static int id = 1;
    private String nombreOficio;
    private int imagenOficio;

    public Oficio(String nombreOficio, int imagenOficio){
        this.nombreOficio = nombreOficio;
        this.imagenOficio = imagenOficio;

        id++;
    }

    public int getId() {
        return id;
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
