package com.example.eliascapasso.alljobs.Modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Objects;

@Entity(tableName ="Usuario")
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idUsuario")
    private int id;

    @ColumnInfo(name = "apellidoUsuario")
    private String apellido;
    @ColumnInfo(name = "nombreUsuario")
    private String nombre;
    @ColumnInfo(name = "emailUsuario")
    private String email;
    @ColumnInfo(name = "passUsuario")
    private String pass;
    @ColumnInfo(name = "fechaNacimientoUsuario")
    private String fechaNacieminto;
    @ColumnInfo(name = "fotoUsuario")
    private int foto;

    public Usuario(int id, String apellido, String nombre, String email, String pass, String fechaNacieminto) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
        this.fechaNacieminto = fechaNacieminto;
    }

    public Usuario(){}

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public int getId(){
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFechaNacieminto() {
        return fechaNacieminto;
    }

    public void setFechaNacieminto(String fechaNacieminto) {
        this.fechaNacieminto = fechaNacieminto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }
}
