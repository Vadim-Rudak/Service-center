package com.example.service_center;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.time.LocalDate;

public class MainActivity4 extends AppCompatActivity {

    String pagesID, tabID;Bundle b;
    int month;

    private SectionsPagerAdapter mSectionsPagerAdapter4;

    private ViewPager mViewPager4;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        LocalDate date = LocalDate.now();
         month = date.getMonthValue();


        Bundle bundle = getIntent().getExtras();
        pagesID = bundle.getString("pagesID");


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter4 = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager4 = (ViewPager) findViewById(R.id.container4);
        mViewPager4.setAdapter(mSectionsPagerAdapter4);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs4);

        mViewPager4.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager4));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user2, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item41:
                Intent intent41 = new Intent();
                intent41.setClass(MainActivity4.this, Main14Activity.class);
                b = new Bundle();
                b.putString("pagesID", String.valueOf(month));
                intent41.putExtras(b);
                startActivity(intent41);
                return true;
            case R.id.item42:
                Intent intent42 = new Intent();
                intent42.setClass(MainActivity4.this, Main12Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", String.valueOf(month));
                intent42.putExtras(b);
                startActivity(intent42);
                return true;
            case R.id.item43:
                Intent intent43 = new Intent();
                intent43.setClass(MainActivity4.this, MainActivity5.class);
                startActivity(intent43);
            default:
                return super.onOptionsItemSelected(item);
        }


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
                    fragment_main41 bf41= new fragment_main41();
                    b = new Bundle();
                    b.putString("tabID", "1");
                    return bf41;
                case 1:
                    fragment_main42 bf42= new fragment_main42();
                    b = new Bundle();
                    b.putString("tabID", "2");
                    return bf42;
                case 2:
                    fragment_main43 bf43= new fragment_main43();
                    b = new Bundle();
                    b.putString("tabID", "3");
                    return bf43;
                case 3:
                    fragment_main44 bf44= new fragment_main44();
                    b = new Bundle();
                    b.putString("tabID", "4");
                    return bf44;
                case 4:
                    fragment_main45 bf45= new fragment_main45();
                    b = new Bundle();
                    b.putString("tabID", "5");
                    return bf45;

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