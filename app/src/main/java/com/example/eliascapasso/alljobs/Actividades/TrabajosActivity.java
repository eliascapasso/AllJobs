package com.example.eliascapasso.alljobs.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Adaptadores.AdaptadorTrabajos;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
import com.example.eliascapasso.alljobs.DAO.OficiosRepositorio;
import com.example.eliascapasso.alljobs.DAO.TrabajosRepositorio;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class TrabajosActivity extends AppCompatActivity {

    private ListView lv_trabajos;
    private TextView tv_trabajos;
    private ImageView im_oficio;

    private TrabajosRepositorio trabajosRepositorio = new TrabajosRepositorio();
    private OficiosRepositorio oficiosRepositorio = new OficiosRepositorio();
    private ArrayList<Trabajo> listaTrabajosActivity = new ArrayList<Trabajo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajos);

        tv_trabajos = (TextView)findViewById(R.id.tv_tituloListaTrabajos);
        im_oficio = (ImageView)findViewById(R.id.imagenOficio);

        recibirDatos();

        lv_trabajos = (ListView) findViewById(R.id.lv_listaTrabajos);

        lv_trabajos.setAdapter(new AdaptadorTrabajos(this, listaTrabajosActivity));
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        int idOficio = extras.getInt("idOficio");

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
}
