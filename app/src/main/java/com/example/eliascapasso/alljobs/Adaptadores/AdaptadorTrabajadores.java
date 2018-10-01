package com.example.eliascapasso.alljobs.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.eliascapasso.alljobs.Clases.Trabajador;
import com.example.eliascapasso.alljobs.R;

import java.util.ArrayList;

public class AdaptadorTrabajadores extends BaseAdapter {
    private static LayoutInflater inflater = null;

    Context contexto;
    ArrayList<Trabajador> listaTrabajadores;

    public AdaptadorTrabajadores(Context contexto, ArrayList<Trabajador> listaTrabajadores) {
        this.contexto = contexto;
        this.listaTrabajadores = listaTrabajadores;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {





        final View vista = inflater.inflate(R.layout.list_item_trabajadores, null);

        TextView nombreTrabajador = (TextView)vista.findViewById(R.id.tv_nombreTrabajador);
        ImageView fotoTrabajador = (ImageView)vista.findViewById(R.id.iv_fotoTrabajador);
        nombreTrabajador.setText(listaTrabajadores.get(i).getNombreApellido());
        fotoTrabajador.setImageResource(listaTrabajadores.get(i).getFoto());

        return vista;
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
