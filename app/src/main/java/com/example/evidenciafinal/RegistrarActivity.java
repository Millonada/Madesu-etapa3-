package com.example.evidenciafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {
    private EditText id,titulo,costo,precio,talla,color,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        id=(EditText)findViewById(R.id.txtId);
        titulo=(EditText)findViewById(R.id.txtTitulo);
        costo=(EditText)findViewById(R.id.txtCosto);

        precio=(EditText)findViewById(R.id.txtPrecio);
        talla=(EditText)findViewById(R.id.txtTalla);
        color=(EditText)findViewById(R.id.txtColor);
    }
    public void create(View view){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"baratero",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
        String id = this.id.getText().toString();
        String titulo= this.titulo.getText().toString();
        String costo= this.costo.getText().toString();

        String precio= this.precio.getText().toString();
        String talla= this.talla.getText().toString();

        String color= this.color.getText().toString();




        if (!id.isEmpty() && !titulo.isEmpty() && !costo.isEmpty() && !precio.isEmpty() && !talla.isEmpty() && !color.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("id",id);
            registro.put("titulo",titulo);
            registro.put("costo",costo);
            registro.put("precio", precio);
            registro.put("talla",talla);
            registro.put("color",color);


            BaseDeDatos.insert("prendas",null,registro);
            BaseDeDatos.close();
            this.id.setText("");
            this.titulo.setText("");
            this.costo.setText("");
            this.precio.setText("");
            this.color.setText("");
            this.talla.setText("");

            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"OOps Te faltan datos por llenar",Toast.LENGTH_SHORT).show();
        }
    }

    public void search(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"baratero",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String titulo = this.titulo.getText().toString();



        if (!titulo.isEmpty()){

            Cursor fila=BaseDeDatos.rawQuery
                    ("select * from prendas where titulo= "+ titulo,null);

            if (fila.moveToFirst()){
                this.titulo.setText(fila.getString(0));
                this.costo.setText(fila.getString(1));
                this.precio.setText(fila.getString(2));
                this.color.setText(fila.getString(3));
                this.talla.setText(fila.getString(4));

                BaseDeDatos.close();

            }else{

                Toast.makeText(this,"La prenda no existe",Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }else{
            Toast.makeText(this,"Debes introducir el nombre de la prenda a buscar",Toast.LENGTH_SHORT).show();
        }


    }
    public void delete(View view){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"baratero",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String titulo = this.titulo.getText().toString();

        if (!titulo.isEmpty()){

            int cantidad=BaseDeDatos.delete("prendas","titulo="+titulo,null);
            this.titulo.setText("");
            this.costo.setText("");
            this.precio.setText("");
            this.color.setText("");
            this.talla.setText("");


            if (cantidad==1){
                Toast.makeText(this,"El articulo fue elminado con exito",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"No existe tal articulo",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Introduce el nombre de la prenda",Toast.LENGTH_SHORT).show();

        }
    }

    public void edit(View view){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"baratero",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String titulo= this.titulo.getText().toString();
        String costo= this.costo.getText().toString();

        String precio= this.precio.getText().toString();
        String talla= this.talla.getText().toString();

        String color= this.color.getText().toString();

        if (!titulo.isEmpty() && costo.isEmpty() && precio.isEmpty() && talla.isEmpty() && color.isEmpty()){

            ContentValues registro= new ContentValues();
            registro.put("titulo",titulo);
            registro.put("costo",costo);
            registro.put("precio", precio);
            registro.put("talla",talla);
            registro.put("color",color);


            int cantidad= BaseDeDatos.update("prendas",registro, "titulo="+titulo,null);
            BaseDeDatos.close();
            if (cantidad==1){
                Toast.makeText(this,"El articulo fue modificado con exito",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"No existe tal articulo",Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this,"OOps Te faltan datos por llenar",Toast.LENGTH_SHORT).show();
        }

    }

    public void cancelar(View view){
        this.id.setText("");
        this.titulo.setText("");
        this.costo.setText("");
        this.precio.setText("");
        this.color.setText("");
        this.talla.setText("");
    }
}
