package com.martinez.apptiendaonline.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.martinez.apptiendaonline.Model.SubCategory;
import com.martinez.apptiendaonline.R;

public class SubCategoryAdapter extends ArrayAdapter<SubCategory>
{
    public SubCategoryAdapter(Context context, SubCategory subCategories[] )
    {
        super( context, R.layout.sub_catalog_list_item, subCategories );
    }

    //Metodo getView()
    public View getView(int position, View convertView, ViewGroup parent )
    {
        LayoutInflater inflater = LayoutInflater.from( getContext() );
        View item = inflater.inflate( R.layout.sub_catalog_list_item, null );

        ImageView imageView = (ImageView)item.findViewById(R.id.imageSubCategory);
        TextView nombreTextView = (TextView)item.findViewById(R.id.nameSubCategory);


        //Item actual
        SubCategory subCategory = getItem( position );

        //Mostramos los datos
        Glide.with( getContext() ).load( subCategory.getImageResource() ).into( imageView );
        nombreTextView.setText( subCategory.getName() );

        return item;

    }

}
