package com.martinez.apptiendaonline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.martinez.apptiendaonline.Adapters.ItemShoppingCartAdapter;
import com.martinez.apptiendaonline.Adapters.ItemShoppingHistoryAdapter;
import com.martinez.apptiendaonline.Model.Prenda;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingHistoryFragment extends Fragment implements AdapterView.OnItemClickListener
{
    public static String title = "Historial de Compras";
    //GridView
    private ListView shoppingHistoryListView;
    //Adaptador
    private ItemShoppingHistoryAdapter adapter;
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


    public ShoppingHistoryFragment()
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
        View root = inflater.inflate(R.layout.fragment_shopping_history, container, false);

        //Instanciamos el gridview
        shoppingHistoryListView = (ListView)root.findViewById( R.id.shoppingHistoryListView );
        //Adapter
        adapter = new ItemShoppingHistoryAdapter( getContext(), prendas );
        shoppingHistoryListView.setAdapter( adapter );
        shoppingHistoryListView.setOnItemClickListener( this );

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

    }



}
