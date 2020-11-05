package com.example.service_center;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Info_order extends AppCompatActivity {

    EditText Order_name_input;
    Button update_button;

    String id, Order_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_order);

        Order_name_input = findViewById(R.id.Order_name_input2);
        update_button = findViewById(R.id.update_button);


        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(Order_name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(Info_order.this);
                Order_name = Order_name_input.getText().toString().trim();
                myDB.updateData3(id, Order_name);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("Order_name")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            Order_name = getIntent().getStringExtra("Order_name");


            //Setting Intent Data
            Order_name_input.setText(Order_name);

            Log.d("stev", Order_name);
        }else{
            Toast.makeText(this, "Нет данных", Toast.LENGTH_SHORT).show();
        }
    }
}
