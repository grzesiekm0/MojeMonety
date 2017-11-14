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


    int editrook, editnom, editwag, editsre, editwar;


    FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_monete);
        //db = new bazadanych(this);
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
        editwaluta = (EditText) findViewById(R.id.edit_waluta);
        editkrajpochodzenia = (EditText) findViewById(R.id.edit_kraj_pochodzenia);
        editrok = (EditText) findViewById(R.id.edit_rok);


        editnominal = (EditText) findViewById(R.id.edit_nominal);
        editksztalt = (EditText) findViewById(R.id.edit_ksztalt);
        editmetal = (EditText) findViewById(R.id.edit_metal);
        editstopmetalu = (EditText) findViewById(R.id.edit_stop_metalu);
        editwaga = (EditText) findViewById(R.id.edit_waga);
        editsrednica = (EditText) findViewById(R.id.edit_srednica);
        editwartosc = (EditText) findViewById(R.id.edit_wartosc);
        btnAddData = (Button) findViewById(R.id.button_dodaj);


        //try {
        AddData();
        //  } catch (Exception e) {
        //     System.err.print(e);
        // }
    }

    @Override
    protected void onDestroy() {
        mDbHelper.close();
        super.onDestroy();
    }


    public void AddData() {


        btnAddData.setOnClickListener(
                new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        boolean czy_dodalo;


                        if (editwaluta.getText().toString().isEmpty() || editwaluta.getText().toString().length() == 0 || editwaluta.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij nazwe waluty!", Toast.LENGTH_LONG).show();
                        }
                        if (editrok.getText().toString().isEmpty() || editrok.getText().toString().length() == 0 || editrok.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij rok monety!", Toast.LENGTH_LONG).show();
                        }
                        if (editksztalt.getText().toString().isEmpty() || editksztalt.getText().toString().length() == 0 || editksztalt.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij ksztalt monety", Toast.LENGTH_LONG).show();
                        }
                        if (editmetal.getText().toString().isEmpty() || editmetal.getText().toString().length() == 0 || editmetal.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij metal monety", Toast.LENGTH_LONG).show();
                        }
                        if (editstopmetalu.getText().toString().isEmpty() || editstopmetalu.getText().toString().length() == 0 || editstopmetalu.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij stop metalu monety", Toast.LENGTH_LONG).show();
                        }
                        if (editkrajpochodzenia.getText().toString().isEmpty() || editkrajpochodzenia.getText().toString().length() == 0 || editkrajpochodzenia.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij kraj pochodzenia monety", Toast.LENGTH_LONG).show();
                        }
                        if (editnominal.getText().toString().isEmpty() || editnominal.getText().toString().length() == 0 || editnominal.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij nominal monety", Toast.LENGTH_LONG).show();
                        }
                        if (editwaga.getText().toString().isEmpty() || editwaga.getText().toString().length() == 0 || editwaga.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij wage monety", Toast.LENGTH_LONG).show();
                        }
                        if (editsrednica.getText().toString().isEmpty() || editsrednica.getText().toString().length() == 0 || editsrednica.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij srednice monety", Toast.LENGTH_LONG).show();
                        }
                        if (editwartosc.getText().toString().isEmpty() || editwartosc.getText().toString().length() == 0 || editwartosc.getText().toString().equals("")) {
                            Toast.makeText(ActivityDodajMonete.this, "Uzupelnij wartosc monety", Toast.LENGTH_LONG).show();
                        }



                            czy_dodalo = mDbHelper.DodajMonetee(editwaluta.getText().toString(),
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
                        } else {

                            Toast.makeText(ActivityDodajMonete.this, "Nie dodano", Toast.LENGTH_LONG).show();
                            mDbHelper.close();
                        }

                    }


                }
        );


    }


}

