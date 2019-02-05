package com.example.eliascapasso.alljobs.DAO;

import android.arch.persistence.room.TypeConverter;

import com.example.eliascapasso.alljobs.Modelo.Trabajo;

public class EstadoConverter {
    @TypeConverter
    public static Trabajo.Estado toEstado(String status) {
        return Trabajo.Estado.valueOf(status);
    }

    @TypeConverter public static String toString(Trabajo.Estado status) {
        return status.toString();
    }
}

