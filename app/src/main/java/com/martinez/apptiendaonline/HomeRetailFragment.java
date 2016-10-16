package com.martinez.apptiendaonline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class HomeRetailFragment extends Fragment
{

    public HomeRetailFragment()
    {

    }

    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        //Recibimos el inflater de la actividad padre y le inflamos el layout de este fragment
        return inflater.inflate( R.layout.fragment_home_retail_, container, false);
    }

}
