package com.example.omar.energy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by omar on 15/05/17.
 */

public class  fragment_1 extends Fragment {

        private int progressValue;
        private int backgroundBar;
        private int forgroundBar;

        private String titleDemo;
        private String KWH;
        private String LE;



        public static fragment_1 newInstance(String titleDemo, String KWH,
           java.lang.String LE,int progressValue,int backgroundBar,int forgroundBar) {
            fragment_1 fragment = new fragment_1();
            Bundle args = new Bundle();

            args.putInt("progressValue", progressValue);
            args.putInt("backgroundBar", backgroundBar);
            args.putInt("forgroundBar", forgroundBar);

            args.putString("titleDemo", titleDemo);
            args.putString("KWH", KWH);
            args.putString("LE", LE);

            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


                progressValue= getArguments().getInt("progressValue", 0);
                backgroundBar= getArguments().getInt("backgroundBar", 0);
                forgroundBar= getArguments().getInt("forgroundBar", 0);

                titleDemo = getArguments().getString("titleDemo");
                KWH = getArguments().getString("KWH");
                LE = getArguments().getString("LE");




        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_1, container, false);


            ProgressBar progress = (ProgressBar) view.findViewById(R.id.circle_progress_bar_foreground);
            progress.setProgress(90);


            TextView titleTop = (TextView) view.findViewById(R.id.title);
            titleTop.setText(titleDemo);

            TextView kwhIndecator = (TextView) view.findViewById(R.id.KWH);
            kwhIndecator.setText(KWH);

            TextView leIndecator = (TextView) view.findViewById(R.id.LE);
            leIndecator.setText(LE);




            return view;
        }
    }

