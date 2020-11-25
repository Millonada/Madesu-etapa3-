package com.example.evidenciafinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import android.widget.Toast;

import com.example.evidenciafinal.fragments.CarritoFragmen;
import com.example.evidenciafinal.fragments.DeudaFragment;
import com.example.evidenciafinal.fragments.ListaFragment;
import com.example.evidenciafinal.fragments.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity {
    private EditText buscador,ticket;


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new CarritoFragmen());
        mMainNav = (BottomNavigationView)findViewById(R.id.bottomNavigation);

        mMainNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        Fragment fragment =null;

                        switch (menuItem.getItemId()){
                            case R.id.user:
                                replaceFragment(new UserFragment());

                            break;

                            case R.id.deuda:
                                replaceFragment(new DeudaFragment());
                                break;

                            case R.id.carrito:
                                replaceFragment(new CarritoFragmen());
                                break;

                            case R.id.lista:
                                replaceFragment(new ListaFragment());
                                break;
                            case R.id.money:
                                replaceFragment(new DineroFragment());
                                break;


                        }

                        return true;
                    }
                }
        );



        //Button create=(Button)findViewById(R.id.agregar);
        //buscador=(EditText) findViewById(R.id.txtBuscar);
        //ticket=(EditText) findViewById(R.id.txtTicket);



    }
    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void create(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"baratero",null,1);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String busqueda=this.buscador.getText().toString();

        if (!busqueda.isEmpty()){


            Cursor fila=BaseDeDatos.rawQuery("select * from prendas where titulo="+busqueda,null);
            if (fila.moveToFirst()){

                ContentValues registros= new ContentValues();
                registros.put("id","1");
                registros.put("titulo",fila.getString(0));
                registros.put("precio",fila.getString(1));
                BaseDeDatos.insert("ventas",null,registros);
                BaseDeDatos.close();

                ticket.setText(fila.getString(0));



                Toast.makeText(this,"Se agrego a la venta",Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this,"No existe",Toast.LENGTH_SHORT).show();
            }
        }else{

            Toast.makeText(this,"OOps Te faltan datos por llenar",Toast.LENGTH_SHORT).show();
        }

    }


}



































