package com.example.grzegorzmacko.mojemonety;

import android.content.Context;
import android.database.SQLException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityDodajMonete extends AppCompatActivity {

   // bazadanych  db;

    EditText editwaluta, editkrajpochodzenia, editrok, editnominal, editksztalt, editmetal, editstopmetalu, editwaga, editsrednica, editwartosc;
    Button btnAddData;




    int editrook, editnom, editwag,editsre,editwar;


    FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_monete);
        //db = new bazadanych(this);
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
        editwaluta = (EditText)findViewById(R.id.edit_waluta);
        editkrajpochodzenia = (EditText)findViewById(R.id.edit_kraj_pochodzenia);
        editrok = (EditText)findViewById(R.id.edit_rok);



        editnominal = (EditText)findViewById(R.id.edit_nominal);
        editksztalt = (EditText)findViewById(R.id.edit_ksztalt);
        editmetal = (EditText)findViewById(R.id.edit_metal);
        editstopmetalu = (EditText)findViewById(R.id.edit_stop_metalu);
        editwaga = (EditText)findViewById(R.id.edit_waga);
        editsrednica = (EditText)findViewById(R.id.edit_srednica);
        editwartosc = (EditText)findViewById(R.id.edit_wartosc);
        btnAddData = (Button) findViewById(R.id.button_dodaj);



        AddData();
    }

    @Override
    protected void onDestroy() {
        mDbHelper.close();
        super.onDestroy();
    }



    public void AddData() {

        try {
            btnAddData.setOnClickListener(
                    new View.OnClickListener() {


                        @Override
                        public void onClick(View v) {



                            boolean czy_dodalo = mDbHelper.DodajMonetee(editwaluta.getText().toString(),
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

                                Toast.makeText(ActivityDodajMonete.this, "Dodano", Toast.LENGTH_LONG).show();
                                mDbHelper.close();
                            } else
                                Toast.makeText(ActivityDodajMonete.this, "Nie dodano", Toast.LENGTH_LONG).show();
mDbHelper.close();
                        }
                    }
            );


        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }


}

