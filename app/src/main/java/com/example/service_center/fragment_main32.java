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

public class fragment_main32 extends ListFragment {

    String guID;
    SimpleCursorAdapter userAdapter;
    MyDatabaseHelper sqlHelper;
    Cursor userCursor;
    ListView mList;

    public fragment_main32() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootview = inflater.inflate(R.layout.fragment_main32, container, false);
        mList= (ListView)  rootview.findViewById(android.R.id.list);
        return rootview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getActivity().getIntent().getExtras();
        guID = bundle.getString("guID");
        sqlHelper = new MyDatabaseHelper(getActivity());
        sqlHelper.create_db();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            sqlHelper.open();
            userCursor = sqlHelper.database.rawQuery("select * from " + MyDatabaseHelper.TABLE_NAME + " where Warranty ="+guID+" and Payment=0", null);
            String[] headers = new String[]{MyDatabaseHelper.COLUMN_ORDER};
            userAdapter = new SimpleCursorAdapter(getActivity(), R.layout.item, userCursor, headers, new int[]{R.id.uroki},0);
            mList.setAdapter(userAdapter);

        }
        catch (SQLException ex){}
    }
}