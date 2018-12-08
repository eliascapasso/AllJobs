package com.example.eliascapasso.alljobs.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Actividades.FilaTrabajadorActivity;
import com.example.eliascapasso.alljobs.Modelo.Trabajador;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class AdaptadorTrabajadores extends BaseAdapter {
    Context contexto;
    ArrayList<Trabajador> listaTrabajadores;

    public AdaptadorTrabajadores(Context contexto, ArrayList<Trabajador> listaTrabajadores) {
        this.contexto = contexto;
        this.listaTrabajadores = listaTrabajadores;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        TrabajadorHolder trabajadorHolder;
        //Convertimos la vista por defecto en el tipo de nuestra vista personalizada
        FilaTrabajadorActivity view = (FilaTrabajadorActivity) convertView;
        if(view == null){
            //Instanciamos la vista y el PedidoHolder
            trabajadorHolder = new TrabajadorHolder();
            view = new FilaTrabajadorActivity(contexto);
            //Instanciamos los recursos
            trabajadorHolder.tvNombreTrabajador = (TextView)view.findViewById(R.id.tv_nombreTrabajador);
            trabajadorHolder.ivFotoTrabajador = (ImageView) view.findViewById(R.id.iv_fotoTrabajador);
            trabajadorHolder.tvTituloEspecialidad = (TextView)view.findViewById(R.id.tv_tituloEspecualidad);
            //asignamos el viewHolder a la vista
            view.setTag(trabajadorHolder);
            //Al cambiar el codigo, debemos llamar nosotros al metodo createViews() de la vista
            view.createViews();
        }else{
            //Si la vista ya existe, recuperamos el viewHolder asociado
            trabajadorHolder = (TrabajadorHolder) view.getTag();
        }

        trabajadorHolder.tvNombreTrabajador.setText(listaTrabajadores.get(i).getNombreApellido());
        trabajadorHolder.tvTituloEspecialidad.setText(listaTrabajadores.get(i).getTituloEspecialidad());
        trabajadorHolder.ivFotoTrabajador.setImageResource(listaTrabajadores.get(i).getFoto());

        return view;
    }

    @Override
    public int getCount() {
        return listaTrabajadores.size();
    }

    @Override
    public Trabajador getItem(int i) {
        return listaTrabajadores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
