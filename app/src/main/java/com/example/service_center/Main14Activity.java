package com.example.service_center;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class Main14Activity extends AppCompatActivity {

    String pagesID, tabID;Bundle b;

    private SectionsPagerAdapter mSectionsPagerAdapter5;

    private ViewPager mViewPager5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);




        Bundle bundle = getIntent().getExtras();
        pagesID = bundle.getString("pagesID");


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter5 = new Main14Activity.SectionsPagerAdapter (getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager5 = (ViewPager) findViewById(R.id.container5);
        mViewPager5.setAdapter(mSectionsPagerAdapter5);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs5);

        mViewPager5.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager5));
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            // return PlaceholderFragment.newInstance(position + 1);
            switch (position){
                case 0:
                    fragment_main51 bf01= new fragment_main51();
                    b = new Bundle();
                    b.putString("tabID", "1");
                    return bf01;
                case 1:
                    fragment_main52 bf02= new fragment_main52();
                    b = new Bundle();
                    b.putString("tabID", "2");
                    return bf02;


                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
    }

}