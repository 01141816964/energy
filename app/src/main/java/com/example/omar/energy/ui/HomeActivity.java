package com.example.omar.energy.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.omar.energy.R;
import com.pixelcan.inkpageindicator.InkPageIndicator;

public class HomeActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;
    InkPageIndicator mIndicator;
   public static String emailFromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.setCurrentItem(1);
        mIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(vpPager);

         emailFromIntent = getIntent().getStringExtra("EMAIL");


        //Toast.makeText(getApplicationContext(),"Welcome: "+emailFromIntent,Toast.LENGTH_SHORT).show();
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {



        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages.
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for a particular page.

        @Override
        public Fragment getItem(int position ) {


            switch (position) {
                case 0:
                    return fragment_3.newInstance();
                case 1:
                    return fragment_1.newInstance(emailFromIntent ,"750 KWH","225 LE", 90,R.drawable.circle_progress_background,R.drawable.circle_progress_foreground);
                case 2:
                    return fragment_2.newInstance();
                default:
                    return null;
            }
          }
        }

    }



