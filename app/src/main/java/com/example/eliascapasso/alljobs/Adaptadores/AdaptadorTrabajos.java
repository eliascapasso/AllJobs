package com.example.eliascapasso.alljobs.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Actividades.FilaTrabajoActivity;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;
import com.example.eliascapasso.alljobs.R;

import java.security.cert.Extension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AdaptadorTrabajos extends BaseAdapter {
    private Context contexto;
    private ArrayList<Trabajo> listaTrabajos;

    public AdaptadorTrabajos(Context contexto, ArrayList<Trabajo> listaTrabajos) {
        this.contexto = contexto;
        this.listaTrabajos = listaTrabajos;
    }

    private OnMapaListener listenerOnMapa;

    public interface OnMapaListener {
        public void mostrarMapa(int id);
    }

    public void setOnMapaListener(OnMapaListener listener){
        listenerOnMapa = listener;
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
            trabajoHolder.tvPrecioMin = (TextView) view.findViewById(R.id.txtPrecioMin);
            trabajoHolder.tvPrecioMax = (TextView) view.findViewById(R.id.txtPrecioMax);
            trabajoHolder.tvFechaRealizacion = (TextView)view.findViewById(R.id.tv_fechaRealizacion);
            trabajoHolder.btnMapa = (Button) view.findViewById(R.id.btn_mapa);

            //asignamos el viewHolder a la vista
            view.setTag(trabajoHolder);
            //Al cambiar el codigo, debemos llamar nosotros al metodo createViews() de la vista
            view.createViews();
        }else{
            //Si la vista ya existe, recuperamos el viewHolder asociado
            trabajoHolder = (TrabajoHolder) view.getTag();
        }

        trabajoHolder.tvTituloTrabajo.setText(listaTrabajos.get(i).getTitulo());
        trabajoHolder.tvPrecioMin.setText("$" + Integer.toString(listaTrabajos.get(i).getPrecioMin()));
        trabajoHolder.tvPrecioMax.setText("$" + Integer.toString(listaTrabajos.get(i).getPrecioMax()));
        trabajoHolder.tvFechaRealizacion.setText(listaTrabajos.get(i).getFechaRealizacion());

        Trabajo aux = getItem(i);
        trabajoHolder.btnMapa.setTag(aux.getIdTrabajo());

        trabajoHolder.btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.valueOf(view.getTag().toString());
                listenerOnMapa.mostrarMapa(id);
            }
        });

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

