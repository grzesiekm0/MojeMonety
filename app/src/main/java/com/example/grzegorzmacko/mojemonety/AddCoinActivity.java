package com.example.grzegorzmacko.mojemonety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class AddCoinActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    EditText waluta, rok, wartosc, srednica, kraj_pochodzenia, ksztalt, metal, stop_metalu, nominal, waga;
    int int_rok, int_nominal, int_waga, int_srednica, int_wartosc;
    AwesomeValidation awesomeValidation;
    FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coin);

        // new instant AV
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //initializing view objects
        submit = (Button) findViewById(R.id.Submit);
        waluta = (EditText) findViewById(R.id.editWaluta);
        rok = (EditText) findViewById(R.id.editRok);
        wartosc = (EditText) findViewById(R.id.editWartosc);
        srednica = (EditText) findViewById(R.id.editSrednica);
        kraj_pochodzenia = (EditText) findViewById(R.id.editKrajPochodzenia);
        ksztalt = (EditText) findViewById(R.id.editKsztalt);
        metal = (EditText) findViewById(R.id.editMetal);
        stop_metalu = (EditText) findViewById(R.id.editStopMetalu);
        nominal = (EditText) findViewById(R.id.editNominal);
        waga = (EditText) findViewById(R.id.editWaga);

         //adding the validation to required EditTexts using addValidation() method with AwesomeValidation object
        awesomeValidation.addValidation(this, R.id.editWaluta, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editRok, Range.closed(0, 2050), R.string.ageerror);
        awesomeValidation.addValidation(this, R.id.editWartosc, Range.closed(1, 1000000), R.string.ageerror);
        awesomeValidation.addValidation(this, R.id.editSrednica, Range.closed(1, 100), R.string.ageerror);
        awesomeValidation.addValidation(this, R.id.editKrajPochodzenia, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.ageerror);
        awesomeValidation.addValidation(this, R.id.editKsztalt, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editMetal, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editStopMetalu, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editNominal, Range.closed(1, 100000), R.string.ageerror);
        awesomeValidation.addValidation(this, R.id.editWaga, Range.closed(1, 1000), R.string.ageerror);

        submit.setOnClickListener(this);

    }

    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();

            //Adding to database
            mDbHelper.DodajMonetee(waluta.getText().toString(),
                    int_rok = Integer.parseInt(rok.getText().toString()),
                    ksztalt.getText().toString(),
                    metal.getText().toString(),
                    stop_metalu.getText().toString(),
                    kraj_pochodzenia.getText().toString(),
                    int_nominal = Integer.parseInt(nominal.getText().toString()),
                    int_waga = Integer.parseInt(waga.getText().toString()),
                    int_srednica = Integer.parseInt(srednica.getText().toString()),
                    int_wartosc = Integer.parseInt(wartosc.getText().toString()));

            mDbHelper.close();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == submit) {
            submitForm();
        }
    }

}
