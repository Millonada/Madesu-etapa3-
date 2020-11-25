package com.example.evidenciafinal.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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
public class DeudaFragment extends Fragment {
    View vista;
    ListView lisView;
    ArrayList<String> listaClientes= new ArrayList<>();
    Button nuevoCliente,cancelar;
    EditText nombre,pedido;
    public DeudaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_deuda, container, false);
        lisView=(ListView) vista.findViewById(R.id.listView);
        nuevoCliente=(Button) vista.findViewById(R.id.btnGuardar);
        cancelar=(Button) vista.findViewById(R.id.btnCancelar);
        nombre=(EditText) vista.findViewById(R.id.txtNombreCliente);
        pedido=(EditText) vista.findViewById(R.id.txtNombrePrenda);


        listaClientes.add("Lista de Clientes: ");
        final ArrayAdapter adapter= new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listaClientes);
        lisView.setAdapter(adapter);

        nuevoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    listaClientes.add("Nombre del cliente: "+ nombre.getText().toString()+"\n Pedido: "+pedido.getText().toString());

                    nombre.setText("");
                    pedido.setText("");
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getContext(),"Se agrego el pedido",Toast.LENGTH_SHORT).show();

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
                pedido.setText("");
            }
        });






        return vista;
    }

}
