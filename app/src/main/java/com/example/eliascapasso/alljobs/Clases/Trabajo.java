package com.example.eliascapasso.alljobs.Clases;

import java.util.ArrayList;
import java.util.Date;

public class Trabajo {
    private static int idTrabajo = 0;
    private Trabajador trabajador;
    private String descripcion;
    private String titulo;
    private Date fechaRealizacion;
    private int idEmpleador;
    private int idOficio;

    public Trabajo(String titulo, String descripcion, Date fechaRealizacion, int idEmpleador, int idOficio){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaRealizacion = fechaRealizacion;
        this.idEmpleador = idEmpleador;
        this.idOficio = idOficio;

        idTrabajo++;
    }

    public static int getIdTrabajo() {
        return idTrabajo;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public int getIdEmpleador() {
        return idEmpleador;
    }

    public int getIdOficio() {
        return idOficio;
    }

    public void setIdOficio(int idOficio) {
        this.idOficio = idOficio;
    }
}
