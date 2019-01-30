package com.example.eliascapasso.alljobs.Fragmentos;


import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.eliascapasso.alljobs.DAO.TrabajoDAO;
import com.example.eliascapasso.alljobs.DAO.TrabajosRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;


public class MapFragment extends SupportMapFragment implements OnMapReadyCallback {

    private static final int UBICACION = 1;
    private static final int REQUEST_ACCESS_FINE_LOCATION = 1;
    private static final int HEATMAP = 4;
    private static String[] PERMISSIONS_MAPS = {Manifest.permission.ACCESS_FINE_LOCATION};
    private GoogleMap miMapa;
    private int tipoMapa=1;
    private TrabajosRepositorio trabajosRepositorio;
    private List<Trabajo> listaTrabajo;
    private Trabajo trabajo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        trabajosRepositorio = new TrabajosRepositorio(getContext());

        tipoMapa = 0;
        Bundle argumentos = getArguments();
        if(argumentos !=null) {
            tipoMapa = argumentos .getInt("tipo_mapa",0);
        }
        getMapAsync(this);
        return rootView;
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
        miMapa = googleMap;
        UiSettings settings = miMapa.getUiSettings();
        settings.setZoomControlsEnabled(true);


        // Enabling MyLocation Layer of Google Map
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
            try {
                miMapa.setMyLocationEnabled(true);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            verificarPermisoMapa(getActivity());
        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        miMapa.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        miMapa.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        tipoMapaSeleccion(tipoMapa);
    }


    private void tipoMapaSeleccion(int tipoMapa) {
        switch (tipoMapa) {

            case 1:
                Runnable hiloCargarMapa=(new Runnable() {
                    @Override
                    public void run() {
                        int idTrabajo = getArguments().getInt("idTrabajo");
                        trabajo = trabajosRepositorio.obtenerTrabajo(idTrabajo);
                        Message completeMessage = handler.obtainMessage(UBICACION);
                        completeMessage.sendToTarget();
                    }
                });
                Thread thread= new Thread(hiloCargarMapa);
                thread.start();
                break;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch ( requestCode ) {
            case REQUEST_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    if (ContextCompat.checkSelfPermission(getContext(),
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED )
                        miMapa.setMyLocationEnabled(true);
                }
                break;
            }
        }
    }

    public static void verificarPermisoMapa(FragmentActivity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_MAPS,
                    REQUEST_ACCESS_FINE_LOCATION
            );
        }
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
