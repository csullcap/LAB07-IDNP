package com.lab07.Lab07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.lab07.Lab07.db.DbActividades;

public class AgregarActividad extends AppCompatActivity {

    Button registrar;
    EditText usuario,latitud,longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);
        registrar=findViewById(R.id.registrar);
        usuario = findViewById(R.id.usuario);
        latitud = findViewById(R.id.latitud);
        longitud= findViewById(R.id.longitud);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbActividades dbActividades = new DbActividades(AgregarActividad.this);
                long id = dbActividades.AddActividad(usuario.getText().toString(),
                                                Float.parseFloat(latitud.getText().toString()),
                                                Float.parseFloat(longitud.getText().toString()));
                if(id>0){
                    Toast.makeText(AgregarActividad.this,"ACTIVIDAD REGISTRADA",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AgregarActividad.this,"ERROR AL HACER EL REGISTRO",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(AgregarActividad.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}