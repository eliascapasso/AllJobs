package com.example.eliascapasso.alljobs.DAO;

import com.example.eliascapasso.alljobs.Modelo.Oficio;
import com.example.eliascapasso.alljobs.R;
import java.util.ArrayList;

public class OficiosRepositorio {
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
            if(o.getId() == id) return o;
        }
        return null;
    }
}
