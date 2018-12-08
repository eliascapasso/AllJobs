package com.example.eliascapasso.alljobs.DAO;

import com.example.eliascapasso.alljobs.Modelo.Trabajo;

import java.util.ArrayList;
import java.util.Date;

public class TrabajosRepositorio {
    private static ArrayList<Trabajo> LISTA_TRABAJOS = new ArrayList<Trabajo>();
    private static boolean FLAG_INICIALIZADO = false;

    private static void inicializar(){
        //Enfermeria
        LISTA_TRABAJOS.add(new Trabajo("Se necesita enfermero a tiempo completo", "", new Date(), 1, 1));
        LISTA_TRABAJOS.add(new Trabajo("Busco enfermera", "", new Date(), 1, 1));
        LISTA_TRABAJOS.add(new Trabajo("Necesito inyecciones", "", new Date(), 1, 1));
        LISTA_TRABAJOS.add(new Trabajo("se busca enfermera", "", new Date(), 1, 1));
        LISTA_TRABAJOS.add(new Trabajo("alguna enfermera disponible?", "", new Date(), 1, 1));

        //Plomeria
        LISTA_TRABAJOS.add(new Trabajo("Tuberia rota", "", new Date(), 1, 2));
        LISTA_TRABAJOS.add(new Trabajo("Busco plomero", "", new Date(), 1, 2));
        LISTA_TRABAJOS.add(new Trabajo("algun plomero?", "", new Date(), 1, 2));
        LISTA_TRABAJOS.add(new Trabajo("oportunidad en empresa fontanera", "", new Date(), 1, 2));

        //Mecanica
        LISTA_TRABAJOS.add(new Trabajo("Auto fundido", "", new Date(), 1, 3));
        LISTA_TRABAJOS.add(new Trabajo("busco repuestos de fiat 600", "", new Date(), 1, 3));
        LISTA_TRABAJOS.add(new Trabajo("busco mecanico barato", "", new Date(), 1, 3));

        //Albañileria
        LISTA_TRABAJOS.add(new Trabajo("busco peon", "", new Date(), 1, 4));
        LISTA_TRABAJOS.add(new Trabajo("se busca encargado de obra", "", new Date(), 1, 4));
        LISTA_TRABAJOS.add(new Trabajo("proyecto para la construccion de un puente", "", new Date(), 1, 4));

        //Niñera
        LISTA_TRABAJOS.add(new Trabajo("se busca niñera", "", new Date(), 1, 5));
        LISTA_TRABAJOS.add(new Trabajo("necesito niñera", "", new Date(), 1, 5));
        LISTA_TRABAJOS.add(new Trabajo("busco niñera por la mañana", "", new Date(), 1, 5));
        LISTA_TRABAJOS.add(new Trabajo("niñera por la tarde", "", new Date(), 1, 5));

        //Cuidador
        LISTA_TRABAJOS.add(new Trabajo("Busco cuidador para persona mayor", "", new Date(), 1, 6));

        //Changarin
        LISTA_TRABAJOS.add(new Trabajo("cortar el pasto", "", new Date(), 1, 7));
        LISTA_TRABAJOS.add(new Trabajo("pintar rejas", "", new Date(), 1, 7));
        LISTA_TRABAJOS.add(new Trabajo("alguien para pasear mi caniche?", "", new Date(), 1, 7));
        LISTA_TRABAJOS.add(new Trabajo("para pasear 12 perros", "", new Date(), 1, 7));


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
