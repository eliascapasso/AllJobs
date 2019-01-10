package com.example.eliascapasso.alljobs.Actividades;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.DAO.UsuarioRepositorio;
import com.example.eliascapasso.alljobs.Fragmentos.ModificarPerfilFragment;
import com.example.eliascapasso.alljobs.Fragmentos.OficiosFragment;
import com.example.eliascapasso.alljobs.Modelo.Usuario;
import com.example.eliascapasso.alljobs.R;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private TextView nombreApellidoUsuario;
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        //Handle when activity is recreated like on orientation Change
        shouldDisplayHomeUp();

        usuarioRepositorio = new UsuarioRepositorio(getApplicationContext());

        inicializarAtributos();

        //Inicia primero el fragmento con los oficios
        setFragment(1);

    }

    private void inicializarAtributos() {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navView = (NavigationView)findViewById(R.id.navview);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (navView != null) {
            setupNavigationDrawerContent(navView);
        }

        setupNavigationDrawerContent(navView);

        nombreApellidoUsuario = (TextView) findViewById(R.id.txtNombreApellidoUsuario);
    }

    private void setearNombreApellidoNavDrawer() {
        String email = getFromSharedPreferences("email");

        for(Usuario usuario: usuarioRepositorio.listarUsuarios()){
            if(usuario.getEmail().equals(email)){
                //nombreApellidoUsuario.setText(usuario.getApellido() + " " + usuario.getNombre());
            }
        }
    }

    private String getFromSharedPreferences(String clave) {
        SharedPreferences sharedPreferences = getSharedPreferences("login_preferences", Context.MODE_PRIVATE);

        return sharedPreferences.getString(clave, "");
    }

    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canback = getSupportFragmentManager().getBackStackEntryCount()>0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        setearNombreApellidoNavDrawer();

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.optMiPerfil:
                                menuItem.setChecked(true);
                                setFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.optOficios:
                                menuItem.setChecked(true);
                                setFragment(1);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.optCerrarSesion:
                                menuItem.setChecked(true);
                                setFragment(2);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                        }
                        return true;
                    }
                });
    }

    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ModificarPerfilFragment modificarPerfilFragment = new ModificarPerfilFragment();
                fragmentTransaction.replace(R.id.contenido, modificarPerfilFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                OficiosFragment oficiosFragment = new OficiosFragment();
                fragmentTransaction.replace(R.id.contenido, oficiosFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                /*fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                StarredFragment starredFragment = new StarredFragment();
                fragmentTransaction.replace(R.id.fragment, starredFragment);
                fragmentTransaction.commit();*/
                break;
        }
    }
}
