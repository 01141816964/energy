package com.example.omar.energy;

/**
 * Created by omar on 15/05/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_3  extends Fragment{




        private String title;
        private int image;

        public static fragment_3 newInstance(String title, int resImage) {
            fragment_3 fragment = new fragment_3();
            Bundle args = new Bundle();
            args.putInt("image", resImage);
            args.putString("title", title);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            image = getArguments().getInt("image", 0);
            title = getArguments().getString("title");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_3, container, false);
            TextView tvLabel = (TextView) view.findViewById(R.id.txtMain);
            tvLabel.setText(title);

            ImageView imageView = (ImageView) view.findViewById(R.id.imgMain);
            imageView.setImageResource(image);
            return view;
        }
    }



