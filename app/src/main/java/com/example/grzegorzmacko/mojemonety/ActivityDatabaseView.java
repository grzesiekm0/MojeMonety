package com.example.grzegorzmacko.mojemonety;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityDatabaseView extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_view);
        TextView tv = (TextView) findViewById(R.id.textView2);



        bazadanych bd = new bazadanych(this);


        Cursor kursor = bd.Wyswietl();
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
            bd.close();
        }







    }


}





