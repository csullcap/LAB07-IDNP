package com.lab07.Lab07.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "ALERTA_MUJER_DATABASE";
    public static final String TABLE_NOMBRE = "HISTORIAL_DE_ACTIVIDADES";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NOMBRE + " ( " +
                    " ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " USUARIO TEXT NOT NULL,"+
                    " FECHA DATETIME NOT NULL,"+
                    " LATITUD FLOAT NOT NULL,"+
                    " LONGITUD FLOAT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NOMBRE);
        onCreate(db);
    }
}
