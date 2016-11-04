package com.martinez.apptiendaonline;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeRetailActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    //Views
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_retail);

        //Toolbar de la actividad principal HomeRetailActivity
        Toolbar toolbar = (Toolbar)findViewById(R.id.appbarHomeRetail);
        setSupportActionBar(toolbar);

        //DrawerLayout y NavigationView
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navview);

        //Añadimos el evento a el navigationView
        navigationView.setNavigationItemSelectedListener(this);

        //Añadimos al toolbar el icono del navigation drawer en el lado izquierdo
        getSupportActionBar().setHomeAsUpIndicator(android.support.v7.appcompat.R.drawable.abc_ic_menu_overflow_material);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Mostramos como fragment Home como pantalla inicial
        getSupportFragmentManager().beginTransaction().replace( R.id.content_frame_of_fragments, new HomeRetailFragment(), "Home" ).addToBackStack( "Home" ).commit();


    }

    //Método para inflar a la actividad principal con el layout del appbar
    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        //Inflamos el appbar con el menu y sus elementos si están presentes
        getMenuInflater().inflate( R.menu.menu_appbar_home_retail, menu);
        return true;
    }

    //Método de escucha para el NavigationView
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        String title="";
        //Flag para saber si se desea cambio de fragment
        boolean fragmentTransaction = false;
        //Inicializamos un fragment vacío, este contendrá a los diferentes fragments que hiremos usando
        Fragment fragment = null;

        //Switch con el cuál identificaremos el item seleccionado
        switch( item.getItemId() )
        {
            case R.id.menu_homeRetailItem:
                fragment = new HomeRetailFragment();
                title = HomeRetailFragment.title;
                fragmentTransaction = true;
                break;

            case R.id.menu_boysCategoryItem:
                fragment = new BoysCategoryFragment();
                title = BoysCategoryFragment.title;
                fragmentTransaction = true;
                break;

            case R.id.menu_girlsCategoryItem:
                fragment = new GirlsCategoryFragment();
                title = GirlsCategoryFragment.title;
                fragmentTransaction = true;
                break;

            case R.id.menu_babiesCategoryItem:
                fragment = new BabiesCategoryFragment();
                title = BabiesCategoryFragment.title;
                fragmentTransaction = true;
                break;

            case R.id.menu_searchItem:
                Toast.makeText( getApplicationContext(), "Presionaste Buscar", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu_catalogItem:
                fragment = new CatalogFragment();
                title = CatalogFragment.title;
                fragmentTransaction = true;
                Toast.makeText( getApplicationContext(), "Presionaste Catálogo", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu_shoppingCartItem:
                Toast.makeText( getApplicationContext(), "Presionaste Carrito de Compras", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu_shoppingProcessItem:
                Toast.makeText( getApplicationContext(), "Presionaste Compras en Proceso", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu_shoppingHistoryItem:
                Toast.makeText( getApplicationContext(), "Presionaste Historial de Compras", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu_myProfileItem:
                Toast.makeText( getApplicationContext(), "Presionaste Mi Perfil", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu_findStoreItem:
                Toast.makeText( getApplicationContext(), "Presionaste Encontrar Tienda", Toast.LENGTH_SHORT ).show();
                break;

        }

        //Si hubo un pedido de cambio de fragment
        if( fragmentTransaction )
        {
            //Cambiamos de fragment
            getSupportFragmentManager().beginTransaction().replace( R.id.content_frame_of_fragments, fragment, title ).addToBackStack( title ).commit();
            //Marcamos como seleccionada la opción elegida del menú lateral
            //item.setChecked(true);
            //Colocamos en el toolbar el título del fragment seleccionado
            getSupportActionBar().setTitle( title );

        }

        drawerLayout.closeDrawers();

        return true;
    }


    //Evento regresar atrás
    @Override
    public void onBackPressed()
    {
        if( getSupportFragmentManager().getBackStackEntryCount() > 0 )
        {
            getSupportFragmentManager().popBackStack();
            getSupportActionBar().setTitle( "" );

            String mensaje="";
            for( int i=0; i < getSupportFragmentManager().getFragments().size(); i++ )
            {
                if( getSupportFragmentManager().getFragments().get(i) != null )
                {
                    mensaje = mensaje + getSupportFragmentManager().getFragments().get(i).getTag()+"\n";

                    /*if( getSupportFragmentManager().getFragments().get(i).isVisible() )
                        getSupportActionBar().setTitle( ""+getSupportFragmentManager().getFragments().get(i).getTag() );
                    */
                }

            }

            Toast.makeText( getApplicationContext(), mensaje+getSupportFragmentManager().getFragments().size(), Toast.LENGTH_LONG ).show();
        }
        else
            super.onBackPressed();

    }

}




