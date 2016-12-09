package com.martinez.apptiendaonline.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.martinez.apptiendaonline.Model.Prenda;
import com.martinez.apptiendaonline.PayFragment;
import com.martinez.apptiendaonline.R;
import com.martinez.apptiendaonline.RequestChangeFragment;

/**
 * Created by HP on 11/29/2016.
 */
public class ItemShoppingHistoryAdapter extends ArrayAdapter<Prenda> implements View.OnClickListener
{
    private Activity context;

    //Constructor
    public ItemShoppingHistoryAdapter(Context context, Prenda[] prendas)
    {
        super(context, R.layout.shopping_history_list_item, prendas );
        this.context = (Activity)context;
    }

    //Metodo getView()
    public View getView(int position, View convertView, ViewGroup parent )
    {
        LayoutInflater inflater = LayoutInflater.from( getContext() );
        View item = inflater.inflate( R.layout.shopping_history_list_item, null );

        //ImageView imagenPrenda = (ImageView)item.findViewById( R.id.imagen_prenda );
        TextView descripcionPrenda = (TextView)item.findViewById( R.id.descriptionItemShoppingHistory );
        TextView precioPrenda = (TextView)item.findViewById( R.id.priceItemShoppingHistory );

        TextView solicitarCambio = (TextView)item.findViewById( R.id.solicitarCambioTextView );
        solicitarCambio.setOnClickListener( this );


        Prenda prenda = getItem( position );

        //imagenPrenda.setImageResource( prenda.getIdDrawable() );
        descripcionPrenda.setText( prenda.getDescription() );
        precioPrenda.setText( "S/. "+prenda.getPrice() );

        return item;

    }

    @Override
    public void onClick(View v)
    {
        String title="";
        //Fragment
        Fragment fragment = null;
        boolean fragmentTransaction = false;

        switch(v.getId())
        {
            case R.id.solicitarCambioTextView:
                fragment = new RequestChangeFragment();
                title = RequestChangeFragment.title;
                fragmentTransaction = true;
                break;
        }

        if( fragmentTransaction )
        {
            //Cambiamos de fragment
            ( (AppCompatActivity)context ).getSupportFragmentManager().beginTransaction().replace( R.id.content_frame_of_fragments, fragment ).addToBackStack( title ).commit();
            ( (AppCompatActivity)context ).getSupportActionBar().setTitle(title);
        }
    }
}
