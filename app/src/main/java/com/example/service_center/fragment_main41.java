package com.example.service_center;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.sql.SQLException;

public class fragment_main41 extends ListFragment {
    String pagesID;
    SimpleCursorAdapter userAdapter;
    MyDatabaseHelper sqlHelper;
    Cursor userCursor;
    ListView mList;


    public fragment_main41() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootview = inflater.inflate(R.layout.fragment_main41, container, false);
        mList= (ListView)  rootview.findViewById(android.R.id.list);
        return rootview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getActivity().getIntent().getExtras();
        pagesID = bundle.getString("pagesID");
        sqlHelper = new MyDatabaseHelper(getActivity());
        sqlHelper.create_db();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            sqlHelper.open();
            userCursor = sqlHelper.database.rawQuery("select * from " + MyDatabaseHelper.TABLE_NAME + " where Month_number ="+pagesID+" and Day_number=1", null);
            String[] headers = new String[]{MyDatabaseHelper.COLUMN_ORDER, MyDatabaseHelper.COLUMN_PERFORMANCE, MyDatabaseHelper.COLUMN_PAYMENT, MyDatabaseHelper.COLUMN_WARRANTY};
            userAdapter = new SimpleCursorAdapter(getActivity(), R.layout.item, userCursor, headers, new int[]{R.id.Order2, R.id.Performance2, R.id.Payment2, R.id.Warranty2},0);
            mList.setAdapter(userAdapter);

        }
        catch (SQLException ex){}
    }


}