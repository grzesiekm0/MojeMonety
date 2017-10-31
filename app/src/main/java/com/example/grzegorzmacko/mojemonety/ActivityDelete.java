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

public class ActivityDelete extends AppCompatActivity {
    bazadanych  db;
    EditText editusunidd;
    Button btnDeleteData;
    int editusun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new bazadanych(this);
        editusunidd = (EditText)findViewById(R.id.editusunid);
        btnDeleteData = (Button) findViewById(R.id.button8);
        //DeleteData();


        TextView tv = (TextView) findViewById(R.id.textView5);

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
/*
    public void DeleteData() {


        try {
            btnDeleteData.setOnClickListener(
                    new View.OnClickListener() {


                        @Override
                        public void onClick(View v) {



                            boolean czy_usunelo = db.Usun(
                                    //editusun = Integer.parseInt(editusunidd.getText().toString())
                               //     editusun = editusunidd.getText()
                            );
                            if (czy_usunelo = true) {

                                Toast.makeText(ActivityDelete.this, "Usunieto", Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(ActivityDelete.this, "Nie usunieto", Toast.LENGTH_LONG).show();

                        }
                    }
            );


        }
        catch(SQLException e) {
            e.printStackTrace();
        } */
    }








