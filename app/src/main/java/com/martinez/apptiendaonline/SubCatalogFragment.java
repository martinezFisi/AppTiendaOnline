package com.martinez.apptiendaonline;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.martinez.apptiendaonline.Adapters.SubCategoryAdapter;
import com.martinez.apptiendaonline.Model.SubCategory;


public class SubCatalogFragment extends Fragment
{
    public static String title = "Categorías";
    //ListView
    private ListView subCategoryListView;
    //Adaptador
    private SubCategoryAdapter adapter;
    //SubCategories
    private SubCategory subCategories[] = new SubCategory[]
            {
                    new SubCategory( "Polos","Prendas de mangas cortas", null, R.drawable.lead_photo_10 ),
                    new SubCategory( "Pantalones","Prendas de mangas cortas", null, R.drawable.lead_photo_10 ),
                    new SubCategory( "Zapatos","Prendas de mangas cortas", null, R.drawable.lead_photo_10 ),
                    new SubCategory( "Ropa Interior","Prendas de mangas cortas", null, R.drawable.lead_photo_10 ),
                    new SubCategory( "Gorras","Prendas de mangas cortas", null, R.drawable.lead_photo_10 ),
            };


    public SubCatalogFragment()
    {
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
        View root = inflater.inflate(R.layout.fragment_sub_catalog, container, false);

        //Instanciamos el listview
        subCategoryListView = (ListView)root.findViewById( R.id.subCatalogListView );
        //Adapter
        adapter = new SubCategoryAdapter( getContext(), subCategories );
        subCategoryListView.setAdapter( adapter );

        return root;
    }


}
