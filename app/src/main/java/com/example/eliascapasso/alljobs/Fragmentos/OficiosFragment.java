package com.example.eliascapasso.alljobs.Fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.eliascapasso.alljobs.Actividades.Menu1Activity;
import com.example.eliascapasso.alljobs.Adaptadores.AdaptadorOficios;
import com.example.eliascapasso.alljobs.DAO.OficiosRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Oficio;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class OficiosFragment extends Fragment{

    private ListView lv_oficios;
    private ArrayList<Oficio> listaOficios;
    private OficiosRepositorio oficiosRepositorio;

    public OficiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_oficios, container, false);

        inicializarAtributos(v);

        eligeOficio(v);

        return v;
    }

    private void inicializarAtributos(View v){
        oficiosRepositorio = new OficiosRepositorio();
        listaOficios = oficiosRepositorio.getListaOficios();

        lv_oficios = (ListView) v.findViewById(R.id.lv_oficios);
        lv_oficios.setAdapter(new AdaptadorOficios(v.getContext(), listaOficios));
    }

    private void eligeOficio(View v){
        final Intent menu = new Intent(v.getContext(), Menu1Activity.class);

        lv_oficios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                menu.putExtra("idOficio", oficiosRepositorio.getListaOficios().get(position).getId());
                startActivity(menu);
            }
        });
    }
}
