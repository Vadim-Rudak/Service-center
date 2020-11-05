package com.example.service_center;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
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

public class Edit_user2 extends AppCompatActivity {

    RecyclerView recyclerView2;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;
    DrawerLayout rt;
    int k;


    MyDatabaseHelper myDB;
    ArrayList<String> Order_id, Order_name, Customer, Month_number, Day_number, Warranty, Payment, Performance;
    CustomAdapter2 customAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user2);



        recyclerView2 = findViewById(R.id.recyclerView2);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);




        myDB = new MyDatabaseHelper(Edit_user2.this);
        Order_id = new ArrayList<>();
        Order_name = new ArrayList<>();
        Customer = new ArrayList<>();
        Month_number = new ArrayList<>();
        Day_number = new ArrayList<>();
        Warranty = new ArrayList<>();
        Payment = new ArrayList<>();
        Performance = new ArrayList<>();

        storeDataInArrays();

        customAdapter2 = new CustomAdapter2(Edit_user2.this,this, Order_id, Order_name, Customer,
                Month_number, Day_number, Warranty, Payment, Performance);
        recyclerView2.setAdapter(customAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(Edit_user2.this));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                openactinfo(viewHolder.getAdapterPosition());

            }
        }).attachToRecyclerView(recyclerView2);

    }

    void openactinfo(int bbg){
        bbg=bbg+1;
        if(bbg >= 0){
            myDB.ddv(bbg);
            fnb();

        }else{
            
        }
    }

    void fnb(){
        Intent intent = new Intent(Edit_user2.this, Edit_user2.class);
        startActivity(intent);
        finish();
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
                Customer.add(cursor.getString(2));
                Month_number.add(cursor.getString(3));
                Day_number.add(cursor.getString(4));
                Warranty.add(cursor.getString(5));
                Payment.add(cursor.getString(6));
                Performance.add(cursor.getString(7));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }
}
