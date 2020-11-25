package com.example.evidenciafinal.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evidenciafinal.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarritoFragmen extends Fragment {
    View vista;
    ListView listView;
    EditText ticket,buscador;
    Button buscar;

    public CarritoFragmen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ArrayList<String> listaRegistros = new ArrayList<>();


        listaRegistros.add("Blusa Chica");
        listaRegistros.add("Pantalon");
        listaRegistros.add("Sudadera Grande");
        listaRegistros.add("Playera Hombre");
        listaRegistros.add("Falda");
        listaRegistros.add("Chaleco");
        listaRegistros.add("Blusa Chica");
        listaRegistros.add("Pantalon");
        listaRegistros.add("Sudadera Grande");
        listaRegistros.add("Playera Hombre");
        listaRegistros.add("Falda");
        listaRegistros.add("Chaleco");
        listaRegistros.add("Blusa Chica");
        listaRegistros.add("Pantalon");
        listaRegistros.add("Sudadera Grande");
        listaRegistros.add("Playera Hombre");
        listaRegistros.add("Falda");
        listaRegistros.add("Chaleco");
        vista=inflater.inflate(R.layout.fragment_carrito, container, false);
        buscador=(EditText) vista.findViewById(R.id.txtBuscar);
        ticket=(EditText) vista.findViewById(R.id.txtTicket);
        buscar=(Button) vista.findViewById(R.id.btnBuscar);
        listaRegistros.add("Pantalon");
        listView=(ListView) vista.findViewById(R.id.listView);
        ArrayAdapter adapter= new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listaRegistros);
        listView.setAdapter(adapter);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg=buscador.getText().toString();
                boolean existe=listaRegistros.contains(buscador.getText().toString());

                if (existe){
                    int index=listaRegistros.indexOf("Pantalon");
                    String aux=ticket.getText().toString();
                    ticket.setText(listaRegistros.get(index)+","+aux);
                    Toast.makeText(getContext(),"Venta generada",Toast.LENGTH_SHORT).show();
                    buscador.setText("");
                }else{

                    Toast.makeText(getContext(),"El articulo no existe",Toast.LENGTH_SHORT).show();
                    buscador.setText("");
                }

            }
        });

        return vista;
    }

}
