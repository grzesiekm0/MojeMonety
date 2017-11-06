package com.example.grzegorzmacko.mojemonety;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityItemInfo extends AppCompatActivity {


    //Variables fields, edit fields and more
    int pozycja;
    Bundle extras;
    Button button_edit = null;
    Button mciv = null;
    EditText waluta, rok, wartosc, srednica, kraj_pochodzenia, ksztalt, metal, stop_metalu, nominal, waga;
    TextView idd, tv, tu, tq, tw, te, tr;
    LinearLayout rel;


    // Global variable database for DataBase connection
    FeedReaderDbHelper mDbHelper;

    // Variable coin
    moneta mon;

    // Global variable ListViewActivity;
    ListViewActivity LVA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        // New instant object ListViewActivity for variables ArrayList
        LVA = new ListViewActivity();



        //Database class instance
         mDbHelper = new FeedReaderDbHelper(this);

        // //Collect all the coins
        LVA.listItems = mDbHelper.getAllNotes();

        //Create an ArrayList for MySimpleArrayAdapter
        LVA.newData = new ArrayList<moneta>();

        // Assigning coins to our global property so we can access it
        // later after certain actions (deleting/adding)
        for (moneta mon : LVA.listItems) {
            LVA.newData.add(mon);
        }

        //Catch ID item
        extras = getIntent().getExtras();
        pozycja = (int) extras.getInt("_id");

        // liking fields with xml file
        TextView passedView = (TextView) findViewById(R.id.textViewIdd);
        idd = (TextView) findViewById(R.id.textView10);
        tv = (TextView) findViewById(R.id.textViewWalutaa);
        tu = (TextView) findViewById(R.id.textView4);
        tq = (TextView) findViewById(R.id.textView6);
        tw = (TextView) findViewById(R.id.textView7);
        te = (TextView) findViewById(R.id.textView8);
        tr = (TextView) findViewById(R.id.textView9);

        // Retrieving the selected object
         mon = LVA.listItems.get(pozycja);

       // Setting object properties
        idd.setText(String.valueOf(mon.getId()));
        tv.setText(mon.getWaluta());
        tu.setText(mon.getKraj_pochodzenia());
        tq.setText(mon.getKsztalt());
        tw.setText(mon.getMetal());
        te.setText(String.valueOf(mon.getRok()));
        tr.setText(mon.getStop_metalu());


        //Adding view elements to view dynamically when click the button
        button_edit = (Button) findViewById(R.id.button_edit);
        button_edit.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            public void onClick(View v) {
                // We are going to add our area where we want to add the elements of the view
                rel = (LinearLayout) findViewById(R.id.zobaczymy);

                //Button sets the button off when clicked
                button_edit.setEnabled(false);

                // Liking fields with xml file and seting ID, seting properties coin,
                //seting properties ViewGroup elements and adding for view
                 waluta = new EditText(ActivityItemInfo.this);
                waluta.setId(i);
                waluta.setText(mon.getWaluta() + "");
                LinearLayout.LayoutParams o = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(waluta, o);

                 wartosc = new EditText(ActivityItemInfo.this);
                wartosc.setId(++i);
                wartosc.setText(mon.getWartosc() + "");
                LinearLayout.LayoutParams u = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(wartosc, u);

                rok = new EditText(ActivityItemInfo.this);
                rok.setId(++i);
                rok.setText(mon.getRok() + "");
                LinearLayout.LayoutParams y = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(rok, y);

                ksztalt = new EditText(ActivityItemInfo.this);
                ksztalt.setId(++i);
                ksztalt.setText(mon.getKsztalt() + "");
                LinearLayout.LayoutParams t = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(ksztalt, t);

                metal = new EditText(ActivityItemInfo.this);
                metal.setId(++i);
                metal.setText(mon.getMetal() + "");
                LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(metal, r);

                stop_metalu = new EditText(ActivityItemInfo.this);
                stop_metalu.setId(++i);
                stop_metalu.setText(mon.getStop_metalu() + "");
                LinearLayout.LayoutParams e = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(stop_metalu, e);

                kraj_pochodzenia = new EditText(ActivityItemInfo.this);
                kraj_pochodzenia.setId(++i);
                kraj_pochodzenia.setText(mon.getKraj_pochodzenia() + "");
                LinearLayout.LayoutParams w = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(kraj_pochodzenia, w);

                nominal = new EditText(ActivityItemInfo.this);
                nominal.setId(++i);
                nominal.setText(mon.getNominal() + "");
                LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(nominal, q);

                waga = new EditText(ActivityItemInfo.this);
                waga.setId(++i);
                waga.setText(mon.getWaga() + "");
                LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(waga, l);

                srednica = new EditText(ActivityItemInfo.this);
                srednica.setId(++i);
                srednica.setText(mon.getSrednica() + "");
                LinearLayout.LayoutParams k = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(srednica, k);

                 mciv = new Button(ActivityItemInfo.this);
                mciv.setId(++i);
                mciv.setText("Dodaj");
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(mciv, p);

                //Click event handler
                mciv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Database update method
                        boolean itsok = mDbHelper.AktualizujMonete(mon.getId(), waluta.getText().toString(), Integer.parseInt(rok.getText().toString()),
                                ksztalt.getText().toString(), metal.getText().toString(), stop_metalu.getText().toString(),
                                kraj_pochodzenia.getText().toString(), Integer.parseInt(nominal.getText().toString()),
                                Integer.parseInt(waga.getText().toString()), Integer.parseInt(srednica.getText().toString()),
                                Integer.parseInt(wartosc.getText().toString()));

                        // Setting new properties coin
                        mon.setWaluta(waluta.getText().toString());
                        mon.setRok(Integer.valueOf(rok.getText().toString()));
                        mon.setKsztalt(ksztalt.getText().toString());
                        mon.setMetal(metal.getText().toString());
                        mon.setStop_metalu(stop_metalu.getText().toString());
                        mon.setKraj_pochodzenia(kraj_pochodzenia.getText().toString());
                        mon.setNominal(Integer.valueOf(nominal.getText().toString()));
                        mon.setWaga(Integer.valueOf(waga.getText().toString()));
                        mon.setSrednica(Integer.valueOf(srednica.getText().toString()));
                        mon.setWartosc(Integer.valueOf(wartosc.getText().toString()));

                        // Setting EditText fields,
                        //Fields update
                        idd.setText(String.valueOf(mon.getId()));
                        tv.setText(mon.getWaluta());
                        tu.setText(mon.getKraj_pochodzenia());
                        tq.setText(mon.getKsztalt());
                        tw.setText(mon.getMetal());
                        te.setText(String.valueOf(mon.getRok()));
                        tr.setText(mon.getStop_metalu());

                        //Disable the view item
                        waluta.setVisibility(View.GONE);
                        rok.setVisibility(View.GONE);
                        ksztalt.setVisibility(View.GONE);
                        metal.setVisibility(View.GONE);
                        stop_metalu.setVisibility(View.GONE);
                        kraj_pochodzenia.setVisibility(View.GONE);
                        nominal.setVisibility(View.GONE);
                        waga.setVisibility(View.GONE);
                        srednica.setVisibility(View.GONE);
                        wartosc.setVisibility(View.GONE);
                        mciv.setVisibility(View.GONE);
                        button_edit.setEnabled(true);

                        // Displaying the toast message
                        if (itsok = true) {
                            Toast.makeText(ActivityItemInfo.this, "ok", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ActivityItemInfo.this, "not ok", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }

        });
    }
}
