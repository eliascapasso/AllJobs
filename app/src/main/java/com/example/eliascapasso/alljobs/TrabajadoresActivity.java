package com.example.eliascapasso.alljobs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TrabajadoresActivity extends AppCompatActivity {

    private ListView lv_trabajadores;
    private TextView tv_trabajadores;

    private ArrayList<Usuario> enfermeras = new ArrayList<Usuario>();
    private ArrayList<Usuario> plomeros = new ArrayList<Usuario>();
    private ArrayList<Usuario> mecanicos = new ArrayList<Usuario>();
    private ArrayList<Usuario> albaniles = new ArrayList<Usuario>();
    private ArrayList<Usuario> ninieros = new ArrayList<Usuario>();
    private ArrayList<Usuario> cuidadores = new ArrayList<Usuario>();
    private ArrayList<Usuario> changarines = new ArrayList<Usuario>();
    private ArrayList<Usuario> oficioElegido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajadores);

        tv_trabajadores = (TextView)findViewById(R.id.tv_trabajadores);

        inicializarTrabajadores();

        recibirDatos();

        lv_trabajadores = (ListView) findViewById(R.id.lv_trabajadores);

        lv_trabajadores.setAdapter(new AdaptadorTrabajadores(this, oficioElegido));
    }

    private void inicializarTrabajadores(){
        enfermeras.add(new Usuario("Maria Perez", R.drawable.enfermera1, "enfermera profesional"));
        enfermeras.add(new Usuario("Rosa Spinetta", R.drawable.enfermera2, "Licenciada en enfermería"));
        enfermeras.add(new Usuario("Mabel de Los Angeles", R.drawable.enfermera3, "me la rebusco"));

        plomeros.add(new Usuario("Ricardo Perez", R.drawable.plomero1, ""));
        plomeros.add(new Usuario("Roberto Spinetta", R.drawable.plomero2, ""));
        plomeros.add(new Usuario("Luciano Salas", R.drawable.plomero3, ""));

        mecanicos.add(new Usuario("Francisco Benitez", R.drawable.mecanico1, ""));
        mecanicos.add(new Usuario("Edgardo Stieben", R.drawable.mecanico2, ""));
        mecanicos.add(new Usuario("Agustin Perez", R.drawable.mecanico3, ""));

        albaniles.add(new Usuario("Mario Fernandez", R.drawable.albanil1, ""));
        albaniles.add(new Usuario("Tomas Lay", R.drawable.albanil2, ""));
        albaniles.add(new Usuario("Claudio Iglesias", R.drawable.albanil3, ""));

        ninieros.add(new Usuario("Luciana Perez", R.drawable.niniera1, ""));
        ninieros.add(new Usuario("Jesica Rodriguez", R.drawable.niniera2, ""));
        ninieros.add(new Usuario("Marta Sanchez", R.drawable.niniera3, ""));

        cuidadores.add(new Usuario("Luciana Rodriguez", R.drawable.cuidador1, ""));
        cuidadores.add(new Usuario("Jesica Perez", R.drawable.cuidador2, ""));
        cuidadores.add(new Usuario("Mario Gimenez", R.drawable.cuidador3, ""));

        changarines.add(new Usuario("Rodrigo Sanchez", R.drawable.changarin1, ""));
        changarines.add(new Usuario("Carlos Gonzalez", R.drawable.changarin2, ""));
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        String nombreOficio = extras.getString("nombreOficio");

        //inicializa todos los trabajos disponibles para el oficio elegido
        switch (nombreOficio){
            case "Enfermería":
                oficioElegido = enfermeras;
                break;
            case "Plomería":
                oficioElegido = plomeros;
                break;
            case "Mecánica":
                oficioElegido = mecanicos;
                break;
            case "Albañilería":
                oficioElegido = albaniles;
                break;
            case "Niñera/o":
                oficioElegido = ninieros;
                break;
            case "Cuidador":
                oficioElegido = cuidadores;
                break;
            case "Changarín":
                oficioElegido = changarines;
                break;

                default: oficioElegido = new ArrayList<>();
        }

        tv_trabajadores.setText("Lista de " + nombreOficio + "/s disponible/s");
    }
}
