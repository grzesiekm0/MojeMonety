package com.example.grzegorzmacko.mojemonety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Buttons to turn on a new view.
    //Database view.
    public void btnNextActivity(View view){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    // Adding a coin.
    public void btnNextActivity2(View view){
        Intent intent = new Intent(this, ActivityDodajMonete.class);
        startActivity(intent);
    }

    public void btnNextActivity3(View view){
        Intent intent = new Intent(this, ActivityUpdate.class);
        startActivity(intent);

    }

    public void btnNextActivity4(View view){
        Intent intent = new Intent(this, ActivityDelete.class);
        startActivity(intent);

    }


}