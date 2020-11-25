package com.example.evidenciafinal.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
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
public class ListaFragment extends Fragment {

     EditText id,titulo,costo,precio,talla,color;
    View vista;
    Button guardar,cancelar;
    ListView listaPrendas;

    ArrayList<String> listaRegistros = new ArrayList<>();

    public ListaFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista=inflater.inflate(R.layout.fragment_lista, container, false);

        id=(EditText) vista.findViewById(R.id.txtId);
        titulo=(EditText) vista.findViewById(R.id.txtTitulo);
        costo=(EditText) vista.findViewById(R.id.txtCosto);
        precio=(EditText) vista.findViewById(R.id.txtPrecio);
        talla=(EditText) vista.findViewById(R.id.txtTalla);
        color=(EditText) vista.findViewById(R.id.txtColor);

        listaPrendas=(ListView) vista.findViewById(R.id.ListaPrendas);
        guardar=(Button) vista.findViewById(R.id.btnGuardar);
        cancelar=(Button) vista.findViewById(R.id.btnCancelar);

        final ArrayAdapter adapter= new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listaRegistros);
        listaPrendas.setAdapter(adapter);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                listaRegistros.add("Id:"+id.getText().toString()+titulo.getText().toString()+costo.getText().toString()+precio.getText().toString()+talla.getText().toString()+color.getText().toString());

                adapter.notifyDataSetChanged();

                id.setText("");
                titulo.setText("");
                costo.setText("");
                precio.setText("");
                color.setText("");
                talla.setText("");
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id.setText("");
                titulo.setText("");
                costo.setText("");
                precio.setText("");
                color.setText("");
                talla.setText("");
            }
        });

        return vista;
    }




}
