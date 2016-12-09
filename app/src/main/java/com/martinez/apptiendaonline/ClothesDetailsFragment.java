package com.martinez.apptiendaonline;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.Timer;
import java.util.TimerTask;


public class ClothesDetailsFragment extends Fragment implements View.OnClickListener
{
    public static String title = "Detalle de Prenda";
    //ViewAnimator
    private ViewAnimator viewAnimator;
    //Animaciones
    private Animation slide_in_left, slide_out_right;
    //Slides
    private ImageButton slide1;
    private ImageButton slide2;
    private ImageButton slide3;
    //Timer
    Timer timer = null;
    private int count = 0;

    //Spinners
    private Spinner tallasSpinner;
    private String tallas[] = new String[]{"8","10","12","14"};
    private Spinner coloresSpinner;
    private String colores[] = new String[]{"Rojo","Azul","Verde","Negro"};
    private Spinner cantidadesSpinner;
    private String cantidades[] = new String[]{"1 unidad","2 unidades","3 unidades","4 unidades"};

    //Buttons
    private Button comprarArticuloButton;

    private Button agregarAlCarritoButton;

    public ClothesDetailsFragment()
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
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Recibimos el inflater de la actividad padre y le inflamos el layout de este fragment
        View root = inflater.inflate( R.layout.fragment_clothes_details, container, false);

        //Spinners
        tallasSpinner = (Spinner)root.findViewById(R.id.tallasSpinner);
        ArrayAdapter<String> tallasAdapter = new ArrayAdapter<String>( getContext(), android.R.layout.simple_spinner_item, tallas);
        tallasSpinner.setAdapter(tallasAdapter);
        coloresSpinner = (Spinner)root.findViewById(R.id.coloresSpinner);
        ArrayAdapter<String> coloresAdapter = new ArrayAdapter<String>( getContext(), android.R.layout.simple_spinner_item, colores);
        coloresSpinner.setAdapter(coloresAdapter);
        cantidadesSpinner = (Spinner)root.findViewById(R.id.cantidadesSpinner);
        ArrayAdapter<String> cantidadesAdapter = new ArrayAdapter<String>( getContext(), android.R.layout.simple_spinner_item, cantidades);
        cantidadesSpinner.setAdapter(cantidadesAdapter);

        //Buttons
        comprarArticuloButton = (Button)root.findViewById(R.id.comprarArticuloButton);
        comprarArticuloButton.setOnClickListener(this);

        //agregarAlCarritoButton = (Button)root.findViewById(R.id.agregarAlCarritoButton);
        //agregarAlCarritoButton.setOnClickListener(this);

        //Referenciamos los views
        viewAnimator = (ViewAnimator)root.findViewById(R.id.clothesDetailsViewAnimator);
        slide1 = (ImageButton)root.findViewById(R.id.clothesDetailsSlide1);
        slide2 = (ImageButton)root.findViewById(R.id.clothesDetailsSlide2);
        slide3 = (ImageButton)root.findViewById(R.id.clothesDetailsSlide3);

        slide1.setOnClickListener(this);
        slide2.setOnClickListener(this);
        slide3.setOnClickListener(this);

        //Animaciones
        slide_in_left = AnimationUtils.loadAnimation( getContext() ,android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation( getContext(),android.R.anim.slide_out_right);
        viewAnimator.setInAnimation( slide_in_left );
        viewAnimator.setOutAnimation( slide_out_right );


        timer = new Timer();
        timer.scheduleAtFixedRate(

                new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        viewAnimator.postDelayed( new Runnable() {
                            @Override
                            public void run()
                            {
                                viewAnimator.setDisplayedChild(count);
                                count++;
                                if(count>2)
                                    count = 0;
                            }
                        }, 2000);

                    }
                }

                , 0, 2000);

        return root;
    }


    @Override
    public void onClick(View v)
    {
        String title="";
        //Fragment
        Fragment fragment = null;
        boolean fragmentTransaction = false;

        switch( v.getId() )
        {
            case R.id.comprarArticuloButton:
                Toast.makeText( getContext(), "Prenda agregada al carrito", Toast.LENGTH_SHORT ).show();

                break;

            /*
            case R.id.agregarAlCarritoButton:
                fragment = new ShoppingCartFragment();
                title = ShoppingCartFragment.title;
                fragmentTransaction = true;
                break;*/

        }

        if( fragmentTransaction )
        {
            //Cambiamos de fragment
            ( (AppCompatActivity)getActivity() ).getSupportFragmentManager().beginTransaction().replace( R.id.content_frame_of_fragments, fragment ).addToBackStack( title ).commit();
            ( (AppCompatActivity)getActivity() ).getSupportActionBar().setTitle(title);
        }

    }
}
