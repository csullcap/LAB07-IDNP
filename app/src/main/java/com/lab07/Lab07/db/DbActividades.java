package com.lab07.Lab07.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.lab07.Lab07.entidades.Actividad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DbActividades extends DbHelper{
    Context context;
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public DbActividades(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long AddActividad(String usuario, float latitud , float longitud){

        long id = 0;

        try {

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("USUARIO", usuario);
            values.put("FECHA", getDateTime());
            values.put("LATITUD", latitud);
            values.put("LONGITUD", longitud);

            id = db.insert(TABLE_NOMBRE,null,values);
        }
        catch (Exception e){
            e.toString();
        }

        return id;
    }

    public ArrayList<Actividad> viewActividades(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Actividad> listaActividades=  new ArrayList<>();
        Actividad actividad= null;
        Cursor cursor = null;

        cursor = db.rawQuery("SELECT * FROM "+TABLE_NOMBRE,null);
        if(cursor.moveToFirst()){
            do{
                actividad = new Actividad();
                actividad.setId(cursor.getInt(0));
                actividad.setUsuario(cursor.getString(1));
                actividad.setFecha(cursor.getString(2));
                actividad.setLatitud(cursor.getFloat(3));
                actividad.setLongitud(cursor.getFloat(4));
                listaActividades.add(actividad);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return listaActividades;

    }

}
