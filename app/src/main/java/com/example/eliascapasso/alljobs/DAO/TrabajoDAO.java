package com.example.eliascapasso.alljobs.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.eliascapasso.alljobs.Modelo.Trabajo;

import java.util.List;

@Dao
public interface TrabajoDAO {
    @Insert
    public void crearTrabajo(Trabajo trabajo);
    @Update
    public void modificarTrabajo (Trabajo trabajo);
    @Delete
    public void eliminarTrabajo(Trabajo trabajo);
    @Query("SELECT * FROM Trabajo WHERE idTrabajo = :id")
    public Trabajo obtenerTrabajo(int id);
    @Query("SELECT * FROM Trabajo")
    public List<Trabajo> listarTrabajos();
}
