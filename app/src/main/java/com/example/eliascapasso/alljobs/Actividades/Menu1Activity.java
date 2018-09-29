package com.example.eliascapasso.alljobs.Actividades;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.eliascapasso.alljobs.R;

public class Menu1Activity extends AppCompatActivity {

    private TextView tv_nombreOficio;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        inicializarAtributos();
    }

    private void inicializarAtributos(){
        tv_nombreOficio = (TextView)findViewById(R.id.tv_nombreOficio);

        setearNombreOficio();
    }

    public void setearNombreOficio(){
        Bundle extras = getIntent().getExtras();
        String nombreOficio = extras.getString("nombreOficio");

        //Ingresa en el tv el nombre del oficio que se seleccionó
        tv_nombreOficio.setText(nombreOficio);
    }

    public void listaTrabajadores(View view){
        Intent trabajadores = new Intent(this, TrabajadoresActivity.class);
        trabajadores.putExtra("nombreOficio", tv_nombreOficio.getText().toString());
        startActivity(trabajadores);
    }

    public void listaTrabajos(View view){
        Intent trabajos = new Intent(this, TrabajosActivity.class);
        trabajos.putExtra("nombreOficio", tv_nombreOficio.getText().toString());
        startActivity(trabajos);
    }
}
