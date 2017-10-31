package com.example.grzegorzmacko.mojemonety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Grzesiek on 2017-08-15.
 */


public class FeedReaderDbHelper extends SQLiteOpenHelper {



    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Kolekcja monet.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY autoincrement ," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_WALUTA + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_ROK + " INTEGER," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_KSZTALT + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_METAL + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_STOP_METALU + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_KRAJ_POCHODZENIA + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_NOMINAL + " INTEGER," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_WAGA + " INTEGER," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_SREDNICA + " INTEGER," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_WARTOSC + " INTEGER )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;

    Context context;
    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }






    //Metoda dodajaca monete do bazy danych
    public boolean DodajMonetee(String waluta, Integer rok, String ksztalt, String metal,
                               String stop_metalu, String kraj_pochodzenia, Integer nominal, Integer waga, Integer srednica, Integer wartosc) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        // String rok_con;
        //rok_con = Integer.toString(rok);

        //String.valueOf(rok);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_WALUTA, waluta);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_ROK, rok);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_KSZTALT, ksztalt);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_METAL, metal);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_STOP_METALU, stop_metalu);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_KRAJ_POCHODZENIA, kraj_pochodzenia);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_NOMINAL, nominal);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_WAGA, waga);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_SREDNICA, srednica);
        value.put( FeedReaderContract.FeedEntry.COLUMN_NAME_WARTOSC, wartosc);

        long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, value);
        if (newRowId == -1) {
            return false;
        } else
            return true;

    }


    //Metoda dodajaca monete do bazy danych
    public boolean AktualizujMonete(int idd, String waluta, Integer rok, String ksztalt, String metal,
                                String stop_metalu, String kraj_pochodzenia, Integer nominal, Integer waga, Integer srednica, Integer wartosc) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuee = new ContentValues();
        // String rok_con;
        //rok_con = Integer.toString(rok);

        //String.valueOf(rok);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_WALUTA, waluta);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_ROK, rok);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_KSZTALT, ksztalt);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_METAL, metal);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_STOP_METALU, stop_metalu);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_KRAJ_POCHODZENIA, kraj_pochodzenia);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_NOMINAL, nominal);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_WAGA, waga);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_SREDNICA, srednica);
        valuee.put( FeedReaderContract.FeedEntry.COLUMN_NAME_WARTOSC, wartosc);



        long newRowId = db.update(FeedReaderContract.FeedEntry.TABLE_NAME, valuee, FeedReaderContract.FeedEntry
        ._ID+"="+idd,null);
        if (newRowId == -1) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }



    /**
     * //This method returns all notes from the database
     */
    public ArrayList<moneta> getAllNotes() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<moneta> listItems = new ArrayList<moneta>();

        Cursor cursor = db.rawQuery("SELECT * from " + FeedReaderContract.FeedEntry.TABLE_NAME,
                new String[] {});

        if (cursor.moveToFirst()) {
            do {
                moneta mon = new moneta();

                mon._id = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry._ID));

                mon.waluta = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_WALUTA));
                mon.rok = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_ROK));
                mon.ksztalt = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_KSZTALT));
                mon.metal = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_METAL));
                mon.stop_metalu = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_STOP_METALU));
                mon.kraj_pochodzenia = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_KRAJ_POCHODZENIA));
                mon.nominal = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_NOMINAL));
                mon.waga = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_WAGA));
                mon.srednica = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_SREDNICA));
                mon.wartosc = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_WARTOSC));

                listItems.add(mon);
            } while (cursor.moveToNext());
        }
        // trzeba zamknac baze danych bo kosztuje duzo pamieci i czasu
        db.close();
        cursor.close();

        return listItems;
    }


    // Metoda z typem Cursor wyswietlajaca wyniki bazy sqlite
    public Cursor wyswietlWszystkieRekordyy() {
        String where = null;
        String[] kolumny = {"_id", "waluta", "rok", "ksztalt", "metal", "stop_metalu", "kraj_pochodzenia", "nominal", "waga", "srednica", "wartosc"};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor kursor = db.query("moneta", kolumny, null, null, null, null, null);
        if(kursor != null){
            kursor.moveToFirst();
        }
        return kursor;
    }


    public void removee(long id){
        SQLiteDatabase db = this.getReadableDatabase();
        String string =String.valueOf(id);
        // db.execSQL("DELETE FROM moneta WHERE _id = '" + string + "'");
        db.execSQL("DELETE FROM " + "moneta" + " WHERE " + "_id" + "= '" + string + "'");


    }

    public void deleteNote(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String string = String.valueOf(id);
        db.execSQL("DELETE FROM " + FeedReaderContract.FeedEntry.TABLE_NAME + " WHERE " + FeedReaderContract.FeedEntry._ID
                + "=" + id + "");
    }




}
