package com.example.eliascapasso.alljobs.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.eliascapasso.alljobs.DAO.OficiosRepositorio;
import com.example.eliascapasso.alljobs.R;

public class Menu1Activity extends AppCompatActivity {

    private TextView tv_nombreOficio;
    private OficiosRepositorio oficiosRepositorio = new OficiosRepositorio();
    private int idOficio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        inicializarAtributos();
    }

    private void inicializarAtributos(){
        tv_nombreOficio = (TextView)findViewById(R.id.tv_nombreOficio);
        obtenerIdOficio();

        //Ingresa en el tv el nombre del oficio que se seleccionó
        tv_nombreOficio.setText(oficiosRepositorio.buscarPorId(idOficio).getNombreOficio());
    }

    public void obtenerIdOficio(){
        Bundle extras = getIntent().getExtras();
        idOficio = extras.getInt("idOficio");
    }

    public void listaTrabajadores(View view){
        Intent trabajadores = new Intent(this, TrabajadoresActivity.class);
        trabajadores.putExtra("idOficio", idOficio);
        startActivity(trabajadores);
    }

    public void listaTrabajos(View view){
        Intent trabajos = new Intent(this, TrabajosActivity.class);
        trabajos.putExtra("idOficio", idOficio);
        startActivity(trabajos);
    }
}
