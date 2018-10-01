package com.example.eliascapasso.alljobs.Actividades;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Adaptadores.OficioHolder;
import com.example.eliascapasso.alljobs.R;

public class FilaOficioActivity extends LinearLayout{
    public TextView tvTituloOficio;
    public ImageView ivImagenOficio;
    private OficioHolder oficioHolder;

    public FilaOficioActivity(Context context){
        super(context);
        inflate(context, R.layout.list_item_oficios, this);
    }

    public void createViews(){
        //Instanciamos los elementos de la vista
        oficioHolder = (OficioHolder) this.getTag();
        tvTituloOficio = oficioHolder.tvTituloOficio;
        ivImagenOficio = oficioHolder.ivImagenOficio;
    }
}
