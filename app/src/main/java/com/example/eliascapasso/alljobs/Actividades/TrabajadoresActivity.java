package com.example.eliascapasso.alljobs.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Adaptadores.AdaptadorTrabajadores;
import com.example.eliascapasso.alljobs.Modelo.Oficio;
import com.example.eliascapasso.alljobs.Modelo.Trabajador;
import com.example.eliascapasso.alljobs.DAO.OficiosRepositorio;
import com.example.eliascapasso.alljobs.DAO.TrabajadoresRepositorio;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class TrabajadoresActivity extends AppCompatActivity {

    private ListView lv_trabajadores;
    private TextView tv_oficioTrabajadores;
    private TrabajadoresRepositorio trabajadoresRepositorio = new TrabajadoresRepositorio();
    private OficiosRepositorio oficiosRepositorio = new OficiosRepositorio();
    private ArrayList<Trabajador> listaTrabajadoresActivity = new ArrayList<Trabajador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajadores);

        inicializarAtributos();

        lv_trabajadores.setAdapter(new AdaptadorTrabajadores(this, listaTrabajadoresActivity));
    }

    private void inicializarAtributos(){
        tv_oficioTrabajadores = (TextView)findViewById(R.id.tv_oficioTrabajadores);
        lv_trabajadores = (ListView) findViewById(R.id.lv_trabajadores);

        recibirDatos();
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        int idOficio = extras.getInt("idOficio");

        for(Trabajador t: trabajadoresRepositorio.getListaTrabajadores()){
            for(Oficio o: t.getListaOficios()){
                if(o.getId() == idOficio){
                    listaTrabajadoresActivity.add(t);
                }
            }
        }

        //Setea el nombre del oficio como titulo
        tv_oficioTrabajadores.setText("Trabajadores en " + oficiosRepositorio.buscarPorId(idOficio).getNombreOficio());
    }
}
