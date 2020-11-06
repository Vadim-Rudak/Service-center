package com.example.service_center;

import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;
        import android.widget.Toast;
        import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public SQLiteDatabase database;

    private static final String DATABASE_NAME = "Serv.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static String DB_PATH;

    static final String TABLE_NAME = "Formation_order";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ORDER = "Order_name";
    public static final String COLUMN_CUSTOMER = "Customer";
    public static final String COLUMN_MONTH = "Month_number";
    private static final String COLUMN_DAY = "Day_number";
    public static final String COLUMN_WARRANTY = "Warranty";
    public static final String COLUMN_PAYMENT = "Payment";
    public static final String COLUMN_PERFORMANCE = "Performance";
    public static final String COLUMN_OTHER = "Other";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        DB_PATH = "/data/data/com.example.service_center/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ORDER + " TEXT, " +
                COLUMN_CUSTOMER + " TEXT, " +
                COLUMN_MONTH + " INTEGER, " +
                COLUMN_DAY + " INTEGER, " +
                COLUMN_WARRANTY + " INTEGER, " +
                COLUMN_PAYMENT + " INTEGER, " +
                COLUMN_PERFORMANCE + " INTEGER, " +
                COLUMN_OTHER + " TEXT);";
        db.execSQL(query);
    }


    public void create_db(){
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            File file = new File(DB_PATH + DATABASE_NAME);
            if (!file.exists()) {
                this.getReadableDatabase();
                myInput = context.getAssets().open(DATABASE_NAME);

                String outFileName = DB_PATH + DATABASE_NAME;
                myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        }
        catch(IOException ex){

        }
    }

    public void open() throws SQLException {
        String path = DB_PATH + DATABASE_NAME;
        database = SQLiteDatabase.openDatabase(path, null,
                SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if (database != null) {
            database.close();
        }
        super.close();
    }

    
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addOrder(String Order_name, String Customer, int Month_number, int Day_number, int Warranty, int Payment, int Performance, String Other){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ORDER, Order_name);
        cv.put(COLUMN_CUSTOMER, Customer);
        cv.put(COLUMN_MONTH, Month_number);
        cv.put(COLUMN_DAY, Day_number);
        cv.put(COLUMN_WARRANTY, Warranty);
        cv.put(COLUMN_PAYMENT, Payment);
        cv.put(COLUMN_PERFORMANCE, Performance);
        cv.put(COLUMN_OTHER, Other);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Заказ добавлен", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    
    void updateData(String row_id, String Order_name, String Customer, String Month_number, String Day_number, String Warranty, String Payment, String Performance, String Other){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ORDER, Order_name);
        cv.put(COLUMN_CUSTOMER, Customer);
        cv.put(COLUMN_MONTH, Month_number);
        cv.put(COLUMN_DAY, Day_number);
        cv.put(COLUMN_WARRANTY, Warranty);
        cv.put(COLUMN_PAYMENT, Payment);
        cv.put(COLUMN_PERFORMANCE, Performance);
        cv.put(COLUMN_OTHER, Other);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка обновления заказа", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Заказ обновлён!", Toast.LENGTH_SHORT).show();
        }

    }

    void updateData2(String row_id, String Order_name, String Day_number, String Warranty, String Payment, String Performance, String Other){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ORDER, Order_name);
        cv.put(COLUMN_DAY, Day_number);
        cv.put(COLUMN_WARRANTY, Warranty);
        cv.put(COLUMN_PAYMENT, Payment);
        cv.put(COLUMN_PERFORMANCE, Performance);
        cv.put(COLUMN_OTHER, Other);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка обновления заказа", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Заказ обновлён!", Toast.LENGTH_SHORT).show();
        }

    }

    void updateData3(String row_id, String Other){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_OTHER, Other);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка обновления заказа", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Заказ обновлён!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка удаления заказа", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Заказ удалён", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
