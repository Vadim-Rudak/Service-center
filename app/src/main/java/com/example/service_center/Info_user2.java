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

public class Info_user2 extends AppCompatActivity {

    EditText Other_input;
    Button update_button;

    String id, Other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_user2);

        Other_input = findViewById(R.id.Other_input3);
        update_button = findViewById(R.id.update_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(Info_user2.this);
                Other = Other_input.getText().toString().trim();
                myDB.updateData3(id, Other);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id")&& getIntent().hasExtra("Other")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            Other = getIntent().getStringExtra("Other");

            //Setting Intent Data
            Other_input.setText(Other);
            Log.d("stev", Other);
        }else{
            Toast.makeText(this, "Нет данных", Toast.LENGTH_SHORT).show();
        }
    }
}
