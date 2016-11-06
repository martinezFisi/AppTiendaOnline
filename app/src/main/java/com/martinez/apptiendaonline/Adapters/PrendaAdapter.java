package com.martinez.apptiendaonline.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.martinez.apptiendaonline.Model.Category;
import com.martinez.apptiendaonline.Model.Prenda;
import com.martinez.apptiendaonline.R;

import org.w3c.dom.Text;

public class PrendaAdapter extends ArrayAdapter<Prenda>
{

    //Constructor
    public PrendaAdapter(Context context, Prenda[] prendas)
    {
        super(context, R.layout.grid_item, prendas );
    }

    //Metodo getView()
    public View getView( int position, View convertView, ViewGroup parent )
    {
        LayoutInflater inflater = LayoutInflater.from( getContext() );
        View item = inflater.inflate( R.layout.grid_item, null );

        ImageView imagenPrenda = (ImageView)item.findViewById( R.id.imagen_prenda );
        TextView nombrePrenda = (TextView)item.findViewById( R.id.nombre_prenda );
        TextView precioPrenda = (TextView)item.findViewById( R.id.precio_prenda );
        Prenda prenda = getItem( position );

        imagenPrenda.setImageResource( prenda.getIdDrawable() );
        nombrePrenda.setText( prenda.getName() );
        precioPrenda.setText( "S/."+prenda.getPrice() );

        return item;

    }


}
