package com.example.eliascapasso.alljobs.DAO;
import com.example.eliascapasso.alljobs.Clases.Trabajador;
import com.example.eliascapasso.alljobs.R;
import java.util.ArrayList;

public class TrabajadoresRepositorio {
    private static ArrayList<Trabajador> LISTA_TRABAJADORES = new ArrayList<Trabajador>();
    private static boolean FLAG_INICIALIZADO = false;
    private static OficiosRepositorio oficiosRepositorio;

    private void inicializar(){
        inicializarTrabajadores();

        FLAG_INICIALIZADO=true;
    }

    public TrabajadoresRepositorio(){
        oficiosRepositorio = new OficiosRepositorio();
        if(!FLAG_INICIALIZADO) inicializar();
    }

    private void inicializarTrabajadores(){
        //Enfermeras
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(1),"Maria Perez", R.drawable.enfermera1, "enfermera profesional"));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(1),"Rosa Spinetta", R.drawable.enfermera2, "Licenciada en enfermería"));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(1),"Mabel de Los Angeles", R.drawable.enfermera3, "me la rebusco"));

        //Plomeros
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(2),"Ricardo Perez", R.drawable.plomero1, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(2),"Roberto Spinetta", R.drawable.plomero2, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(2),"Luciano Salas", R.drawable.plomero3, ""));

        //Mecanicos
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(3),"Francisco Benitez", R.drawable.mecanico1, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(3),"Edgardo Stieben", R.drawable.mecanico2, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(3),"Agustin Perez", R.drawable.mecanico3, ""));

        //albañiles
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(4),"Mario Fernandez", R.drawable.albanil1, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(4),"Tomas Lay", R.drawable.albanil2, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(4),"Claudio Iglesias", R.drawable.albanil3, ""));

        //Niñeros
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(5),"Luciana Perez", R.drawable.niniera1, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(5),"Jesica Rodriguez", R.drawable.niniera2, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(5),"Marta Sanchez", R.drawable.niniera3, ""));

        //Cuidadores
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(6),"Luciana Rodriguez", R.drawable.cuidador1, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(6),"Jesica Perez", R.drawable.cuidador2, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(6),"Mario Gimenez", R.drawable.cuidador3, ""));

        //Changarines
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(7),"Rodrigo Sanchez", R.drawable.changarin1, ""));
        LISTA_TRABAJADORES.add(new Trabajador(oficiosRepositorio.buscarPorId(7),"Carlos Gonzalez", R.drawable.changarin2, ""));
    }

    public ArrayList<Trabajador> getListaTrabajadores(){
        return LISTA_TRABAJADORES;
    }

    public Trabajador buscarPorId(Integer id){
        for(Trabajador t: LISTA_TRABAJADORES){
            if(t.getId() == id) return t;
        }
        return null;
    }
}
