package com.example.eliascapasso.alljobs.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.Clases.Oficio;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorOficios extends BaseAdapter {
    private static LayoutInflater inflater = null;

    private Context contexto;
    private ArrayList<Oficio> listaOficios;

    public AdaptadorOficios(Context contexto, ArrayList<Oficio> listaOficios) {
        this.contexto = contexto;
        this.listaOficios = listaOficios;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.list_item_oficios, null);
        TextView nombreOficio = (TextView)vista.findViewById(R.id.tv_nombreOficio);
        ImageView imagenOficio = (ImageView)vista.findViewById(R.id.iv_imagenOficio);

        nombreOficio.setText(listaOficios.get(i).getNombreOficio());
        imagenOficio.setImageResource(listaOficios.get(i).getImagenOficio());

        return vista;
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
