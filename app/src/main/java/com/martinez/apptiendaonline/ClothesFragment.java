package com.martinez.apptiendaonline;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.martinez.apptiendaonline.Adapters.PrendaAdapter;
import com.martinez.apptiendaonline.Adapters.SubCategoryAdapter;
import com.martinez.apptiendaonline.Model.Prenda;
import com.martinez.apptiendaonline.Model.SubCategory;


public class ClothesFragment extends Fragment
{
    public static String title = "Prendas";
    //GridView
    private GridView gridView;
    //Adaptador
    private PrendaAdapter adapter;
    //SubCategories
    private Prenda prendas[] = new Prenda[]
            {
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
                    new Prenda( "Polo con cuello", R.drawable.ford_mondeo, "", 20 ),
            };


    public ClothesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

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
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_clothes, container, false);

        //Instanciamos el gridview
        gridView = (GridView)root.findViewById( R.id.grid );
        //Adapter
        adapter = new PrendaAdapter( getContext(), prendas );
        gridView.setAdapter( adapter );

        return root;
    }

}
