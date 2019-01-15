package com.example.eliascapasso.alljobs.Actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.DAO.TrabajosRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
import com.example.eliascapasso.alljobs.R;

public class PropuestaActivity extends AppCompatActivity {
    private TextView txtTituloTrabajo;
    private TextView txtDescripcionTrabajo;
    private EditText etPropuesta;
    private SeekBar seekPresupuesto;
    private TextView txtPresupuesto;

    private TrabajosRepositorio trabajosRepositorio;
    private Trabajo trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta);

        inicializarAtributos();
    }

    private void inicializarAtributos() {
        trabajosRepositorio = new TrabajosRepositorio();

        Bundle extras = getIntent().getExtras();
        int idTrabajo = extras.getInt("idTrabajo");
        trabajo = trabajosRepositorio.obtenerTrabajo(idTrabajo);

        txtTituloTrabajo = findViewById(R.id.txtTituloTrabajo);
        txtDescripcionTrabajo = findViewById(R.id.txtDescirpcionTrabajo);
        etPropuesta = findViewById(R.id.txtPropuesta);
        seekPresupuesto = findViewById(R.id.seekPresupuesto);
        txtPresupuesto = findViewById(R.id.txtPresupuesto);

        txtTituloTrabajo.setText(trabajo.getTitulo());
        txtDescripcionTrabajo.setText(trabajo.getDescripcion());
    }
}
