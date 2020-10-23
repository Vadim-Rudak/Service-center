package com.example.service_center;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText Order_name_input, Customer_input, Month_number_input, Day_number_input, Warranty_input, Payment_input, Performance_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Order_name_input = findViewById(R.id.Order_name_input);
        Customer_input = findViewById(R.id.Customer_input);
        Month_number_input = findViewById(R.id.Month_number_input);
        Day_number_input = findViewById(R.id.Day_number_input);
        Warranty_input = findViewById(R.id.Warranty_input);
        Payment_input = findViewById(R.id.Payment_input);
        Performance_input = findViewById(R.id.Performance_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addOrder(Order_name_input.getText().toString().trim(),
                        Customer_input.getText().toString().trim(),
                        Integer.valueOf(Month_number_input.getText().toString().trim()),
                        Integer.valueOf(Day_number_input.getText().toString().trim()),
                        Integer.valueOf(Warranty_input.getText().toString().trim()),
                        Integer.valueOf(Payment_input.getText().toString().trim()),
                        Integer.valueOf(Performance_input.getText().toString().trim()));
            }
        });
    }
}
