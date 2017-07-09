package com.example.omar.energy.ui;

/**
 * Created by omar on 15/05/17.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.omar.energy.module.MyView;
import com.example.omar.energy.R;



/*
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_my_view);

        MyView adapterViewAndroid = new MyView(RoomsActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

@Override
public void onItemClick(AdapterView<?> parent, View view,
        int i, long id) {
        Toast.makeText(RoomsActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
        }
        });

        }
        }
        */

public class fragment_3 extends Fragment {

    GridView androidGridView;

    String[] gridViewString = {
            "Normal", "Sleep", "Out","Extra Save"

    } ;
    int[] gridViewImageId = {
            R.drawable.powerbutton_512, R.drawable.sleep_512, R.drawable.door_512,R.drawable.power_512
    };
    /*

        private String title;
        private int imageMain;
        private int imageSecondary;


     */
    public static fragment_3 newInstance() {
        fragment_3 fragment = new fragment_3();

           /*
            Bundle args = new Bundle();
            args.putInt("imageMain", resMainImage);
            args.putInt("imageSecondary", resSecondaryImage);
            args.putString("title", title);
            fragment.setArguments(args);*/
        return fragment;
    }


    /*GridView androidGridView, String[] gridViewString, int[] gridViewImageId*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_3, container, false);

        MyView adapterViewAndroid = new MyView(getContext(), gridViewString, gridViewImageId);
        androidGridView=(GridView)view.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);

           /*
            TextView tvLabel = (TextView) view.findViewById(R.id.txtMain);
            tvLabel.setText(title);

            ImageView imageView = (ImageView) view.findViewById(R.id.imgMain);
            imageView.setImageResource(imageMain);

             ImageView imageViewSecondary = (ImageView) view.findViewById(R.id.imgSecondary);
             imageViewSecondary.setImageResource(imageSecondary);
             */
        return view;
    }
}

