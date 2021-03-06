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

public class Up_act2 extends AppCompatActivity {

    EditText Order_name_input,  day_input, Warranty_input, Payment_input, Performance_input;
    Button update_button;

    String id, Order_name,  Day_number, Warranty, Payment, Performance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.up_act2);

        Order_name_input = findViewById(R.id.Order_name_input2);
        day_input = findViewById(R.id.Day_number_input2);
        Warranty_input = findViewById(R.id.Warranty_input2);
        Payment_input = findViewById(R.id.Payment_input2);
        Performance_input = findViewById(R.id.Performance_input2);
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
                MyDatabaseHelper myDB = new MyDatabaseHelper(Up_act2.this);
                Order_name = Order_name_input.getText().toString().trim();
                Day_number = day_input.getText().toString().trim();
                Warranty = Warranty_input.getText().toString().trim();
                Payment = Payment_input.getText().toString().trim();
                Performance = Performance_input.getText().toString().trim();
                myDB.updateData2(id, Order_name, Day_number, Warranty, Payment, Performance);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("Order_name") &&
                getIntent().hasExtra("Day_number")&& getIntent().hasExtra("Warranty")&&
                getIntent().hasExtra("Payment")&& getIntent().hasExtra("Performance")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            Order_name = getIntent().getStringExtra("Order_name");
            Day_number = getIntent().getStringExtra("Day_number");
            Warranty = getIntent().getStringExtra("Warranty");
            Payment = getIntent().getStringExtra("Payment");
            Performance = getIntent().getStringExtra("Performance");


            //Setting Intent Data
            Order_name_input.setText(Order_name);
            day_input.setText(Day_number);
            Warranty_input.setText(Warranty);
            Payment_input.setText(Payment);
            Performance_input.setText(Performance);

            Log.d("stev", Order_name+" "+Day_number+" "+Warranty+" "+Payment+" "+Performance );
        }else{
            Toast.makeText(this, "Нет данных", Toast.LENGTH_SHORT).show();
        }
    }
}
