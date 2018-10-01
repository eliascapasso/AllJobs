package com.example.eliascapasso.alljobs.Actividades;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.eliascapasso.alljobs.R;
import com.example.eliascapasso.alljobs.Adaptadores.TrabajoHolder;

public class FilaTrabajoActivity extends LinearLayout {
    public TextView tvTituloTrabajo;
    public TextView tvDescripcion;
    public TextView tvFechaRealizacion;
    private TrabajoHolder trabajoHolder;

    public FilaTrabajoActivity(Context context){
        super(context);
        inflate(context, R.layout.list_item_trabajos, this);
    }

    public void createViews() {
        //Instanciamos los elementos de la vista
        trabajoHolder = (TrabajoHolder) this.getTag();
        tvTituloTrabajo = trabajoHolder.tvTituloTrabajo;
        tvDescripcion = trabajoHolder.tvDescripcion;
        tvFechaRealizacion = trabajoHolder.tvFechaRealizacion;
    }
}
