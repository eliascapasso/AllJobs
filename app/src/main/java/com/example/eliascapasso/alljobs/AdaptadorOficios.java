package com.example.eliascapasso.alljobs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorOficios extends BaseAdapter {
    private static LayoutInflater inflater = null;

    Context contexto;
    String[] oficios;
    int[] imagenesOficios;

    public AdaptadorOficios(Context contexto, String[] oficios, int[] imagenesOficios) {
        this.contexto = contexto;
        this.oficios = oficios;
        this.imagenesOficios = imagenesOficios;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.list_item_oficios, null);
        TextView nombreOficio = (TextView)vista.findViewById(R.id.tv_nombreOficio);
        ImageView imagenOficio = (ImageView)vista.findViewById(R.id.iv_imagenOficio);
        nombreOficio.setText(oficios[i]);
        imagenOficio.setImageResource(imagenesOficios[i]);

        return vista;
    }

    @Override
    public int getCount() {
        return imagenesOficios.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
