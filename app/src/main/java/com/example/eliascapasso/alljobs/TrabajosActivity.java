package com.example.eliascapasso.alljobs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TrabajosActivity extends AppCompatActivity {

    private ListView lv_trabajos;
    private TextView tv_trabajos;

    private String trabajosEnfermera [] = {"Se necesita enfermero a tiempo completo", "Busco enfermera", "Necesito inyecciones", "se busca enfermera", "alguna enfermera disponible?"};
    private String trabajosPlomeria [] = {"Tuberia rota", "Busco plomero", "algun plomero?", "oportunidad en empresa fontanera"};
    private String trabajosMecanica[] = {"Auto fundido", "busco repuestos de fiat 600", "busco mecanico barato"};
    private String trabajosAlbañileria[] = {"busco peon", "se busca encargado de obra", "proyecto para la construccion de un puente"};
    private String trabajosNiniera[] = {"se busca niñera", "necesito niñera", "busco niñera por la mañana", "niñera por la tarde"};
    private String trabajosCuidador[] = {"Busco cuidador para persona mayor"};
    private String trabajosChangarin[] = {"cortar el pasto", "pintar rejas", "alguien para pasear mi caniche?", "para pasear 12 perros"};
    private String oficioElegido[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajos);

        tv_trabajos = (TextView)findViewById(R.id.tv_trabajos);

        recibirDatos();

        lv_trabajos = (ListView) findViewById(R.id.lv_trabajos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_trabajos, oficioElegido);
        lv_trabajos.setAdapter(adapter);
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        String nombreOficio = extras.getString("nombreOficio");

        //inicializa todos los trabajos disponibles para el oficio elegido
        switch (nombreOficio){
            case "Enfermería":
                oficioElegido = trabajosEnfermera;
                break;
            case "Plomería":
                oficioElegido = trabajosPlomeria;
                break;
            case "Mecanica":
                oficioElegido = trabajosMecanica;
                break;
            case "Albañilería":
                oficioElegido = trabajosAlbañileria;
                break;
            case "Niñera/o":
                oficioElegido = trabajosNiniera;
                break;
            case "Cuidador":
                oficioElegido = trabajosCuidador;
                break;
            case "Changarín":
                oficioElegido = trabajosChangarin;
                break;
        }

        tv_trabajos.setText("Trabajos propuestos de " + nombreOficio);
    }
}
