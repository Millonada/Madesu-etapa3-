package com.example.evidenciafinal;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class DineroFragment extends Fragment {

    ProgressBar circulo;
    View vista;

    public DineroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_dinero, container, false);

        circulo=(ProgressBar) vista.findViewById(R.id.progressBar);

        circulo.getMax();



        return vista;
    }

}
