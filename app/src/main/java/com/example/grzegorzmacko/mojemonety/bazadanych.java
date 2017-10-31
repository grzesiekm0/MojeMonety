package com.example.grzegorzmacko.mojemonety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Dom on 2017-05-29.
 */

public class bazadanych extends SQLiteOpenHelper {


    public static final String KEY_NAME = "id";

    private static final String DATABASE_NAME = "Kolekcja monet.db";
    private static final String DATABASE_TABLE = "moneta";
SQLiteDatabase db;


    public bazadanych(Context context) {
        super(context, "KolekcjaMonet.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table moneta(" + "_id integer primary key autoincrement ,"
                + "waluta text," + "rok integer," + "ksztalt text,"
                + "metal text," + "stop_metalu text," + "kraj_pochodzenia text,"
                + "nominal integer," + "waga integer," + "srednica integer," + "wartosc integer);" + "");


    }

    //waluta, kraj pochodzenia, rok, ksztalt, metal, stop, nominal, waga,srednica, wartosc

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(bazadanych.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS moneta");
        onCreate(db);
    }

//Metoda dodajaca monete do bazy danych
    public boolean DodajMonete(String waluta, Integer rok, String ksztalt, String metal,
                               String stop_metalu, String kraj_pochodzenia, Integer nominal, Integer waga, Integer srednica, Integer wartosc) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        // String rok_con;
        //rok_con = Integer.toString(rok);

        //String.valueOf(rok);
        value.put("waluta", waluta);
        value.put("rok", rok);
        value.put("ksztalt", ksztalt);
        value.put("metal", metal);
        value.put("stop_metalu", stop_metalu);
        value.put("kraj_pochodzenia", kraj_pochodzenia);
        value.put("nominal", nominal);
        value.put("waga", waga);
        value.put("srednica", srednica);
        value.put("wartosc", wartosc);

        long result = db.insertOrThrow("moneta", null, value);
        if (result == -1) {
            return false;
        } else
            return true;

    }






// Metoda aktualizacji danych monety
    public boolean updatedata (int id, String waluta, Integer rok, String ksztalt, String metal,
                               String stop_metalu, String kraj_pochodzenia, Integer nominal, Integer waga, Integer srednica, Integer wartosc) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("_id", id);
        value.put("waluta", waluta);
        value.put("rok", rok);
        value.put("ksztalt", ksztalt);
        value.put("metal", metal);
        value.put("stop_metalu", stop_metalu);
        value.put("kraj_pochodzenia", kraj_pochodzenia);
        value.put("nominal", nominal);
        value.put("waga", waga);
        value.put("srednica", srednica);
        value.put("wartosc", wartosc);

        db.update("moneta",value, "_id ="+id, null);
        return true;
    }









    // public void UsunMonete(moneta id) {
    // int id = moneta.getId();
    // System.out.println("Comment deleted with id: " + id);
    // db.delete(MySQLiteHelper, MySQLiteHelper.COLUMN_ID
    //  + " = " + id, null);

    //  return SQLiteDatabase.delete(DATABASE_TABLE, KEY_NAME + "=" + id, null) > 0;
    //  }

    //metoda usuwajaca monete po id
    public boolean Usun(long id) {

        SQLiteDatabase db = this.getWritableDatabase();



        db.execSQL("DELETE FROM " + "moneta" + " WHERE " + "_id" + "= '" + id + "'");

      //  SQLiteDatabase db = this.getReadableDatabase();
      //  db.delete("moneta", "_id" + "=?", new String[]{id});
        db.close();

       // db.close();
        return true;
    }

    //druga metoda usuwajaca monete

    public void remove(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String string =String.valueOf(id);
       // db.execSQL("DELETE FROM moneta WHERE _id = '" + string + "'");
        db.execSQL("DELETE FROM " + "moneta" + " WHERE " + "_id" + "= '" + string + "'");


    }

// Metoda z typem Cursor wyswietlajaca wyniki bazy sqlite
    public Cursor wyswietlWszystkieRekordy() {
        String where = null;
        String[] kolumny = {"_id", "waluta", "rok", "ksztalt", "metal", "stop_metalu", "kraj_pochodzenia", "nominal", "waga", "srednica", "wartosc"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("moneta", kolumny, null, null, null, null, null);
        if(kursor != null){
            kursor.moveToFirst();
        }

        return kursor;
    }

    public Cursor Wyswietl(){
        String[] kolumny = {"_id", "waluta", "rok", "ksztalt", "metal", "stop_metalu", "kraj_pochodzenia", "nominal", "waga", "srednica", "wartosc"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("moneta", kolumny, null, null, null, null, null);


        return kursor;
    }

    public Cursor WyswietlPoId(int id){

        String[] kolumny = {"_id"+id, "waluta", "rok", "ksztalt", "metal", "stop_metalu", "kraj_pochodzenia", "nominal", "waga", "srednica", "wartosc"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("moneta", kolumny, null, null, null, null, null);


        return kursor;
    }




}
