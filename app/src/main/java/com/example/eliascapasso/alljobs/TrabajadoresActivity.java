package com.example.eliascapasso.alljobs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TrabajadoresActivity extends AppCompatActivity {

    private ListView lv_trabajadores;
    private TextView tv_trabajadores;

    private String trabajadoresEnfermera[] = {"Maria Perez, enfermera profesional", "Rosa Spinetta, auxiliar", "Mabel de Los Angeles"};
    private String trabajadoresPlomeros[] = {""};
    private String trabajadoresMecanicos[] = {""};
    private String trabajadoresAlbaniles[] = {""};
    private String trabajadoresNinieros[] = {""};
    private String trabajadoresCuidadores[] = {""};
    private String trabajadoresChangarines[] = {""};
    private String oficioElegido[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajadores);

        tv_trabajadores = (TextView)findViewById(R.id.tv_trabajadores);

        recibirDatos();

        lv_trabajadores = (ListView) findViewById(R.id.lv_trabajadores);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_trabajadores, oficioElegido);
        lv_trabajadores.setAdapter(adapter);
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        String nombreOficio = extras.getString("nombreOficio");

        //inicializa todos los trabajos disponibles para el oficio elegido
        switch (nombreOficio){
            case "Enfermería":
                oficioElegido = trabajadoresEnfermera;
                break;
            case "Plomería":
                oficioElegido = trabajadoresPlomeros;
                break;
            case "Mecanica":
                oficioElegido = trabajadoresMecanicos;
                break;
            case "Albañilería":
                oficioElegido = trabajadoresAlbaniles;
                break;
            case "Niñera/o":
                oficioElegido = trabajadoresNinieros;
                break;
            case "Cuidador":
                oficioElegido = trabajadoresCuidadores;
                break;
            case "Changarín":
                oficioElegido = trabajadoresChangarines;
                break;
        }

        tv_trabajadores.setText("Lista de " + nombreOficio + "/s disponible/s");
    }
}
