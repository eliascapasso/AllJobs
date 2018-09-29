package com.example.eliascapasso.alljobs.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.eliascapasso.alljobs.R;

public class AdaptadorTrabajos extends BaseAdapter {
    private static LayoutInflater inflater = null;

    Context contexto;
    String[] trabajos;

    public AdaptadorTrabajos(Context contexto, String[] trabajos) {
        this.contexto = contexto;
        this.trabajos = trabajos;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.list_item_trabajos, null);
        TextView nombreTrabajo = (TextView)vista.findViewById(R.id.tv_trabajo);
        nombreTrabajo.setText(trabajos[i]);

        return vista;
    }

    @Override
    public int getCount() {
        return trabajos.length;
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

