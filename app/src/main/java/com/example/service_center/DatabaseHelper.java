package com.example.service_center;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
            super(context, "Reg.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table user(username text primary key, password text )");
            db.execSQL("insert into user values ('admin', '123' ), " +
                    "('user1', '1234' )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists user");
    }

    //



    //проверка логина и пароля
    public Boolean userpassw(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }


    }


}
