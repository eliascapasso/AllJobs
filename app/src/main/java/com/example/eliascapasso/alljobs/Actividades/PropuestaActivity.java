package com.example.eliascapasso.alljobs.Actividades;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.DAO.TrabajosRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
import com.example.eliascapasso.alljobs.PropuestaReceiver;
import com.example.eliascapasso.alljobs.R;

public class PropuestaActivity extends AppCompatActivity {
    private TextView txtTituloTrabajo;
    private TextView txtDescripcionTrabajo;
    private EditText etPropuesta;
    private EditText etPrecio;
    private TextView txtRangoPrecio;
    private Button btnEnviarPropuesta;

    private TrabajosRepositorio trabajosRepositorio;
    private Trabajo trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta);

        inicializarAtributos();

        btnEnviarPropuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarPrecio()){
                    //crea la notificación
                    Log.d("APP_LAB02", "Pedido realizado: " + trabajo.getTitulo());

                    gestionTrabajo();

                    Toast.makeText(getApplicationContext(), "Propuesta enviada con éxito", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Precio inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean validarPrecio(){
        if(Integer.parseInt(etPrecio.getText().toString()) >= trabajo.getPrecioMin()
                && Integer.parseInt(etPrecio.getText().toString()) <= trabajo.getPrecioMax()){
            return true;
        }
        else{
            return false;
        }
    }

    private void inicializarAtributos() {
        trabajosRepositorio = new TrabajosRepositorio();

        Bundle extras = getIntent().getExtras();
        int idTrabajo = extras.getInt("idTrabajo");
        trabajo = trabajosRepositorio.obtenerTrabajo(idTrabajo);

        txtTituloTrabajo = findViewById(R.id.txtTituloTrabajo);
        txtDescripcionTrabajo = findViewById(R.id.txtDescirpcionTrabajo);
        etPropuesta = findViewById(R.id.etPropuesta);
        etPrecio = findViewById(R.id.etPrecio);
        txtRangoPrecio = findViewById(R.id.txtRangoPrecio);
        btnEnviarPropuesta = findViewById(R.id.btnEnviarPropuesta);

        txtTituloTrabajo.setText(trabajo.getTitulo());
        txtRangoPrecio.setText("Rango: $" + trabajo.getPrecioMin() + " ; $" + trabajo.getPrecioMax());
        txtDescripcionTrabajo.setText(trabajo.getDescripcion());
    }

    private void gestionTrabajo(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Aceptar el pedido si el estado actual del trabajo es LISTO
                if(trabajo.getEstado().equals(Trabajo.Estado.LISTO)){
                    trabajo.setEstado(Trabajo.Estado.ACEPTADO);

                    //Se reinicia el estado cada vez que inicia la app
                    //trabajosRepositorio.modificarTrabajo(trabajo);

                    //envia el broadcastreciver
                    Intent intent = new Intent(PropuestaActivity.this, PropuestaReceiver.class);
                    intent.putExtra("idTrabajo",trabajo.getIdTrabajo());
                    intent.setAction(PropuestaReceiver.ESTADO_ACEPTADO);
                    sendBroadcast(intent);
                }
                else if(trabajo.getEstado().equals(Trabajo.Estado.ACEPTADO)){
                    Toast.makeText(getApplicationContext(), "TRABAJO RECHAZADO", Toast.LENGTH_SHORT).show();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        };
        Thread unHilo = new Thread(r);
        unHilo.start();

    }
}
