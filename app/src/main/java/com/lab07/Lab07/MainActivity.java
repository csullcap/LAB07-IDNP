package com.lab07.Lab07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.lab07.Lab07.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button agregar,ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregar = (Button) findViewById(R.id.agregar);
        ver = (Button) findViewById(R.id.ver);
        final DbHelper dbHelper = new DbHelper( MainActivity.this);
    }

     public void onClick(View view){
        Intent intent=null;
        switch (view.getId()){
            case R.id.agregar:
                intent = new Intent(this,AgregarActividad.class);
                break;

            case R.id.ver:
                intent = new Intent(this,VerActividades.class);
                break;
        }
        startActivity(intent);
     }
}