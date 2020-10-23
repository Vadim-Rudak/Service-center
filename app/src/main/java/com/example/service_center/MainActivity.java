package com.example.service_center;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity{

    DatabaseHelper db;

    RelativeLayout rell1, rell2;
    Button f1, mlg;
    EditText textUsername, textPassword;
    int month;


    Handler handler = new Handler ();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //My two Relative Layouts
            rell1.setVisibility(View.VISIBLE);
            rell2.setVisibility(View.VISIBLE);
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        LocalDate date = LocalDate.now();
        month = date.getMonthValue();

        db = new DatabaseHelper(this);

        textUsername = (EditText) findViewById(R.id.m1);
        textPassword = (EditText) findViewById(R.id.m2);
        mlg = (Button) findViewById(R.id.mlg);

        f1 =(Button)findViewById(R.id.f1);


        onLogin();


        rell1 = (RelativeLayout)findViewById(R.id.rel1);
        rell2 = (RelativeLayout)findViewById(R.id.rel2);

        handler.postDelayed(runnable,2000);

        //This is delay for timeout
    }

    public void ChkUser(String usern, String s1, String s2) {
        if (usern.equals(s1)){
            Toast.makeText(getApplicationContext(), "Пользователь 1", Toast.LENGTH_SHORT).show();
            Intent home = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(home);
        }
        if (usern.equals(s2)){
            Toast.makeText(getApplicationContext(), "Пользователь 2", Toast.LENGTH_SHORT).show();
            Intent intent41 = new Intent();
            intent41.setClass(MainActivity.this, MainActivity4.class);
            Bundle b = new Bundle();
            b.putString("pagesID", String.valueOf(month));
            intent41.putExtras(b);
            startActivity(intent41);
        }
    }

    public void onLogin(){
        mlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textUsername.getText().toString();
                String passw = textPassword.getText().toString();
                String username1 = textUsername.getText().toString();
                String s1 = new String("admin");
                String s2 = new String("user1");

                Boolean ChkUserPassw = db.userpassw(username,passw);

                if(ChkUserPassw==true){
                    ChkUser(username1, s1, s2);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Ошибка входа", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}