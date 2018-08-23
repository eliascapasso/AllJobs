package com.example.eliascapasso.alljobs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu1Activity extends AppCompatActivity {

    private TextView tv_nombreOficio;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        tv_nombreOficio = (TextView)findViewById(R.id.tv_nombreOficio);

        recibirDatos();
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        String nombreOficio = extras.getString("nombreOficio");

        //Ingresa en el tv el nombre del oficio que se seleccionó
        tv_nombreOficio.setText(nombreOficio);
    }

    public void btn_empleador(View view){
        Intent proyectos = new Intent(this, TrabajosActivity.class);
        proyectos.putExtra("nombreOficio", tv_nombreOficio.getText().toString());
        startActivity(proyectos);
    }
    public void btn_TrabIndependiente(View view){

    }
}
