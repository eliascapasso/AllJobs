package com.example.eliascapasso.alljobs.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.eliascapasso.alljobs.Modelo.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {
    @Insert
    public void crearUsuario(Usuario usuario);
    @Update
    public void modificarUsuario (Usuario usuario);
    @Delete
    public void eliminarUsuario(Usuario usuario);
    @Query("SELECT * FROM Usuario WHERE emailUsuario = :emailUsuario")
    public Usuario obtenerUsuario(String emailUsuario);
    @Query("SELECT * FROM Usuario")
    public List<Usuario> listarUsaurios();
}
