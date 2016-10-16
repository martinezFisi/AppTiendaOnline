package com.martinez.apptiendaonline.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.martinez.apptiendaonline.Model.Category;
import com.martinez.apptiendaonline.R;

/**
 * Created by HP on 10/16/2016.
 */
public class CategoryAdapter extends ArrayAdapter<Category>
{

    //Constructor
    public CategoryAdapter( Context context, Category categories[] )
    {
        super( context, R.layout.category_list_item, categories );
    }

    //Metodo getView()
    public View getView( int position, View convertView, ViewGroup parent )
    {
        LayoutInflater inflater = LayoutInflater.from( getContext() );
        View item = inflater.inflate( R.layout.category_list_item, null );

        ImageView imageCategory = (ImageView)item.findViewById( R.id.categoryItemImageView );

        Category category = getItem( position );

        imageCategory.setImageResource( category.getImageResource() );

        return item;
    }

}

