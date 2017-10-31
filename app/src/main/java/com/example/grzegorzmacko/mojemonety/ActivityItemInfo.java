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

    int pozycja;


    Bundle extras;
    String delete;
    Button button_edit=null;
    Button update = null;
    EditText waluta, rok, wartosc, srednica, kraj_pochodzenia, ksztalt, metal, stop_metalu, nominal, waga;
    TextView idd , tv, tu, tq , tw , te, tr;
    LinearLayout rel;



    ArrayList<moneta> listItems;

    // database
    FeedReaderDbHelper mDbHelper;




    // list of todo titles
    ArrayList<moneta> newData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);



        //dostep do bazy danych
        final FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
        // pobieranie wszystkich danych do arraylist
        listItems = mDbHelper.getAllNotes();
        //przypisanie do zmiennej arraylist z typem obiektu "moenta"
        newData = new ArrayList<moneta>();

        // Assigning the title to our global property so we can access it
        // later after certain actions (deleting/adding)
        for (moneta mon : listItems) {
            newData.add(mon);
        }
        extras = getIntent().getExtras();
        pozycja = (int)extras.getInt("_id");

         // zaczepienie kontrolek do wyswietlenia pol
        TextView passedView = (TextView) findViewById(R.id.textViewIdd);
         idd = (TextView) findViewById(R.id.textView10);
         tv = (TextView) findViewById(R.id.textViewWalutaa);
         tu = (TextView) findViewById(R.id.textView4);
         tq = (TextView) findViewById(R.id.textView6);
         tw = (TextView) findViewById(R.id.textView7);
         te = (TextView) findViewById(R.id.textView8);
         tr = (TextView) findViewById(R.id.textView9);
             // do obiekty mon przypisujemy konkretny obiekt z naszej listy
        final moneta mon = listItems.get(pozycja);
        // ustawianie konkretnych pol do kontrolek textview
        idd.setText(String.valueOf(mon.getId()));
        tv.setText(mon.getWaluta());
        tu.setText(mon.getKraj_pochodzenia());
        tq.setText(mon.getKsztalt());
        tw.setText(mon.getMetal());
        te.setText(String.valueOf(mon.getRok()));
        tr.setText(mon.getStop_metalu());

        /*
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         View v = vi.inflate(R.layout.activity_item_info, null);



// fill in any details dynamically here
        TextView textView = (TextView) v.findViewById(R.id.textView12);
        textView.setText("your text");

// insert into main view
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.obszar);
        ((ViewGroup) insertPoint).addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));



        button_edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ViewGroup container = (ViewGroup) v.getParent();
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View addView = inflater.inflate(R.layout.activity_item_info_edit);
                container.addView(addView);
            }
        });

        */
        //int i =20;
        //zaczepienie kontrolki przycisku edytuj ktory dodaje dynamicznie pola do edycji
        button_edit = (Button) findViewById(R.id.button_edit);
        button_edit.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            public void onClick(View v) {
                // zaczepiamy obszar do ktorego chcemy dodac nasze pola
                 rel = (LinearLayout) findViewById(R.id.zobaczymy);

                //wylaczamy przycisk "edytuj" po kliknieciu
                button_edit.setEnabled(false);

                final EditText waluta = new EditText(ActivityItemInfo.this);
                waluta.setId(i);
                int  a = waluta.getId();
                // pobieramy wartosc z naszego obiektu i ustawiamy go do pola edycji
                waluta.setText(mon.getWaluta()+"");
                // ustalamy parametry dynamicznie dodanego pola
                LinearLayout.LayoutParams o = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
               // dodajemy do widoku nazwe kontrolki oraz zmienna z przypisanymi parametrami
                rel.addView(waluta, o);

                final EditText wartosc = new EditText(ActivityItemInfo.this);
                wartosc.setId(++i);
                a = wartosc.getId();
                wartosc.setText(mon.getWartosc()+"");
                LinearLayout.LayoutParams u = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(wartosc, u);

                 rok = new EditText(ActivityItemInfo.this);
                rok.setId(++i);
                a = rok.getId();
                rok.setText(mon.getRok()+"");
                LinearLayout.LayoutParams y = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(rok, y);

                 ksztalt = new EditText(ActivityItemInfo.this);
                ksztalt.setId(++i);
                a = ksztalt.getId();
                ksztalt.setText(mon.getKsztalt()+"");
                LinearLayout.LayoutParams t = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(ksztalt, t);

                 metal = new EditText(ActivityItemInfo.this);
                metal.setId(++i);
                a = metal.getId();
                metal.setText(mon.getMetal()+"");
                LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(metal, r);

                stop_metalu = new EditText(ActivityItemInfo.this);
                stop_metalu.setId(++i);
                a = stop_metalu.getId();
                stop_metalu.setText(mon.getStop_metalu()+"");
                LinearLayout.LayoutParams e = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(stop_metalu, e);

                 kraj_pochodzenia = new EditText(ActivityItemInfo.this);
                kraj_pochodzenia.setId(++i);
                a = kraj_pochodzenia.getId();
                kraj_pochodzenia.setText(mon.getKraj_pochodzenia()+"");
                LinearLayout.LayoutParams w = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(kraj_pochodzenia, w);

                 nominal = new EditText(ActivityItemInfo.this);
                nominal.setId(++i);
                a = nominal.getId();
                nominal.setText(mon.getNominal()+"");
                LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(nominal, q);

                 waga = new EditText(ActivityItemInfo.this);
                waga.setId(++i);
                a = waga.getId();
                waga.setText(mon.getWaga()+"");
                LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(waga, l);

                 srednica = new EditText(ActivityItemInfo.this);
                srednica.setId(++i);
                a = srednica.getId();
                srednica.setText(mon.getSrednica()+"");
                LinearLayout.LayoutParams k = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(srednica, k);

                // tworzymy przycisk zapisujacy zmiany
                final Button mciv = new Button(ActivityItemInfo.this);
                mciv.setId(++i);
                a = mciv.getId();
                mciv.setText(""+String.valueOf(a));
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                rel.addView(mciv, p);
                // obsluga zdarzenia klikniecia przycisku
                // ktory wywoluje metode na obiekcie obslugujacego polaczenie z baza danych w tym przypadku
                // metode ktora aktualizuje rekord pobierajac w argumentach z pol edycji dane 
                mciv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // newData.set(pozycja,   );
                        boolean itsok = mDbHelper.AktualizujMonete(mon.getId(), waluta.getText().toString(), Integer.parseInt(rok.getText().toString()),
                                ksztalt.getText().toString(), metal.getText().toString(),stop_metalu.getText().toString(),
                                kraj_pochodzenia.getText().toString(),Integer.parseInt(nominal.getText().toString()),
                                        Integer.parseInt(waga.getText().toString()),Integer.parseInt(srednica.getText().toString()),
                                                Integer.parseInt(wartosc.getText().toString()));

                        // ustawienie parametrow obiektu nowymi wartosciami
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
                        // przypisanie wartosci do kontrolek textview kollejny raz aby tez sie zaktualizowaly
                        idd.setText(String.valueOf(mon.getId()));
                        tv.setText(mon.getWaluta());
                        tu.setText(mon.getKraj_pochodzenia());
                        tq.setText(mon.getKsztalt());
                        tw.setText(mon.getMetal());
                        te.setText(String.valueOf(mon.getRok()));
                        tr.setText(mon.getStop_metalu());


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




                        if(itsok=true) {
                            Toast.makeText(ActivityItemInfo.this, "ok", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(ActivityItemInfo.this, "not ok", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }

        });
    }
}
