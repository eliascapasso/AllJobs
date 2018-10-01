package com.example.eliascapasso.alljobs.Actividades;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Adaptadores.TrabajadorHolder;
import com.example.eliascapasso.alljobs.R;

public class FilaTrabajadorActivity extends LinearLayout {
    public TextView tvNombreTrabajador;
    public TextView tvTituloEspecialidad;
    public ImageView ivFotoTrabajador;
    private TrabajadorHolder trabajadorHolder;

    public FilaTrabajadorActivity(Context context){
        super(context);
        inflate(context, R.layout.list_item_trabajadores, this);
    }

    public void createViews() {
        //Instanciamos los elementos de la vista
        trabajadorHolder = (TrabajadorHolder) this.getTag();
        tvNombreTrabajador = trabajadorHolder.tvNombreTrabajador;
        ivFotoTrabajador = trabajadorHolder.ivFotoTrabajador;
        tvTituloEspecialidad = trabajadorHolder.tvTituloEspecialidad;
    }
}
