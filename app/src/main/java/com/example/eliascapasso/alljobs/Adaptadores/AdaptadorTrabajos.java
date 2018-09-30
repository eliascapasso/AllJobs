package com.example.eliascapasso.alljobs.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Clases.Trabajo;
import com.example.eliascapasso.alljobs.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AdaptadorTrabajos extends BaseAdapter {
    private static LayoutInflater inflater = null;

    private Context contexto;
    private ArrayList<Trabajo> listaTrabajos;

    public AdaptadorTrabajos(Context contexto, ArrayList<Trabajo> listaTrabajos) {
        this.contexto = contexto;
        this.listaTrabajos = listaTrabajos;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.list_item_trabajos, null);

        TextView tituloTrabajo = (TextView)vista.findViewById(R.id.tv_tituloTrabajo);
        TextView descripcionTrabajo = (TextView)vista.findViewById(R.id.tv_descripcionTrabajo);
        TextView fechaRealizacion = (TextView)vista.findViewById(R.id.tv_fechaRealizacion);

        tituloTrabajo.setText(listaTrabajos.get(i).getTitulo());
        descripcionTrabajo.setText(listaTrabajos.get(i).getDescripcion());
        fechaRealizacion.setText(new SimpleDateFormat("dd-MM-yyyy").format(listaTrabajos.get(i).getFechaRealizacion()));

        return vista;
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

