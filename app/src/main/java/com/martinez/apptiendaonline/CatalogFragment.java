package com.martinez.apptiendaonline;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.martinez.apptiendaonline.Adapters.CategoryAdapter;
import com.martinez.apptiendaonline.Model.Category;


public class CatalogFragment extends Fragment implements AdapterView.OnItemClickListener
{
    public static String title = "Catálogo";

    //ListView
    private ListView catalogListView;
    //Adaptador
    private CategoryAdapter adapter;
    //Categories
    private Category categories[] = new Category[]
            {
                    new Category( "Boys", "Clothes for boys", null, R.drawable.zzz_hb_header_kidsshop ),
                    new Category( "Girls", "Clothes for girls", null, R.drawable.zzz_hb_header_kidsshop ),
                    new Category( "Boys", "Clothes for boys", null, R.drawable.header_ingles_ninos_y_jovenes ),
                    new Category( "Boys", "Clothes for boys", null, R.drawable.zzz_hb_header_kidsshop ),
                    new Category( "Girls", "Clothes for girls", null, R.drawable.zzz_hb_header_kidsshop ),
                    new Category( "Boys", "Clothes for boys", null, R.drawable.header_ingles_ninos_y_jovenes )
            };


    //Constructor
    public CatalogFragment()
    {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override//Evento del ciclo de vida del fragment en donde se permite la iteraccion del usuario
    public void onResume()
    {
        super.onResume();
        ( (AppCompatActivity)getActivity() ).getSupportActionBar().setTitle(title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);

        catalogListView = (ListView)root.findViewById(R.id.catalogListView);
        adapter = new CategoryAdapter( getContext(), categories );
        catalogListView.setAdapter( adapter );
        catalogListView.setOnItemClickListener( this );


        return root;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String title="";
        //Fragment
        Fragment fragment = null;
        boolean fragmentTransaction = false;

        Log.d("Log","Presionaste "+position);

        switch ( position )
        {
            case 0:
                fragment = new SubCatalogFragment();
                title = SubCatalogFragment.title;
                fragmentTransaction = true;
                break;
        }

        if( fragmentTransaction )
        {
            //Cambiamos de fragment
            ( (AppCompatActivity)getActivity() ).getSupportFragmentManager().beginTransaction().replace( R.id.content_frame_of_fragments, fragment ).addToBackStack( title ).commit();
            ( (AppCompatActivity)getActivity() ).getSupportActionBar().setTitle(title);
        }

    }

}
