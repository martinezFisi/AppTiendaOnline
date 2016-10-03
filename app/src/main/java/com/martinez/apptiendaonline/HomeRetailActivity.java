package com.martinez.apptiendaonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;


public class HomeRetailActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_retail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.appbarHomeRetail);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        //Inflamos el appbar con el menu y sus elementos si están presentes
        getMenuInflater().inflate( R.menu.menu_appbar_home_retail, menu);
        return true;
    }

}
