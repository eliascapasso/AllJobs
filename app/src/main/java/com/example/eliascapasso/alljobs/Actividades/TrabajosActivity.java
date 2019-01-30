package com.example.eliascapasso.alljobs.Actividades;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Adaptadores.AdaptadorTrabajos;
import com.example.eliascapasso.alljobs.Fragmentos.MapFragment;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
import com.example.eliascapasso.alljobs.DAO.OficiosRepositorio;
import com.example.eliascapasso.alljobs.DAO.TrabajosRepositorio;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class TrabajosActivity extends AppCompatActivity {

    private ListView lv_trabajos;
    private TextView tv_trabajos;
    private ImageView im_oficio;

    private TrabajosRepositorio trabajosRepositorio;
    private OficiosRepositorio oficiosRepositorio;
    private ArrayList<Trabajo> listaTrabajosActivity;
    private int idOficio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajos);

        tv_trabajos = (TextView)findViewById(R.id.tv_tituloListaTrabajos);
        im_oficio = (ImageView)findViewById(R.id.imagenOficio);

        trabajosRepositorio = new TrabajosRepositorio();
        oficiosRepositorio = new OficiosRepositorio();

        recibirDatos();

        lv_trabajos = (ListView) findViewById(R.id.lv_listaTrabajos);
        AdaptadorTrabajos adaptadorTrabajos = new AdaptadorTrabajos(getApplicationContext(), listaTrabajosActivity);
        adaptadorTrabajos.setOnMapaListener(mapaAdapterManager);
        lv_trabajos.setAdapter(adaptadorTrabajos);

        eligeTrabajo();
    }

    private void eligeTrabajo(){
        final Intent propuesta = new Intent(this, PropuestaActivity.class);

        lv_trabajos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                propuesta.putExtra("idTrabajo", trabajosRepositorio.buscarPorIdOficio(idOficio).get(position).getIdTrabajo());
                startActivity(propuesta);
            }
        });
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        idOficio = extras.getInt("idOficio");

        listaTrabajosActivity = trabajosRepositorio.buscarPorIdOficio(idOficio);

        //Setea el titulo del oficio de la lista de trabajos
        String nombreOficio = oficiosRepositorio.buscarPorId(idOficio).getNombreOficio();
        tv_trabajos.setText("Trabajos de " + nombreOficio);
        //Setea la imagen del oficio
        switch (idOficio){
            case 1:
                im_oficio.setImageResource(R.drawable.enfermeria);
                break;
            case 2:
                im_oficio.setImageResource(R.drawable.plomeria);
                break;
            case 3:
                im_oficio.setImageResource(R.drawable.mecanica);
                break;
            case 4:
                im_oficio.setImageResource(R.drawable.albanileria);
                break;
            case 5:
                im_oficio.setImageResource(R.drawable.niniera);
                break;
            case 6:
                im_oficio.setImageResource(R.drawable.cuidador);
                break;
            case 7:
                im_oficio.setImageResource(R.drawable.changarin);
                break;
        }
    }

    AdaptadorTrabajos.OnMapaListener mapaAdapterManager = new AdaptadorTrabajos.OnMapaListener(){
        @Override
        public void mostrarMapa(int id) {
            Intent mapa = new Intent(TrabajosActivity.this, MapActivity.class);
            mapa.putExtra("idTrabajo", id);
            startActivity(mapa);
        }
    };
}
