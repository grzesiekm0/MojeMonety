package com.example.grzegorzmacko.mojemonety;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityUpdate extends AppCompatActivity {


    bazadanych  db;

    EditText editid, editwaluta, editkrajpochodzenia, editrok, editnominal, editksztalt, editmetal, editstopmetalu, editwaga, editsrednica, editwartosc;
    Button B1;




    int editrook, editnom, editwag,editsre,editwar, editidd;


// przypisanie zmiennym odpowienie edittexty
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        db = new bazadanych(this);

        editwaluta = (EditText)findViewById(R.id.edit_waluta);
        editkrajpochodzenia = (EditText)findViewById(R.id.edit_kraj_pochodzenia);
        editrok = (EditText)findViewById(R.id.edit_rok);
        editid = (EditText)findViewById(R.id.edit_id);
        // int editrook = Integer.parseInt(editrok.getText().toString());

        editnominal = (EditText)findViewById(R.id.edit_nominal);
        editksztalt = (EditText)findViewById(R.id.edit_ksztalt);
        editmetal = (EditText)findViewById(R.id.edit_metal);
        editstopmetalu = (EditText)findViewById(R.id.edit_stop_metalu);
        editwaga = (EditText)findViewById(R.id.edit_waga);
        editsrednica = (EditText)findViewById(R.id.edit_srednica);
        editwartosc = (EditText)findViewById(R.id.edit_wartosc);
        B1 = (Button) findViewById(R.id.button4);


// Metoda tej klasy dodajaca zmieniona monete do bazy
        AddData();
// wyswietlenie wynikow w aktivity
        TextView tv = (TextView) findViewById(R.id.textView3);

        bazadanych db = new bazadanych(this);

        Cursor kursor = db.Wyswietl();
        while (kursor.moveToNext()) {
            int id = kursor.getInt(0);
            String waluta = kursor.getString(1);
            int rok = kursor.getInt(2);
            String ksztalt = kursor.getString(3);
            String metal = kursor.getString(4);
            String stop_metalu = kursor.getString(5);
            String kraj_pochodzenia = kursor.getString(6);
            int nominal = kursor.getInt(7);
            int waga = kursor.getInt(8);
            int srednica = kursor.getInt(9);
            int wartosc = kursor.getInt(10);


            tv.setText(tv.getText() + "\n Id: " + id + "\n Rok: " + rok + "\n Waluta: "
                    + waluta + "\n Ksztalt: " + ksztalt + " \n Metal: " + metal + "\n Stop metalu: " + stop_metalu + "\n Kraj pochodzenia: " + kraj_pochodzenia + "\n Nominal: "
                    + nominal + "\n Waga: " + waga + "\n Srednica " + srednica + "\n Wartosc: " + wartosc+"\n");
            db.close();
        }

    }



    public void AddData() {
        // final int  editrook = Integer.parseInt(editrok.getText().toString());
        // int editnom = Integer.parseInt(editnominal.getText().toString());
        // int editwag = Integer.parseInt(editwaga.getText().toString());
        // int editsre = Integer.parseInt(editsrednica.getText().toString());

        // int editwar = Integer.parseInt(editwartosc.getText().toString());

        try {
            B1.setOnClickListener(
                    new View.OnClickListener() {


                        @Override
                        public void onClick(View v) {



                            boolean czy_dodalo = db.DodajMonete(editwaluta.getText().toString(),
                                    editrook = Integer.parseInt(editrok.getText().toString()),
                                    editksztalt.getText().toString(),
                                    editmetal.getText().toString(),
                                    editstopmetalu.getText().toString(),
                                    editkrajpochodzenia.getText().toString(),
                                    editnom = Integer.parseInt(editnominal.getText().toString()),
                                    editwag = Integer.parseInt(editwaga.getText().toString()),
                                    editsre = Integer.parseInt(editsrednica.getText().toString()),
                                    editwar = Integer.parseInt(editwartosc.getText().toString()));
                            if (czy_dodalo = true) {

                                Toast.makeText(ActivityUpdate.this, "Dodano", Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(ActivityUpdate.this, "Nie dodano", Toast.LENGTH_LONG).show();

                        }
                    }
            );


        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatedata(View view){
        boolean czy_dodaloo = db.updatedata( editidd = Integer.parseInt(editid.getText().toString()),
                editwaluta.getText().toString(),
                editrook = Integer.parseInt(editrok.getText().toString()),
                editksztalt.getText().toString(),
                editmetal.getText().toString(),
                editstopmetalu.getText().toString(),
                editkrajpochodzenia.getText().toString(),
                editnom = Integer.parseInt(editnominal.getText().toString()),
                editwag = Integer.parseInt(editwaga.getText().toString()),
                editsre = Integer.parseInt(editsrednica.getText().toString()),
                editwar = Integer.parseInt(editwartosc.getText().toString()));
        if (czy_dodaloo = true) {

            Toast.makeText(ActivityUpdate.this, "Sukces", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(ActivityUpdate.this, "Nie zaktualizowano", Toast.LENGTH_LONG).show();

    }

}