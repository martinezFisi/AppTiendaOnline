package com.martinez.apptiendaonline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.martinez.apptiendaonline.Model.Prenda;
import com.martinez.apptiendaonline.R;

import org.w3c.dom.Text;

/**
 * Created by HP on 11/17/2016.
 */
public class ItemShoppingCartAdapter extends ArrayAdapter<Prenda>
{
    //Constructor
    public ItemShoppingCartAdapter(Context context, Prenda[] prendas)
    {
        super(context, R.layout.shopping_car_list_item, prendas );
    }

    //Metodo getView()
    public View getView(int position, View convertView, ViewGroup parent )
    {
        LayoutInflater inflater = LayoutInflater.from( getContext() );
        View item = inflater.inflate( R.layout.shopping_car_list_item, null );

        //ImageView imagenPrenda = (ImageView)item.findViewById( R.id.imagen_prenda );
        TextView descripcionPrenda = (TextView)item.findViewById( R.id.descriptionItemShoppingCart );
        TextView tallaPrenda = (TextView)item.findViewById( R.id.sizeItemShoppingCart );
        TextView colorPrenda = (TextView)item.findViewById( R.id.colorItemShoppingCart );
        TextView cantidadPrenda = (TextView)item.findViewById( R.id.quantityItemShoppingCart );
        TextView precioPrenda = (TextView)item.findViewById( R.id.priceItemShoppingCart );

        Prenda prenda = getItem( position );

        //imagenPrenda.setImageResource( prenda.getIdDrawable() );
        descripcionPrenda.setText( prenda.getDescription() );
        tallaPrenda.setText( "Talla: "+prenda.getSize() );
        colorPrenda.setText( "Color: "+prenda.getColor() );
        cantidadPrenda.setText( "Cantidad: "+prenda.getQuantity() );
        precioPrenda.setText( "S/. "+prenda.getPrice() );

        return item;

    }
}
