package com.martinez.apptiendaonline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.ViewAnimator;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequestChangeFragment extends Fragment
{
    public static String title = "Cambio de prenda";
    //Spinners
    private Spinner tallasSpinner;
    private String tallas[] = new String[]{"8","10","12","14"};
    private Spinner coloresSpinner;
    private String colores[] = new String[]{"Rojo","Azul","Verde","Negro"};
    private Spinner cantidadesSpinner;
    private String cantidades[] = new String[]{"1 unidad","2 unidades","3 unidades","4 unidades"};

    public RequestChangeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onResume()
    {
        super.onResume();
        ( (AppCompatActivity)getActivity() ).getSupportActionBar().setTitle(title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Recibimos el inflater de la actividad padre y le inflamos el layout de este fragment
        View root = inflater.inflate( R.layout.fragment_request_change, container, false);

        //Spinners
        tallasSpinner = (Spinner)root.findViewById(R.id.tallasCambioSpinner);
        ArrayAdapter<String> tallasAdapter = new ArrayAdapter<String>( getContext(), android.R.layout.simple_spinner_item, tallas);
        tallasSpinner.setAdapter(tallasAdapter);

        coloresSpinner = (Spinner)root.findViewById(R.id.coloresCambioSpinner);
        ArrayAdapter<String> coloresAdapter = new ArrayAdapter<String>( getContext(), android.R.layout.simple_spinner_item, colores);
        coloresSpinner.setAdapter(coloresAdapter);

        cantidadesSpinner = (Spinner)root.findViewById(R.id.cantidadesCambioSpinner);
        ArrayAdapter<String> cantidadesAdapter = new ArrayAdapter<String>( getContext(), android.R.layout.simple_spinner_item, cantidades);
        cantidadesSpinner.setAdapter(cantidadesAdapter);



        return root;
    }

}
