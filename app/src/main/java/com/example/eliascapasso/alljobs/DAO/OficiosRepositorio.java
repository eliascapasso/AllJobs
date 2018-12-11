package com.example.eliascapasso.alljobs.DAO;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.eliascapasso.alljobs.Modelo.Oficio;
import com.example.eliascapasso.alljobs.R;
import java.util.ArrayList;
import java.util.List;

public class OficiosRepositorio {

    private static OficiosRepositorio _REPO= null;
    private OficioDAO oficioDAO;
    public OficiosRepositorio(Context ctx){
        AppDatabase db = Room.databaseBuilder(ctx,
                AppDatabase.class, "bd_lab")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        oficioDAO = db.oficioDAO();
    }

    public static OficiosRepositorio getInstance(Context ctx){
        if(_REPO==null) _REPO = new OficiosRepositorio(ctx);
        return _REPO;
    }

    public void crearOficio(Oficio oficio){
        oficioDAO.crearOficio(oficio);
    }

    public void modificarOficio (Oficio oficio){
        oficioDAO.modificarOficio(oficio);
    }

    public void eliminarUsuario(Oficio oficio){
        oficioDAO.eliminarOficio(oficio);
    }

    public Oficio obtenerOficio(int id){
        return oficioDAO.obtenerOficio(id);
    }

    public List<Oficio> listarOficios(){
        return oficioDAO.listarOficios();
    }

    private static ArrayList<Oficio> LISTA_OFICIOS = new ArrayList<Oficio>();
    private static boolean FLAG_INICIALIZADO = false;

    private static void inicializar(){
        String oficios[] = {"Enfermería", "Plomería", "Mecánica", "Albañilería", "Niñera/o", "Cuidador", "Changarín"};
        int[] imagenesOficios = {
                R.drawable.enfermeria,
                R.drawable.plomeria,
                R.drawable.mecanica,
                R.drawable.albanileria,
                R.drawable.niniera,
                R.drawable.cuidador,
                R.drawable.changarin};

        for(int i = 0 ; i < oficios.length ; i++){
            LISTA_OFICIOS.add(new Oficio(i+1, oficios[i], imagenesOficios[i]));
        }

        FLAG_INICIALIZADO=true;
    }

    public OficiosRepositorio(){
        if(!FLAG_INICIALIZADO) inicializar();
    }

    public ArrayList<Oficio> getListaOficios(){
        return LISTA_OFICIOS;
    }

    public Oficio buscarPorId(Integer id){
        for(Oficio o: LISTA_OFICIOS){
            if(o.getIdOficio() == id) return o;
        }
        return null;
    }
}
