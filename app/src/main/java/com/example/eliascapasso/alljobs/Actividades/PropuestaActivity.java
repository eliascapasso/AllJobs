package com.example.eliascapasso.alljobs.Actividades;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
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
    private Button btnEnviarPropuesta;

    private TrabajosRepositorio trabajosRepositorio;
    private Trabajo trabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesta);

        inicializarAtributos();

        setSeekBar();
    }

    @SuppressLint("NewApi")
    private void setSeekBar() {
        txtPresupuesto.setText("$" + trabajo.getPrecioMin());

        //dar valor maximo y minimo a seekbar
        seekPresupuesto.setMin(trabajo.getPrecioMin());
        seekPresupuesto.setMax(trabajo.getPrecioMax());

        seekPresupuesto.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar,int i,boolean b)
            {
                txtPresupuesto.setText("$" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                //No hacer nada
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                //No hacer nada
            }
        });
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
        btnEnviarPropuesta = findViewById(R.id.btnEnviarPropuesta);

        txtTituloTrabajo.setText(trabajo.getTitulo());
        txtDescripcionTrabajo.setText(trabajo.getDescripcion());
    }
}
