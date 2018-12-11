package com.example.eliascapasso.alljobs.Modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName ="Oficio")
public class Oficio {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idOficio")
    private int idOficio;
    @ColumnInfo(name = "nombreOficio")
    private String nombreOficio;
    @ColumnInfo(name = "imagenOficio")
    private int imagenOficio;

    public Oficio(int idOficio, String nombreOficio, int imagenOficio){
        this.nombreOficio = nombreOficio;
        this.imagenOficio = imagenOficio;
        this.idOficio = idOficio;
    }

    @NonNull
    public int getIdOficio() {
        return idOficio;
    }

    public void setIdOficio(@NonNull int idOficio) {
        this.idOficio = idOficio;
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
