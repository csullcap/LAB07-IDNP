package com.lab07.Lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.lab07.Lab07.adaptadores.ListaActividadesAdapter;
import com.lab07.Lab07.db.DbActividades;
import com.lab07.Lab07.entidades.Actividad;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VerActividades extends AppCompatActivity {

    RecyclerView Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_actividades);
        Lista = findViewById(R.id.lista);
        Lista.setLayoutManager(new LinearLayoutManager(this));
        DbActividades dbActividades = new DbActividades(VerActividades.this);
        ListaActividadesAdapter adapter = new ListaActividadesAdapter(dbActividades.viewActividades());
        Lista.setAdapter(adapter);

    }
}