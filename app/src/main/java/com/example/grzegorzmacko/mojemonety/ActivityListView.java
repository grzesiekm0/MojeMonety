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
    bazadanych bd;
    ListView listView;
    SimpleCursorAdapter myCursorAdapter;
    CursorAdapter CuAd;
    Bundle wstecz;
   // long id;

    // Out custom adapter
    //MySimpleArrayAdapter adapter;


    // contains our listview items
    ArrayList<moneta> listItems;

    // database
    FeedReaderDbHelper mDbHelper;

    MySimpleArrayAdapter adapter;


    // list of todo titles
    ArrayList<moneta> newData;

    // contains the id of the item we are about to delete
    public int deleteItem;
    public int select_item;

    // EditText field for adding new items to the list
   // EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

      //  moneta mon = new moneta();

         mDbHelper = new FeedReaderDbHelper(this);
        listView = (ListView) findViewById(R.id.myListView);

        listItems = mDbHelper.getAllNotes();

        newData = new ArrayList<moneta>();

        // Assigning the title to our global property so we can access it
        // later after certain actions (deleting/adding)
        for ( moneta mon : listItems) {
            newData.add(mon);
        }

         adapter = new MySimpleArrayAdapter(this, newData);

        // Assigning the adapter to ListView
        listView.setAdapter(adapter);



            // przekierowanie na widok z informacjami rekordu
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                select_item = position;

                Intent registerIntent = new Intent(ActivityListView.this,
                        ActivityItemInfo.class);

                registerIntent.putExtra("_id", select_item);
                startActivity(registerIntent);


            }
        });

       // listView.setOnItemLongClickListener(myClickListener);
       // populateListView();

        // obsluga zdarzzenia dlugiego klikniecia
        // w tym wypadku usuniecia z oknem AlertDialog
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
                                        // Retrieving the note from our listItems
                                        // property, which contains all notes from
                                        // our database



                                        moneta mon = listItems.get(deleteItem);

                                        // Deleting it from the ArrayList<string>
                                        // property which is linked to our adapter
                                        newData.remove(deleteItem);

                                        // Deleting the note from our database
                                       // mon.setWaluta("Grz");

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

    @Override
    public void onResume() {
        super.onResume();
      //  moneta mon = new moneta();
        // --------------------------------
        newData.clear();
// tu skonczylem

     listItems.addAll(odswiezArrayListAdaptera());
        
        adapter.notifyDataSetChanged();

    }
// metoda odswiezajaca liste adaptera
    public ArrayList<moneta> odswiezArrayListAdaptera(){
        //pobranie do listy danych z bazy danych
        listItems = mDbHelper.getAllNotes();
        //wyczyszczenie listy uzywanej przez listview adapter
        newData.clear();
        //skopiowanie obiektow
        for ( moneta mon : listItems) {
            newData.add(mon);
        }
        //zwrocenie zaktualizowanej listy
        return newData;
    }
    // trzeba to po angielsku

    public static class MySimpleArrayAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final ArrayList<moneta> values;
        //custom  adapter ArrayList, w ktorym przechowuje obiekty "moneta"
        public MySimpleArrayAdapter(Context context, ArrayList objects) {
            super(context, R.layout.activity_item, objects);

            this.context = context;
            values = objects;

        }

        /**
         * Here we go and get our rowlayout.xml file and set the textview text.
         * This happens for every row in your listview.
         */
        @Override  // przysloneicie metody get view
        //w ktorym list view napelnia sie widokiem activity item
        public View getView(int position, View convertView, ViewGroup parent) {

            // assign the view we are converting to a local variable
            View v = convertView;

            // first check to see if the view is null. if so, we have to inflate it.
            // to inflate it basically means to render, or show, the view.
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.activity_item, null);



            }




            // zaczepianie kontrolek
            TextView textView = (TextView) v.findViewById(R.id.textViewIdd);
            TextView idd = (TextView) v.findViewById(R.id.textView10);
            TextView tq = (TextView) v.findViewById(R.id.textView6);

                //uzyskanie odpowiedniego obiektu
            moneta mon =  values.get(position);

            idd.setText(String.valueOf(mon.getId()));
            textView.setText(mon.getWaluta());
            tq.setText(mon.getKraj_pochodzenia());
            return v;
        }
    }

        private void populateListView () {
          //  bd = new bazadanych(this);
            // populateListView();

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
              /*  bd.Wyswietl().moveToPosition(position);
                int rowId = bd.Wyswietl().getInt(bd.Wyswietl().getColumnIndexOrThrow("_id"));

                Intent outData = new Intent();

                setResult(Activity.RESULT_OK, outData);
                finish();
                */






                        mDbHelper.removee( id);
                       // mDbHelper.getReadableDatabase();
                   // mDbHelper.close();
                        myCursorAdapter.notifyDataSetChanged();
                    mDbHelper.close();



                    /*    // pokazanie wiecej informacji i wlasciwosci

                    Intent registerIntent = new Intent(ActivityListView.this,
                            ActivityItem.class);

                    registerIntent.putExtra("_id", position);
                    startActivity(registerIntent);
                    */


                    //Intent inten = new Intent(this, ActivityDodajMonete.class);
                    //  startActivity(inten);
                }
            });








/*

            listView.setOnClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   // Intent intent = new Intent(this, ActivityItem.class);
                    Intent myIntent = new Intent(view.getContext(), ActivityItem.class);
                    startActivity(myIntent);
                   // intent.putExtra("item-identifier", id);
                   // startActivity(intent);
                }
            });*/
        }



}

