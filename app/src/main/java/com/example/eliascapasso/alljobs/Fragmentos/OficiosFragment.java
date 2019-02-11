package com.example.eliascapasso.alljobs.Fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.Actividades.Menu1Activity;
import com.example.eliascapasso.alljobs.Actividades.TrabajosActivity;
import com.example.eliascapasso.alljobs.Adaptadores.AdaptadorOficios;
import com.example.eliascapasso.alljobs.DAO.OficiosRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Oficio;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class OficiosFragment extends Fragment{

    private ListView lv_oficios;
    private ArrayList<Oficio> listaOficios;
    private OficiosRepositorio oficiosRepositorio;
    private Button btnNuevoOficio;

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

        btnNuevoOficio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Funcionalidad no implementada", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    private void inicializarAtributos(View v){
        btnNuevoOficio = v.findViewById(R.id.btnNuevoOficio);
        oficiosRepositorio = new OficiosRepositorio();
        listaOficios = oficiosRepositorio.getListaOficios();

        lv_oficios = (ListView) v.findViewById(R.id.lv_oficios);
        lv_oficios.setAdapter(new AdaptadorOficios(v.getContext(), listaOficios));
    }

    private void eligeOficio(View v){
        final Intent trabajosActivity = new Intent(v.getContext(), TrabajosActivity.class);

        lv_oficios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trabajosActivity.putExtra("idOficio", oficiosRepositorio.getListaOficios().get(position).getIdOficio());
                startActivity(trabajosActivity);
            }
        });
    }
}
