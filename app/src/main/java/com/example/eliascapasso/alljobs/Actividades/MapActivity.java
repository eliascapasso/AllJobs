package com.example.eliascapasso.alljobs.Actividades;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eliascapasso.alljobs.Fragmentos.MapFragment;
import com.example.eliascapasso.alljobs.R;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        int idTrabajo = extras.getInt("idTrabajo");

        setContentView(R.layout.activity_map);
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        MapFragment mapFragment = new MapFragment();

        Bundle args = new Bundle();

        // setear los parametros tipo_mapa y idReclamo en el Bundle args
        args.putInt("tipo_mapa", 3);
        args.putInt("idTrabajo", idTrabajo);
        mapFragment.setArguments(args);
        fragmentTransaction.replace(R.id.contenidoMapa, mapFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
