package com.example.grzegorzmacko.mojemonety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class AddCoinActivity extends AppCompatActivity {

    LinearLayout pole;
    Button mciv = null;
    EditText waluta, rok, wartosc, srednica, kraj_pochodzenia, ksztalt, metal, stop_metalu, nominal, waga;

    moneta mon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coin);



        pole = (LinearLayout) findViewById(R.id.pole);

        int i=0;
        waluta = new EditText(AddCoinActivity.this);
        waluta.setId(i);
        waluta.setText(String.valueOf(i));
        LinearLayout.LayoutParams o = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(waluta, o);

       // ViewGroup.LayoutParams oo = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
       // waluta.setLayoutParams(o);

        wartosc = new EditText(AddCoinActivity.this);
        wartosc.setId(++i);
        wartosc.setText(String.valueOf(i));
        LinearLayout.LayoutParams u = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(wartosc, u);
        //wartosc.setLayoutParams(u);

        rok = new EditText(AddCoinActivity.this);
        rok.setId(++i);
        rok.setText(String.valueOf(i));
        LinearLayout.LayoutParams y = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(rok, y);
       // rok.setLayoutParams(y);

        ksztalt = new EditText(AddCoinActivity.this);
        ksztalt.setId(++i);
        ksztalt.setText(String.valueOf(i));
        LinearLayout.LayoutParams t = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(ksztalt, t);
       // ksztalt.setLayoutParams(t);

        metal = new EditText(AddCoinActivity.this);
        metal.setId(++i);
        metal.setText(String.valueOf(i));
        LinearLayout.LayoutParams r = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(metal, r);
        //metal.setLayoutParams(r);

        stop_metalu = new EditText(AddCoinActivity.this);
        stop_metalu.setId(++i);
        stop_metalu.setText(String.valueOf(i));
        LinearLayout.LayoutParams e = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(stop_metalu, e);
       // stop_metalu.setLayoutParams(e);


        kraj_pochodzenia = new EditText(AddCoinActivity.this);
        kraj_pochodzenia.setId(++i);
        kraj_pochodzenia.setText(String.valueOf(i));
        LinearLayout.LayoutParams w = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(kraj_pochodzenia, w);
        //kraj_pochodzenia.setLayoutParams(w);


        nominal = new EditText(AddCoinActivity.this);
        nominal.setId(++i);
        nominal.setText(String.valueOf(i));
        LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(nominal, q);
        //nominal.setLayoutParams(q);


        waga = new EditText(AddCoinActivity.this);
        waga.setId(++i);
        waga.setText(String.valueOf(i));
        LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(waga, l);
        //waga.setLayoutParams(l);


        srednica = new EditText(AddCoinActivity.this);
        srednica.setId(++i);
        srednica.setText(String.valueOf(i));
        LinearLayout.LayoutParams k = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
       pole.addView(srednica, k);
       // srednica.setLayoutParams(k);


        mciv = new Button(AddCoinActivity.this);
        mciv.setId(++i);
        mciv.setText("Dodaj");
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        pole.addView(mciv, p);
        //wartosc.setLayoutParams(p);
    }
}
