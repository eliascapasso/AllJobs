package com.example.eliascapasso.alljobs.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Actividades.FilaTrabajoActivity;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
import com.example.eliascapasso.alljobs.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AdaptadorTrabajos extends BaseAdapter {
    private Context contexto;
    private ArrayList<Trabajo> listaTrabajos;

    public AdaptadorTrabajos(Context contexto, ArrayList<Trabajo> listaTrabajos) {
        this.contexto = contexto;
        this.listaTrabajos = listaTrabajos;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        TrabajoHolder trabajoHolder;
        //Convertimos la vista por defecto en el tipo de nuestra vista personalizada
        FilaTrabajoActivity view = (FilaTrabajoActivity) convertView;
        if(view == null){
            //Instanciamos la vista y el PedidoHolder
            trabajoHolder = new TrabajoHolder();
            view = new FilaTrabajoActivity(contexto);
            //Instanciamos los recursos
            trabajoHolder.tvTituloTrabajo = (TextView)view.findViewById(R.id.tv_tituloTrabajo);
            trabajoHolder.tvDescripcion = (TextView) view.findViewById(R.id.tv_descripcionTrabajo);
            trabajoHolder.tvFechaRealizacion = (TextView)view.findViewById(R.id.tv_fechaRealizacion);
            //asignamos el viewHolder a la vista
            view.setTag(trabajoHolder);
            //Al cambiar el codigo, debemos llamar nosotros al metodo createViews() de la vista
            view.createViews();
        }else{
            //Si la vista ya existe, recuperamos el viewHolder asociado
            trabajoHolder = (TrabajoHolder) view.getTag();
        }

        trabajoHolder.tvTituloTrabajo.setText(listaTrabajos.get(i).getTitulo());
        trabajoHolder.tvDescripcion.setText(listaTrabajos.get(i).getDescripcion());
        //trabajoHolder.tvFechaRealizacion.setText(new SimpleDateFormat("dd-MM-yyyy").format(listaTrabajos.get(i).getFechaRealizacion())); //TODO: Revisar

        return view;
    }

    @Override
    public int getCount() {
        return listaTrabajos.size();
    }

    @Override
    public Trabajo getItem(int i) {
        return listaTrabajos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getIdTrabajo();
    }
}

