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

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;
    DrawerLayout rt;


    MyDatabaseHelper myDB;
    ArrayList<String> Order_id, Order_name, Customer, Month_number, Day_number, Warranty, Payment, Performance;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabon();
            }
        });



        myDB = new MyDatabaseHelper(MainActivity3.this);
        Order_id = new ArrayList<>();
        Order_name = new ArrayList<>();
        Customer = new ArrayList<>();
        Month_number = new ArrayList<>();
        Day_number = new ArrayList<>();
        Warranty = new ArrayList<>();
        Payment = new ArrayList<>();
        Performance = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity3.this,this, Order_id, Order_name, Customer,
                Month_number, Day_number, Warranty, Payment, Performance);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this));

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

    private void fabon(){
        final AlertDialog.Builder fbn = new AlertDialog.Builder(this);
        fbn.setTitle("Добавление заказа");
        fbn.setMessage("Введите все данные для добавления заказа");

        LayoutInflater inflater = LayoutInflater.from(this);
        View fl1 = inflater.inflate(R.layout.plus_window, null);
        fbn.setView(fl1);



        final MaterialEditText Order_name_input = fl1.findViewById(R.id.fg1);
        final MaterialEditText Customer_input = fl1.findViewById(R.id.fg2);
        final MaterialEditText Month_number_input = fl1.findViewById(R.id.fg3);
        final MaterialEditText Day_number_input = fl1.findViewById(R.id.fg4);
        final MaterialEditText Warranty_input = fl1.findViewById(R.id.fg5);
        final MaterialEditText Payment_input = fl1.findViewById(R.id.fg6);
        final MaterialEditText Performance_input = fl1.findViewById(R.id.fg7);

        fbn.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });



        fbn.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(Order_name_input.getText().toString())){
                    Snackbar.make(rt,"Введите название заказа", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Customer_input.getText().toString())){
                    Snackbar.make(rt,"Введите дату", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Month_number_input.getText().toString())){
                    Snackbar.make(rt,"Введите подробности о заказе", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Day_number_input.getText().toString())){
                    Snackbar.make(rt,"Введите подробности о заказе", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Warranty_input.getText().toString())){
                    Snackbar.make(rt,"Введите подробности о заказе", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Payment_input.getText().toString())){
                    Snackbar.make(rt,"Введите подробности о заказе", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Performance_input.getText().toString())){
                    Snackbar.make(rt,"Введите подробности о заказе", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity3.this);
                myDB.addOrder(Order_name_input.getText().toString().trim(),
                        Customer_input.getText().toString().trim(),
                        Integer.valueOf(Month_number_input.getText().toString().trim()),
                        Integer.valueOf(Day_number_input.getText().toString().trim()),
                        Integer.valueOf(Warranty_input.getText().toString().trim()),
                        Integer.valueOf(Payment_input.getText().toString().trim()),
                        Integer.valueOf(Performance_input.getText().toString().trim()));

                Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        fbn.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удалить все заказы ?");
        builder.setMessage("Вы действительно хотите удалить все заказы ?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity3.this);
                myDB.deleteAllData();
                //Refresh Activity
                Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
