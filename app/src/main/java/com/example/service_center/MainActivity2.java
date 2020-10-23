package com.example.service_center;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.time.LocalDate;



public class MainActivity2 extends AppCompatActivity {

    Button button12,button11,button10, button9,button8,button7,button6,button5,button4,button3,button2,button1;
    int month;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button12 =(Button)findViewById(R.id.button12);
        button11 =(Button)findViewById(R.id.button11);
        button10 =(Button)findViewById(R.id.button10);
        button9 =(Button)findViewById(R.id.button9);
        button8 =(Button)findViewById(R.id.button8);
        button7 =(Button)findViewById(R.id.button7);
        button6 =(Button)findViewById(R.id.button6);
        button5 =(Button)findViewById(R.id.button5);
        button4 =(Button)findViewById(R.id.button4);
        button3 =(Button)findViewById(R.id.button3);
        button2 =(Button)findViewById(R.id.button2);
        button1 =(Button)findViewById(R.id.button1);


        LocalDate date = LocalDate.now();
        month = date.getMonthValue();









        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(getBaseContext(),"Класс 11",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "12");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(getBaseContext(),"Класс 11",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "11");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),"Класс 10",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "10");
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(),"Класс 9",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "9");
                intent.putExtras(b);
                startActivity(intent);
            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(),"Класс 8",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "8");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(),"Класс 7",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "7");
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),"Класс 6",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "6");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),"Класс 6",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "5");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),"Класс 6",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "4");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),"Класс 6",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "3");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),"Класс 6",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "2");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),"Класс 6",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, Main11Activity.class);
                Bundle b = new Bundle();
                b.putString("pagesID", "1");
                intent.putExtras(b);
                startActivity(intent);
            }
        });









    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item2:
                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
                return true;
            case R.id.item22:
                Intent intent16 = new Intent();
                intent16.setClass(MainActivity2.this, Main13Activity.class);
                Bundle b = new Bundle();
                b.putString("guID", "0");
                intent16.putExtras(b);
                startActivity(intent16);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}