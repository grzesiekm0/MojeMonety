package com.example.grzegorzmacko.mojemonety;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ActivityItem extends AppCompatActivity {
    TextView passedView = null;
    bazadanych bd;


    int pozycja;


    Bundle extras;
    String delete;

    ArrayList<moneta> listItems;

    // database
    FeedReaderDbHelper mDbHelper;


    // list of todo titles
    ArrayList<moneta> newData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        final FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);

        listItems = mDbHelper.getAllNotes();

        newData = new ArrayList<moneta>();

        // Assigning the title to our global property so we can access it
        // later after certain actions (deleting/adding)
        for (moneta mon : listItems) {
            newData.add(mon);
        }
        extras = getIntent().getExtras();
        pozycja = (int) extras.getInt("_id");


        passedView = (TextView) findViewById(R.id.textViewIdd);
        TextView idd = (TextView) findViewById(R.id.textView10);
        TextView tv = (TextView) findViewById(R.id.textViewWalutaa);
        TextView tu = (TextView) findViewById(R.id.textView4);
        TextView tq = (TextView) findViewById(R.id.textView6);
        TextView tw = (TextView) findViewById(R.id.textView7);
        TextView te = (TextView) findViewById(R.id.textView8);
        TextView tr = (TextView) findViewById(R.id.textView9);

        moneta mon = listItems.get(pozycja);
        /*
        idd.setText(String.valueOf(mon.getId()));
        tv.setText(mon.getWaluta());
        tu.setText(mon.getKraj_pochodzenia());
        tq.setText(mon.getKsztalt());
        tw.setText(mon.getMetal());
        te.setText(String.valueOf(mon.getRok()));
        tr.setText(mon.getStop_metalu());
            */


        // DeleteData();


        if (extras != null) {
            //Here you get the id from the item

            passedView.setText("kliknales " + pozycja);

            //   moneta mon = listItems.get(deleteItem);


        }

        // btnDeleteData = (Button) findViewById(R.id.button_usun);





/*
    public void DeleteData() {


        try {
            btnDeleteData.setOnClickListener(
                    new View.OnClickListener() {


                        @Override
                        public void onClick(View v) {

                            int pozycja;
                            Bundle extras = getIntent().getExtras();

                            boolean czy_usunelo = bd.Usun(
                                    pozycja= (int)extras.getInt("_id")
                            );
                            if (czy_usunelo = true) {

                                Toast.makeText(ActivityItem.this, "Usunieto id=", Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(ActivityItem.this, "Nie usunieto", Toast.LENGTH_LONG).show();

                        }
                    }
            );


        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
/*
        Cursor c=null;
        c= bd.wyswietlWszystkieRekordy();
        if(c.getCount()>0)
        {
            for(int j=0;j<c.getCount();j++)
            {
                c.moveToPosition(chosenPosition);
                moneta cw = new moneta();
                cw.id=c.getLong(0);
                cw.name=c.getString(1);
                cw.phone=c.getString(2);
                cw.web=c.getString(3);
                cw.address=c.getString(4);
                cw.des=c.getString(5);
                cw.qual=c.getString(6);
                cw.doj=c.getString(7);
                cw.sal=c.getString(8);
                if(cw.des.equalsIgnoreCase("Designer"))
                {
                    designers.add(cw);
                }
            }
        }
        c.close();
        db.close();
*/

//Here you use the id to get the object from your database or whatever
        //  chosenObject =bd.Wyswietl(chosenPosition+ 1);


    }
}



