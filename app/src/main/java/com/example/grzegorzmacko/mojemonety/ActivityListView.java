package com.example.grzegorzmacko.mojemonety;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    //Global variable ListView
    ListView listView;

    // ArrayList contains our listview items
    ArrayList<moneta> listItems;

    //ArrayList to Simple Cursor Adapter
    ArrayList<moneta> newData;

    //Global variable for database connection
    FeedReaderDbHelper mDbHelper;

    //Global variable Simple Array Adapter
    MySimpleArrayAdapter adapter;

    // Contains the id of the item we are about to delete
    public int deleteItem;
    public int select_item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.myListView);

        //Database class instance
         mDbHelper = new FeedReaderDbHelper(this);

        //Collect all the coins
        listItems = mDbHelper.getAllNotes();

        //Create an ArrayList for MySimpleArrayAdapter
        newData = new ArrayList<moneta>();

        // Assigning coins to our global property so we can access it
        // later after certain actions (deleting/adding)
        for ( moneta mon : listItems) {
            newData.add(mon);
        }

        //Create an adapter instance
         adapter = new MySimpleArrayAdapter(this, newData);

        // Assigning the adapter to ListView
        listView.setAdapter(adapter);



            // Click on the list, create a new view with details of the item.
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                select_item = position;

                Intent registerIntent = new Intent(ActivityListView.this,
                        ActivityItemInfo.class);

                //Share id item
                registerIntent.putExtra("_id", select_item);
                startActivity(registerIntent);


            }
        });


        // Long click removes the item
        listView.setLongClickable(true);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                deleteItem = position;

                // Creating a new alert dialog to confirm the delete
                AlertDialog alert = new AlertDialog.Builder(ActivityListView.this)
                        .setTitle("Delete " + listItems.get(deleteItem).waluta)
                        .setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {
                                        //Retrieving the coin from our listItem property,
                                        //which contains all coins from our database
                                        moneta mon = listItems.get(deleteItem);

                                        // Deleting it from the ArrayList<>
                                        // property which is linked to our adapter
                                        newData.remove(deleteItem);

                                        // Deleting the coin from our database
                                        mDbHelper.removee(mon._id);

                                        // Tell the adapter to update the list view
                                        // with the latest changes
                                        adapter.notifyDataSetChanged();

                                        dialog.dismiss();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {
                                        // When you press cancel, just close the
                                        // dialog
                                        dialog.cancel();
                                    }
                                }).show();

                return false;

            }
        });


    }

    //Refresh ArrayAdapter onResume
    @Override
    public void onResume() {
        super.onResume();

        //Removing and retrieve all coins
        newData.clear();
     listItems.addAll(odswiezArrayListAdaptera());

        // Tell the adapter to update the list view
        // with the latest changes
        adapter.notifyDataSetChanged();
    }

// refreshing method of list adapter
    public ArrayList<moneta> odswiezArrayListAdaptera(){

        //Collect all the coins of database
        listItems = mDbHelper.getAllNotes();

        //Removing all coins from the ArrayList<>
        // property which is linked to our adapter
        newData.clear();

        //Object copying
        for ( moneta mon : listItems) {
            newData.add(mon);
        }
        //Returning a refreshed array
        return newData;
    }

    // trzeba to po angielsku

    public static class MySimpleArrayAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final ArrayList<moneta> values;

        //Custom  adapter ArrayList
        public MySimpleArrayAdapter(Context context, ArrayList objects) {
            super(context, R.layout.activity_item, objects);

            this.context = context;
            values = objects;

        }

        /**
         * Here we go and get our activity_item.xml file and set the textview text.
         * This happens for every row in your listview.
         */
        @Override  // przysloneicie metody get view
        //w ktorym list view napelnia sie widokiem activity item
        public View getView(int position, View convertView, ViewGroup parent) {

            // Assign the view we are converting to a local variable
            View v = convertView;

            // First check to see if the view is null. if so, we have to inflate it.
            // to inflate it basically means to render, or show, the view.
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.activity_item, null);
            }

            // Field to the object of the coin
            TextView textView = (TextView) v.findViewById(R.id.textViewIdd);
            TextView idd = (TextView) v.findViewById(R.id.textView10);
            TextView tq = (TextView) v.findViewById(R.id.textView6);

                //Download object
            moneta mon =  values.get(position);

            //set field
            idd.setText(String.valueOf(mon.getId()));
            textView.setText(mon.getWaluta());
            tq.setText(mon.getKraj_pochodzenia());
            return v;
        }
    }

        private void populateListView () {
          //  bd = new bazadanych(this);
            // populateListView();


/*
            final FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);

           // SQLiteDatabase db = mDbHelper.getReadableDatabase();


            Cursor cursor = mDbHelper.wyswietlWszystkieRekordyy();
            String[] dlaNazwPola = new String[]{"_id", "waluta"};
            int[] IdDlaElementow = new int[]{R.id.textViewId, R.id.textViewWaluta};


            myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.item_layout, cursor, dlaNazwPola, IdDlaElementow, 0);

            listView = (ListView) findViewById(R.id.myListView);

            listView.setAdapter(myCursorAdapter);
               // mDbHelper.close();
            //  myCursorAdapter.notifyDataSetChanged();




            listView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                bd.Wyswietl().moveToPosition(position);
                int rowId = bd.Wyswietl().getInt(bd.Wyswietl().getColumnIndexOrThrow("_id"));

                Intent outData = new Intent();

                setResult(Activity.RESULT_OK, outData);
                finish();







                        mDbHelper.removee( id);
                       // mDbHelper.getReadableDatabase();
                   // mDbHelper.close();
                        myCursorAdapter.notifyDataSetChanged();
                    mDbHelper.close();



                        // pokazanie wiecej informacji i wlasciwosci

                    Intent registerIntent = new Intent(ActivityListView.this,
                            ActivityItem.class);

                    registerIntent.putExtra("_id", position);
                    startActivity(registerIntent);



                    //Intent inten = new Intent(this, ActivityDodajMonete.class);
                    //  startActivity(inten);
                }
            });










            listView.setOnClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   // Intent intent = new Intent(this, ActivityItem.class);
                    Intent myIntent = new Intent(view.getContext(), ActivityItem.class);
                    startActivity(myIntent);
                   // intent.putExtra("item-identifier", id);
                   // startActivity(intent);
                }
            });

            */
        }



}

