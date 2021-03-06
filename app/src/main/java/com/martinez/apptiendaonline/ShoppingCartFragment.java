package com.martinez.apptiendaonline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.martinez.apptiendaonline.Adapters.ItemShoppingCartAdapter;
import com.martinez.apptiendaonline.Adapters.PrendaAdapter;
import com.martinez.apptiendaonline.Model.Prenda;


public class ShoppingCartFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener
{
    public static String title = "Carrito de compras";
    //GridView
    private ListView shoppingCartListView;
    //Adaptador
    private ItemShoppingCartAdapter adapter;
    //SubCategories
    private Prenda prendas[] = new Prenda[]
            {
                    new Prenda( "Polo con cuello", R.drawable.lead_photo_10, "Camisero modelo pepito", 20, 10, "Azul marino", 2 ),
                    new Prenda( "Polo con cuello", R.drawable.lead_photo_10, "Camisero modelo pepito", 20, 10, "Azul marino", 2 ),
                    new Prenda( "Polo con cuello", R.drawable.lead_photo_10, "Camisero modelo pepito", 20, 10, "Azul marino", 2 ),
                    new Prenda( "Polo con cuello", R.drawable.lead_photo_10, "Camisero modelo pepito", 20, 10, "Azul marino", 2 ),
                    new Prenda( "Polo con cuello", R.drawable.lead_photo_10, "Camisero modelo pepito", 20, 10, "Azul marino", 2 ),
                    new Prenda( "Polo con cuello", R.drawable.lead_photo_10, "Camisero modelo pepito", 20, 10, "Azul marino", 2 ),
                    new Prenda( "Polo con cuello", R.drawable.lead_photo_10, "Camisero modelo pepito", 20, 10, "Azul marino", 2 ),
            };

    //Button
    private Button realizarPagoCarrito;

    public ShoppingCartFragment()
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
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        //Instanciamos el gridview
        shoppingCartListView = (ListView)root.findViewById( R.id.shoppingCartListView );
        //Adapter
        adapter = new ItemShoppingCartAdapter( getContext(), prendas );
        shoppingCartListView.setAdapter( adapter );
        shoppingCartListView.setOnItemClickListener(this);

        //Button
        realizarPagoCarrito = (Button)root.findViewById( R.id.realizarPagoCarritoButton );
        realizarPagoCarrito.setOnClickListener(this);

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

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
            case R.id.realizarPagoCarritoButton:
                fragment = new PayFragment();
                title = PayFragment.title;
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
