package com.example.service_center;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    RecyclerView recyclerView2;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;
    DrawerLayout rt;


    MyDatabaseHelper myDB;
    ArrayList<String> Order_id, Order_name, Day_number, Warranty, Payment, Performance, Other;
    CustomAdapter2 customAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);



        recyclerView2 = findViewById(R.id.recyclerView2);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        



        myDB = new MyDatabaseHelper(MainActivity5.this);
        Order_id = new ArrayList<>();
        Order_name = new ArrayList<>();
        Day_number = new ArrayList<>();
        Warranty = new ArrayList<>();
        Payment = new ArrayList<>();
        Performance = new ArrayList<>();
        Other = new ArrayList<>();

        storeDataInArrays();

        customAdapter2 = new CustomAdapter2(MainActivity5.this,this, Order_id, Order_name,
                 Day_number, Warranty, Payment, Performance, Other);
        recyclerView2.setAdapter(customAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity5.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                Order_id.add(cursor.getString(0));
                Order_name.add(cursor.getString(1));
                Day_number.add(cursor.getString(4));
                Warranty.add(cursor.getString(5));
                Payment.add(cursor.getString(6));
                Performance.add(cursor.getString(7));
                Other.add(cursor.getString(8));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }
}
