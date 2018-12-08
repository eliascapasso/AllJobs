package com.example.eliascapasso.alljobs.Actividades;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.eliascapasso.alljobs.Adaptadores.AdaptadorOficios;
import com.example.eliascapasso.alljobs.Modelo.Oficio;
import com.example.eliascapasso.alljobs.DAO.OficiosRepositorio;
import com.example.eliascapasso.alljobs.R;
import java.util.ArrayList;

public class OficiosActivity extends AppCompatActivity {

    private ListView lv_oficios;
    private ArrayList<Oficio> listaOficios;
    private OficiosRepositorio oficiosRepositorio;
    private DrawerLayout drawerLayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficios);

        inicializarAtributos();

        usaNavView();

        eligeOficio();
    }

    private void usaNavView() {
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.optMiCuenta:
                                //TODO: Implementar
                                break;
                            case R.id.optCerrarSesion:
                                //TODO: Implementar
                                break;
                        }

                        return true;
                    }
                });
    }


    private void inicializarAtributos(){
        oficiosRepositorio = new OficiosRepositorio();
        listaOficios = oficiosRepositorio.getListaOficios();

        lv_oficios = (ListView) findViewById(R.id.lv_oficios);
        lv_oficios.setAdapter(new AdaptadorOficios(this, listaOficios));

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navView = (NavigationView)findViewById(R.id.navview);
    }

    private void eligeOficio(){
        final Intent menu = new Intent(this, Menu1Activity.class);

        lv_oficios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                menu.putExtra("idOficio", oficiosRepositorio.getListaOficios().get(position).getId());
                startActivity(menu);
            }
        });
    }
}
