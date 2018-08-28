package com.example.eliascapasso.alljobs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OficiosActivity extends AppCompatActivity {

    private ListView lv_oficios;

    private String oficios[] = {"Enfermería", "Plomería", "Mecánica", "Albañilería", "Niñera/o", "Cuidador", "Changarín"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficios);

        lv_oficios = (ListView) findViewById(R.id.lv_oficios);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_oficios, oficios);
        lv_oficios.setAdapter(adapter);

        final Intent menu = new Intent(this, Menu1Activity.class);

        lv_oficios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menu.putExtra("nombreOficio", oficios[position]);
                startActivity(menu);
            }
        });
    }
}
