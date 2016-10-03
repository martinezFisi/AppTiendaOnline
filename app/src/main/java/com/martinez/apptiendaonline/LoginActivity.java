package com.martinez.apptiendaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    //Views
    private Button entrarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Views
        entrarButton = (Button)findViewById(R.id.entrarButton);
        entrarButton.setOnClickListener(this);

        //Toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.appbarLogin);
        setSupportActionBar(toolbar);
        //Habilitamos el boton regresar en el toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar_login, menu);
        return true;
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.entrarButton:
                startActivity( new Intent( this, HomeRetailActivity.class ) );
                break;
        }
    }
}
