package com.example.grzegorzmacko.mojemonety;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
private static final String TAG = "ListDataActivity";

    bazadanych bd;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        mListView = (ListView) findViewById(R.id.listView1);
        bd = new bazadanych(this);
        populateListView();
    }
        // Wyswietlanie i dodanie danych w listview
    private void populateListView() {
        Log.d(TAG, "Populate list view: display data");
        Cursor data = bd.Wyswietl();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));

        }

ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData);

        mListView.setAdapter(adapter);


    }
}
