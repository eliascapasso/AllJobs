package com.example.eliascapasso.alljobs.DAO;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.eliascapasso.alljobs.Modelo.Trabajo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrabajosRepositorio {
    private static TrabajosRepositorio _REPO= null;
    private TrabajoDAO trabajoDAO;
    public TrabajosRepositorio(Context ctx){
        AppDatabase db = Room.databaseBuilder(ctx,
                AppDatabase.class, "bd_lab")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        trabajoDAO = db.trabajoDAO();
    }

    public static TrabajosRepositorio getInstance(Context ctx){
        if(_REPO==null) _REPO = new TrabajosRepositorio(ctx);
        return _REPO;
    }

    public void crearTrabajo(Trabajo trabajo){
        trabajoDAO.crearTrabajo(trabajo);
    }

    public void modificarTrabajo (Trabajo trabajo){
        trabajoDAO.modificarTrabajo(trabajo);
    }

    public void eliminarTrabajo(Trabajo trabajo){
        trabajoDAO.eliminarTrabajo(trabajo);
    }

    public Trabajo obtenerTrabajo(int id){
        return trabajoDAO.obtenerTrabajo(id);
    }

    public List<Trabajo> listarTrabajos(){
        return trabajoDAO.listarTrabajos();
    }

    private static ArrayList<Trabajo> LISTA_TRABAJOS = new ArrayList<Trabajo>();
    private static boolean FLAG_INICIALIZADO = false;

    private static void inicializar(){
        //Enfermeria
        LISTA_TRABAJOS.add(new Trabajo("Se necesita enfermero a tiempo completo", "", new Date().toString(), 1, 1));
        LISTA_TRABAJOS.add(new Trabajo("Busco enfermera", "", new Date().toString(), 1, 1));
        LISTA_TRABAJOS.add(new Trabajo("Necesito inyecciones", "", new Date().toString(), 1, 1));
        LISTA_TRABAJOS.add(new Trabajo("se busca enfermera", "", new Date().toString(), 1, 1));
        LISTA_TRABAJOS.add(new Trabajo("alguna enfermera disponible?", "", new Date().toString(), 1, 1));

        //Plomeria
        LISTA_TRABAJOS.add(new Trabajo("Tuberia rota", "", new Date().toString(), 1, 2));
        LISTA_TRABAJOS.add(new Trabajo("Busco plomero", "", new Date().toString(), 1, 2));
        LISTA_TRABAJOS.add(new Trabajo("algun plomero?", "", new Date().toString(), 1, 2));
        LISTA_TRABAJOS.add(new Trabajo("oportunidad en empresa fontanera", "", new Date().toString(), 1, 2));

        //Mecanica
        LISTA_TRABAJOS.add(new Trabajo("Auto fundido", "", new Date().toString(), 1, 3));
        LISTA_TRABAJOS.add(new Trabajo("busco repuestos de fiat 600", "", new Date().toString(), 1, 3));
        LISTA_TRABAJOS.add(new Trabajo("busco mecanico barato", "", new Date().toString(), 1, 3));

        //Albañileria
        LISTA_TRABAJOS.add(new Trabajo("busco peon", "", new Date().toString(), 1, 4));
        LISTA_TRABAJOS.add(new Trabajo("se busca encargado de obra", "", new Date().toString(), 1, 4));
        LISTA_TRABAJOS.add(new Trabajo("proyecto para la construccion de un puente", "", new Date().toString(), 1, 4));

        //Niñera
        LISTA_TRABAJOS.add(new Trabajo("se busca niñera", "", new Date().toString(), 1, 5));
        LISTA_TRABAJOS.add(new Trabajo("necesito niñera", "", new Date().toString(), 1, 5));
        LISTA_TRABAJOS.add(new Trabajo("busco niñera por la mañana", "", new Date().toString(), 1, 5));
        LISTA_TRABAJOS.add(new Trabajo("niñera por la tarde", "", new Date().toString(), 1, 5));

        //Cuidador
        LISTA_TRABAJOS.add(new Trabajo("Busco cuidador para persona mayor", "", new Date().toString(), 1, 6));

        //Changarin
        LISTA_TRABAJOS.add(new Trabajo("cortar el pasto", "", new Date().toString(), 1, 7));
        LISTA_TRABAJOS.add(new Trabajo("pintar rejas", "", new Date().toString(), 1, 7));
        LISTA_TRABAJOS.add(new Trabajo("alguien para pasear mi caniche?", "", new Date().toString(), 1, 7));
        LISTA_TRABAJOS.add(new Trabajo("para pasear 12 perros", "", new Date().toString(), 1, 7));


        FLAG_INICIALIZADO=true;
    }

    public TrabajosRepositorio(){
        if(!FLAG_INICIALIZADO) inicializar();
    }

    public ArrayList<Trabajo> getListaTrabajos(){
        return LISTA_TRABAJOS;
    }

    public ArrayList<Trabajo> buscarPorIdOficio(Integer id){
        ArrayList<Trabajo> lista = new ArrayList<>();

        for(Trabajo t: LISTA_TRABAJOS){
            if(t.getIdOficio() == id) lista.add(t);
        }
        return lista;
    }
}
