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

public class Main13Activity extends AppCompatActivity {

    String guID, tabID;Bundle b;

    private SectionsPagerAdapter mSectionsPagerAdapter3;

    private ViewPager mViewPager3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);




        Bundle bundle = getIntent().getExtras();
        guID = bundle.getString("guID");


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter3 = new Main13Activity.SectionsPagerAdapter (getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager3 = (ViewPager) findViewById(R.id.container5);
        mViewPager3.setAdapter(mSectionsPagerAdapter3);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs5);

        mViewPager3.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager3));
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
                    fragment_main31 bf1= new fragment_main31();
                    b = new Bundle();
                    b.putString("tabID", "1");
                    return bf1;
                case 1:
                    fragment_main32 bf2= new fragment_main32();
                    b = new Bundle();
                    b.putString("tabID", "2");
                    return bf2;


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