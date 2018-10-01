package com.example.eliascapasso.alljobs.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Adaptadores.AdaptadorTrabajos;
import com.example.eliascapasso.alljobs.Clases.Trabajo;
import com.example.eliascapasso.alljobs.DAO.OficiosRepositorio;
import com.example.eliascapasso.alljobs.DAO.TrabajadoresRepositorio;
import com.example.eliascapasso.alljobs.DAO.TrabajosRepositorio;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class TrabajosActivity extends AppCompatActivity {

    private ListView lv_trabajos;
    private TextView tv_trabajos;
    private TrabajosRepositorio trabajosRepositorio = new TrabajosRepositorio();
    private OficiosRepositorio oficiosRepositorio = new OficiosRepositorio();
    private ArrayList<Trabajo> listaTrabajosActivity = new ArrayList<Trabajo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajos);

        tv_trabajos = (TextView)findViewById(R.id.tv_tituloListaTrabajos);

        recibirDatos();

        lv_trabajos = (ListView) findViewById(R.id.lv_listaTrabajos);

        lv_trabajos.setAdapter(new AdaptadorTrabajos(this, listaTrabajosActivity));
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        int idOficio = extras.getInt("idOficio");

        listaTrabajosActivity = trabajosRepositorio.buscarPorIdOficio(idOficio);

        //Setea el titulo del oficio de la lista de trabajos
        tv_trabajos.setText("Trabajos de " + oficiosRepositorio.buscarPorId(idOficio).getNombreOficio());
    }
}
