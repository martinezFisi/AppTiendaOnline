package com.martinez.apptiendaonline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GirlsCategoryFragment extends Fragment
{
    public static String title = "Niñas";


    public GirlsCategoryFragment()
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_girls_category, container, false);
    }

}
