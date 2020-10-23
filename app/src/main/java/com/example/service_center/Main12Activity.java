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

public class Main12Activity extends AppCompatActivity {

    String pagesID, tabID;Bundle b;

    private SectionsPagerAdapter mSectionsPagerAdapter2;

    private ViewPager mViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);




        Bundle bundle = getIntent().getExtras();
        pagesID = bundle.getString("pagesID");


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter2 = new Main12Activity.SectionsPagerAdapter (getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager2 = (ViewPager) findViewById(R.id.container1);
        mViewPager2.setAdapter(mSectionsPagerAdapter2);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs1);

        mViewPager2.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager2));
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
                    fragment_main21 bf1= new fragment_main21();
                    b = new Bundle();
                    b.putString("tabID", "1");
                    return bf1;
                case 1:
                    fragment_main22 bf2= new fragment_main22();
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