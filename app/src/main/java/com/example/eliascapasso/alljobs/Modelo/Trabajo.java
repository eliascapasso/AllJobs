package com.example.eliascapasso.alljobs.Modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName ="Trabajo")
public class Trabajo {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idTrabajo")
    private int idTrabajo = 0;
    @ColumnInfo(name = "descripcionTrabajo")
    private String descripcion;
    @ColumnInfo(name = "tituloTrabajo")
    private String titulo;
    @ColumnInfo(name = "fechaTrabajo")
    private String fechaRealizacion;
    @ColumnInfo(name = "idEmpleador")
    private int idEmpleador;
    @ColumnInfo(name = "idOficio")
    private int idOficio;

    public Trabajo(String titulo, String descripcion, String fechaRealizacion, int idEmpleador, int idOficio){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaRealizacion = fechaRealizacion;
        this.idEmpleador = idEmpleador;
        this.idOficio = idOficio;

        idTrabajo++;
    }

    @NonNull
    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(@NonNull int idTrabajo) {
        this.idTrabajo = idTrabajo;
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

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public int getIdEmpleador() {
        return idEmpleador;
    }

    public void setIdEmpleador(int idEmpleador) {
        this.idEmpleador = idEmpleador;
    }

    public int getIdOficio() {
        return idOficio;
    }

    public void setIdOficio(int idOficio) {
        this.idOficio = idOficio;
    }
}
