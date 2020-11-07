package com.example.service_center;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

public class UpdateActivity extends AppCompatActivity {

    EditText Order_name_input, Customer_input, Month_number_input, day_input, Warranty_input, Payment_input, Performance_input, Other_input;
    Button update_button, delete_button;

    private EditText editText,editText2;
    String id, Order_name, Customer, Month_number, Day_number, Warranty, Payment, Performance, Other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Order_name_input = findViewById(R.id.Order_name_input2);
        Customer_input = findViewById(R.id.Customer_input2);
        Month_number_input = findViewById(R.id.Month_number_input2);
        day_input = findViewById(R.id.Day_number_input2);
        Warranty_input = findViewById(R.id.Warranty_input2);
        Payment_input = findViewById(R.id.Payment_input2);
        Performance_input = findViewById(R.id.Performance_input2);
        Other_input = findViewById(R.id.Other_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        ActivityCompat.requestPermissions(UpdateActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        editText = findViewById(R.id.Other_input2);
        editText2 = findViewById(R.id.Order_name_input2);
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
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                Order_name = Order_name_input.getText().toString().trim();
                Customer = Customer_input.getText().toString().trim();
                Month_number = Month_number_input.getText().toString().trim();
                Day_number = day_input.getText().toString().trim();
                Warranty = Warranty_input.getText().toString().trim();
                Payment = Payment_input.getText().toString().trim();
                Performance = Performance_input.getText().toString().trim();
                Other = Other_input.getText().toString().trim();
                myDB.updateData(id, Order_name, Customer, Month_number, Day_number, Warranty, Payment, Performance, Other);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    public void createMyPDF(View view){

        PdfDocument myPdfDocument = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(300,600,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);

        Paint myPaint = new Paint();
        String myString = editText.getText().toString();
        int x = 10, y=25;
        for (String line:myString.split("\n")){
            myPage.getCanvas().drawText(line, x, y, myPaint);
            y+=myPaint.descent()-myPaint.ascent();
        }

        myPdfDocument.finishPage(myPage);

        String myFilePath = Environment.getExternalStorageDirectory().getPath() + "/Download/" + editText2.getText().toString()+".pdf";
        File myFile = new File(myFilePath);
        try {
            myPdfDocument.writeTo(new FileOutputStream(myFile));
        }
        catch (Exception e){
            e.printStackTrace();
            editText.setText("ERROR");
        }

        myPdfDocument.close();
    }


    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("Order_name") &&
                getIntent().hasExtra("Customer") && getIntent().hasExtra("Month_number")&&
                getIntent().hasExtra("Day_number")&& getIntent().hasExtra("Warranty")&&
                getIntent().hasExtra("Payment")&& getIntent().hasExtra("Performance")&& getIntent().hasExtra("Other")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            Order_name = getIntent().getStringExtra("Order_name");
            Customer = getIntent().getStringExtra("Customer");
            Month_number = getIntent().getStringExtra("Month_number");
            Day_number = getIntent().getStringExtra("Day_number");
            Warranty = getIntent().getStringExtra("Warranty");
            Payment = getIntent().getStringExtra("Payment");
            Performance = getIntent().getStringExtra("Performance");
            Other = getIntent().getStringExtra("Other");

            //Setting Intent Data
            Order_name_input.setText(Order_name);
            Customer_input.setText(Customer);
            Month_number_input.setText(Month_number);
            day_input.setText(Day_number);
            Warranty_input.setText(Warranty);
            Payment_input.setText(Payment);
            Performance_input.setText(Performance);
            Other_input.setText(Other);
            Log.d("stev", Order_name+" "+Customer+" "+Month_number+" "+Day_number+" "+Warranty+" "+Payment+" "+Performance+" "+Other);
        }else{
            Toast.makeText(this, "Нет данных", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удалить заказ " + Order_name + " ?");
        builder.setMessage("Вы действительно хотите удалить заказ " + Order_name + " ?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
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
