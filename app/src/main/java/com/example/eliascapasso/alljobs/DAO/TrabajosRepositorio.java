package com.example.eliascapasso.alljobs.DAO;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;

import com.example.eliascapasso.alljobs.Modelo.Trabajo;

import java.text.SimpleDateFormat;
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



    public void crearTrabajo(Trabajo trabajo){
        trabajoDAO.crearTrabajo(trabajo);
    }

    public void modificarTrabajo (Trabajo trabajo){
        trabajoDAO.modificarTrabajo(trabajo);
    }

    public void eliminarTrabajo(Trabajo trabajo){
        trabajoDAO.eliminarTrabajo(trabajo);
    }

    public Trabajo obtenerTrabajo(int idTrabajo){
        ArrayList<Trabajo> lista = new ArrayList<>();

        for(Trabajo t: LISTA_TRABAJOS){
            if(t.getIdTrabajo() == idTrabajo) return t;
        }
        return null;
    }

    public List<Trabajo> listarTrabajos(){
        return trabajoDAO.listarTrabajos();
    }

    private static ArrayList<Trabajo> LISTA_TRABAJOS = new ArrayList<Trabajo>();
    private static boolean FLAG_INICIALIZADO = false;

    private static void inicializar(){
        Trabajo t;
        //Enfermeria
        t = new Trabajo(1,
                        "Se necesita enfermero a tiempo completo",
                        "",
                        1000,
                        6000,
                        new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(),
                        1,
                        1,
                        -31.6007506,
                        -60.6891529);
        LISTA_TRABAJOS.add(t);
        t = new Trabajo(2,
                        "Busco enfermera",
                        "",
                        500,
                        3000,
                        new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(),
                        1,
                        1,
                        -31.6407592,
                        -60.7188878);
        LISTA_TRABAJOS.add(t);
        t = new Trabajo(3,"Necesito inyecciones", "", 100, 200, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 1, -31.638716,-60.7055317);
        LISTA_TRABAJOS.add(t);
        LISTA_TRABAJOS.add(new Trabajo(4,"se busca enfermera", "", 1000, 10000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 1, -31.6329444,-60.7104706));
        LISTA_TRABAJOS.add(new Trabajo(5,"alguna enfermera disponible?", "", 1500, 13000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 1, -31.6415491,-60.7025719));

        //Plomeria
        LISTA_TRABAJOS.add(new Trabajo(6,"Tuberia rota", "", 100, 2000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 2, -31.6059383,-60.6849839));
        LISTA_TRABAJOS.add(new Trabajo(7,"Busco plomero", "", 300, 1000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 2, -31.6382427,-60.7193591));
        LISTA_TRABAJOS.add(new Trabajo(8,"algun plomero?", "", 500, 2500, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 2, -31.6540619,-60.7345082));
        LISTA_TRABAJOS.add(new Trabajo(9,"oportunidad en empresa fontanera", "", 5000, 10000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 2, -31.63616,-60.6939103));

        //Mecanica
        LISTA_TRABAJOS.add(new Trabajo(10,"Auto fundido", "", 4000, 12000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 3, -31.6326487,-60.710129));
        LISTA_TRABAJOS.add(new Trabajo(11,"fiat 600, caja de cambios", "", 3000, 5000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 3, -31.631416,-60.7168346));
        LISTA_TRABAJOS.add(new Trabajo(12,"busco mecanico barato", "", 1000, 5000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 3, -31.628061,-60.7092277));

        //Albañileria
        LISTA_TRABAJOS.add(new Trabajo(13,"busco peon", "", 2000, 10000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 4, -31.6197407,-60.7208221));
        LISTA_TRABAJOS.add(new Trabajo(14,"se busca encargado de obra", "", 10000, 15000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 4,-31.643505,-60.7254457));
        LISTA_TRABAJOS.add(new Trabajo(15,"proyecto para la construccion de un puente", "", 50000, 100000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 4, -31.622704,-60.7033447));

        //Niñera
        LISTA_TRABAJOS.add(new Trabajo(16,"se busca niñera", "", 500, 1000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 5, -31.655188,-60.7184197));
        LISTA_TRABAJOS.add(new Trabajo(17,"necesito niñera", "", 400, 800,  new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 5,-31.597113,-60.6991387));
        LISTA_TRABAJOS.add(new Trabajo(18,"busco niñera por la mañana", "", 500, 1000,  new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 5,-31.572857,-60.6919187));
        LISTA_TRABAJOS.add(new Trabajo(19,"niñera por la tarde", "", 500, 1500,  new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 5,-31.609902,-60.6733057));

        //Cuidador
        LISTA_TRABAJOS.add(new Trabajo(20,"Busco cuidador para persona mayor", "", 1000, 2000, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 6, -31.613312,-60.6791037));

        //Changarin
        LISTA_TRABAJOS.add(new Trabajo(21,"cortar el pasto", "", 50, 200, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 7,-31.59653,-60.7163577));
        LISTA_TRABAJOS.add(new Trabajo(22,"pintar rejas", "", 30, 300, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 7,-31.588272,-60.7060287));
        LISTA_TRABAJOS.add(new Trabajo(23,"alguien para pasear mi caniche?", "", 50, 250, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 7,-31.660485,-60.7202137));
        LISTA_TRABAJOS.add(new Trabajo(24,"para pasear 12 perros", "", 100, 950, new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString(), 1, 7,-31.624906,-60.7195517));


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
