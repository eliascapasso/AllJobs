package com.example.eliascapasso.alljobs.Actividades;


import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;



import com.example.eliascapasso.alljobs.Adaptadores.AdaptadorTrabajos;
import com.example.eliascapasso.alljobs.DAO.TrabajoDAO;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
import com.example.eliascapasso.alljobs.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,  AdaptadorTrabajos.OnMapaListener {

    private static final int UBICACION = 1;


    private GoogleMap miMapa;
    private int tipoMapa=1;
    private TrabajoDAO trabajoDAO;
    private List<Trabajo> listaTrabajo;
    private Trabajo trabajo;


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    @Override
    public void mostrarMapa(final int id) {
       final Bundle args = new Bundle();
       args.putInt("tipo_mapa_", 1);
       args.putInt("idTrabajo", id);


        Runnable hiloUbicacion=(new Runnable() {
            @Override
            public void run() {
                trabajo=trabajoDAO.obtenerTrabajo(args.getInt("idTrabajo", id));
                Message completeMessage= handler.obtainMessage(UBICACION);
                completeMessage.sendToTarget();
            }
        });
        Thread thread2= new Thread(hiloUbicacion);
        thread2.start();


        //onMapReady(mMap);

    }


    Handler handler= new Handler() {
        @Override
        public void handleMessage(Message mensaje) {
            CameraUpdate cu;
            LatLng latLng;
            switch (mensaje.what){
                case UBICACION:
                    latLng= new LatLng(trabajo.getLatitud(), trabajo.getLongitud());
                    miMapa.addMarker(new MarkerOptions().position(latLng));
                    Circle circulo= miMapa.addCircle(new CircleOptions()
                            .center(latLng)
                            .radius(500)
                            .strokeColor(Color.RED)
                            .fillColor(0x220000FF)
                            .strokeWidth(5));
                    cu= CameraUpdateFactory.newLatLngZoom(latLng, 15.0f);
                    miMapa.moveCamera(cu);
                    break;
            }

        }
    };
}
