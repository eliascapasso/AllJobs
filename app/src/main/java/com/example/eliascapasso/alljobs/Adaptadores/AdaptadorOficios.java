package com.example.eliascapasso.alljobs.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Actividades.FilaOficioActivity;
import com.example.eliascapasso.alljobs.Modelo.Oficio;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class AdaptadorOficios extends BaseAdapter {
    private Context contexto;
    private ArrayList<Oficio> listaOficios;

    public AdaptadorOficios(Context contexto, ArrayList<Oficio> listaOficios) {
        this.contexto = contexto;
        this.listaOficios = listaOficios;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        OficioHolder oficioHolder;
        //Convertimos la vista por defecto en el tipo de nuestra vista personalizada
        FilaOficioActivity view = (FilaOficioActivity) convertView;
        if(view == null){
            //Instanciamos la vista y el PedidoHolder
            oficioHolder = new OficioHolder();
            view = new FilaOficioActivity(contexto);
            //Instanciamos los recursos
            oficioHolder.tvTituloOficio = (TextView)view.findViewById(R.id.tv_nombreOficio);
            oficioHolder.ivImagenOficio = (ImageView) view.findViewById(R.id.iv_imagenOficio);
            //asignamos el viewHolder a la vista
            view.setTag(oficioHolder);
            //Al cambiar el codigo, debemos llamar nosotros al metodo createViews() de la vista
            view.createViews();
        }else{
            //Si la vista ya existe, recuperamos el viewHolder asociado
            oficioHolder = (OficioHolder) view.getTag();
        }

        oficioHolder.tvTituloOficio.setText(listaOficios.get(i).getNombreOficio());
        oficioHolder.ivImagenOficio.setImageResource(listaOficios.get(i).getImagenOficio());

        return view;
    }

    @Override
    public int getCount() {
        return listaOficios.size();
    }

    @Override
    public Oficio getItem(int i) {
        return listaOficios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }
}
