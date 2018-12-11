package com.example.eliascapasso.alljobs.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.eliascapasso.alljobs.Modelo.Oficio;

import java.util.List;

@Dao
public interface OficioDAO {
    @Insert
    public void crearOficio(Oficio oficio);
    @Update
    public void modificarOficio (Oficio oficio);
    @Delete
    public void eliminarOficio(Oficio oficio);
    @Query("SELECT * FROM Oficio WHERE idOficio = :id")
    public Oficio obtenerOficio(int id);
    @Query("SELECT * FROM Oficio")
    public List<Oficio> listarOficios();
}
