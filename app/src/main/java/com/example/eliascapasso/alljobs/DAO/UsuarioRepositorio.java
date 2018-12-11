package com.example.eliascapasso.alljobs.DAO;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.eliascapasso.alljobs.Modelo.Usuario;

import java.util.List;

public class UsuarioRepositorio {
    private static UsuarioRepositorio _REPO= null;
    private UsuarioDAO usuarioDAO;
    public UsuarioRepositorio(Context ctx){
        AppDatabase db = Room.databaseBuilder(ctx,
                AppDatabase.class, "bd_lab")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        usuarioDAO = db.usuarioDAO();
    }

    public static UsuarioRepositorio getInstance(Context ctx){
        if(_REPO==null) _REPO = new UsuarioRepositorio(ctx);
        return _REPO;
    }

    public void crearUsuario(Usuario u){
        usuarioDAO.crearUsuario(u);
    }

    public void modificarUsuario(Usuario u){
        usuarioDAO.modificarUsuario(u);
    }

    public void eliminarUsuario(Usuario u){
        usuarioDAO.eliminarUsuario(u);
    }

    public Usuario obtenerUsuario(int idUsuario){
        return usuarioDAO.obtenerUsuario(idUsuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioDAO.listarUsaurios();
    }
}
