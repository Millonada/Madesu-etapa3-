package com.example.evidenciafinal;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*
* Created by Angel Millan Escorcia
* */
public class AdminSQLiteOpenHelper extends  SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table prendas (id int PRIMARY KEY AUTOINCREMENT,titulo,costo,precio,talla,color,img)");
        BaseDeDatos.execSQL("create table ventas (id int PRIMARY KEY,titulo,precio)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
