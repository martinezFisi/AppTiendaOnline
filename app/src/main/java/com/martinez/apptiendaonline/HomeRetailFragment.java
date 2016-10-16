package com.martinez.apptiendaonline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.martinez.apptiendaonline.Adapters.CategoryAdapter;
import com.martinez.apptiendaonline.Model.Category;

import java.util.Timer;
import java.util.TimerTask;


public class HomeRetailFragment extends Fragment implements View.OnClickListener
{
    //ViewAnimator
    private ViewAnimator viewAnimator;
    //Animaciones
    private Animation slide_in_left, slide_out_right;
    //Slides
    private ImageButton slide1;
    private ImageButton slide2;
    private ImageButton slide3;
    //Timer
    Timer timer = null;
    private int count = 0;

    //ListView
    private ListView categoryListView;
    //Adapter
    private CategoryAdapter adapter;
    //Categories
    private Category categories[] = new Category[]
            {
                    new Category( "Boys", "Clothes for boys", null, R.drawable.navheader ),
                    new Category( "Girls", "Clothes for girls", null, R.drawable.item_1 ),
                    new Category( "Boys", "Clothes for boys", null, R.drawable.item_2 )
            };


    public HomeRetailFragment()
    {

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        //Recibimos el inflater de la actividad padre y le inflamos el layout de este fragment
        View root = inflater.inflate( R.layout.fragment_home_retail_, container, false);

        //Referenciamos los views
        viewAnimator = (ViewAnimator)root.findViewById(R.id.viewAnimator);
        slide1 = (ImageButton)root.findViewById(R.id.slide1);
        slide2 = (ImageButton)root.findViewById(R.id.slide2);
        slide3 = (ImageButton)root.findViewById(R.id.slide3);

        slide1.setOnClickListener(this);
        slide2.setOnClickListener(this);
        slide3.setOnClickListener(this);

        //Animaciones
        slide_in_left = AnimationUtils.loadAnimation( getContext() ,android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation( getContext(),android.R.anim.slide_out_right);
        viewAnimator.setInAnimation( slide_in_left );
        viewAnimator.setOutAnimation( slide_out_right );


        timer = new Timer();
        timer.scheduleAtFixedRate(

                new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        viewAnimator.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewAnimator.setDisplayedChild(count);
                                count++;
                                if(count>2)
                                    count = 0;
                            }
                        }, 2000);
                        /*
                        getActivity().runOnUiThread(

                                new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        viewAnimator.setDisplayedChild(count);
                                        count++;
                                        if(count>2)
                                            count = 0;
                                    }
                                }

                        );*/
                    }
                }

        , 0, 2000);


        //ListView
        categoryListView = (ListView)root.findViewById( R.id.categoryListView );
        adapter = new CategoryAdapter( getContext(), categories );
        categoryListView.setAdapter( adapter );


        return root;
    }

    @Override
    public void onClick(View v)
    {
        switch( v.getId() )
        {
            case R.id.slide1:
                Toast.makeText(getActivity().getApplicationContext(), "Presionaste slide 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.slide2:
                Toast.makeText(getActivity().getApplicationContext(), "Presionaste slide 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.slide3:
                Toast.makeText(getActivity().getApplicationContext(), "Presionaste slide 3", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
