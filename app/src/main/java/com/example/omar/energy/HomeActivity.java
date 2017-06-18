package com.example.omar.energy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ProgressBar;

import com.pixelcan.inkpageindicator.InkPageIndicator;

import static com.example.omar.energy.R.string.percent_value;

public class HomeActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;
    InkPageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.setCurrentItem(1);
        mIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(vpPager);

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

        public Fragment setHome(){
            return fragment_1.newInstance("titleDemo","750 KWH","125 LE", 90,R.drawable.circle_progress_background,R.drawable.circle_progress_foreground);
        }

        @Override
        public Fragment getItem(int position ) {


            switch (position) {
                case 0:
                    return fragment_2.newInstance("Fragment 2",R.drawable.energy,R.drawable.cardinal_bird);
                case 1:
                    return fragment_1.newInstance("titleDemo","750 KWH","125 LE", 90,R.drawable.circle_progress_background,R.drawable.circle_progress_foreground);
                case 2:
                    return fragment_3.newInstance("Fragment 3", R.drawable.cardinal_bird);
                default:
                    return null;
            }
          }
        }

    }



