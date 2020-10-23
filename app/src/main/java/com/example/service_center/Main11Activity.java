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

public class Main11Activity extends AppCompatActivity {

    String pagesID, tabID;Bundle b;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);




        Bundle bundle = getIntent().getExtras();
        pagesID = bundle.getString("pagesID");


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container4);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs4);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
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
                    fragment_main11 bf1= new fragment_main11();
                    b = new Bundle();
                    b.putString("tabID", "1");
                    return bf1;
                case 1:
                    fragment_main12 bf2= new fragment_main12();
                    b = new Bundle();
                    b.putString("tabID", "2");
                    return bf2;
                case 2:
                    fragment_main13 bf3= new fragment_main13();
                    b = new Bundle();
                    b.putString("tabID", "3");
                    return bf3;
                case 3:
                    fragment_main14 bf4= new fragment_main14();
                    b = new Bundle();
                    b.putString("tabID", "4");
                    return bf4;
                case 4:
                    fragment_main15 bf5= new fragment_main15();
                    b = new Bundle();
                    b.putString("tabID", "5");
                    return bf5;

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }
    }
}