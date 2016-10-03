package com.martinez.apptiendaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener
{
    //Views
    private Button signinButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        signinButton = (Button)findViewById(R.id.signinHomeButton);
        signinButton.setOnClickListener(this);

        loginButton = (Button)findViewById(R.id.loginHomeButton);
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch( v.getId() )
        {
            case R.id.signinHomeButton:
                startActivity( new Intent( this, SignInActivity.class ) );
                break;

            case R.id.loginHomeButton:
                startActivity( new Intent( this, LoginActivity.class ) );
                break;

        }
    }
}
