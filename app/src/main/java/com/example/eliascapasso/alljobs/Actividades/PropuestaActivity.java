package com.example.eliascapasso.alljobs.Actividades;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.DAO.TrabajosRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
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

    private void createNotificationChannel() {
        // Crear el canal de notificaciones pero solo para API 26 io superior
        // dado que NotificationChannel es una clase nueva que no está incluida
        // en las librerías de soporte qeu brindan compatibilidad hacía atrás
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Estado propuesta: ";
            String description = "Precio propuesta: ";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CANAL01", name, importance);
            channel.setDescription(description);
            // Registrar el canal en el sistema
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
