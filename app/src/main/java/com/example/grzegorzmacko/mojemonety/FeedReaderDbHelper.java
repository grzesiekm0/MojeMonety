package com.example.grzegorzmacko.mojemonety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Grzesiek on 2017-08-15.
 */


public class FeedReaderDbHelper extends SQLiteOpenHelper {


    // Global variables to version and name
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Kolekcja monet.db";

    // Columns names to the database
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
    //Drop table
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;

    Context context;

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Create database
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    /**
     * //This method add a coin to the database
     */
    public boolean DodajMonetee(String waluta, Integer rok, String ksztalt, String metal,
                                String stop_metalu, String kraj_pochodzenia, Integer nominal,
                                Integer waga, Integer srednica, Integer wartosc)
    {

            //Create and/or open a database that will be used for reading and writing
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues value = new ContentValues();
            if(waluta == null || rok == null || ksztalt == null || metal ==null
                    || stop_metalu == null || kraj_pochodzenia==null || nominal == null
                    || waga == null || srednica == null || wartosc == null) {

              System.out.println("!!!!!!!!!!!!!!!!!!!!!!");

            }
        else{
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_WALUTA, waluta);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ROK, rok);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_KSZTALT, ksztalt);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_METAL, metal);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_STOP_METALU, stop_metalu);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_KRAJ_POCHODZENIA, kraj_pochodzenia);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NOMINAL, nominal);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_WAGA, waga);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SREDNICA, srednica);
                value.put(FeedReaderContract.FeedEntry.COLUMN_NAME_WARTOSC, wartosc);

            }
            // Insert to database
            long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, value);
            // newRowId = -1;
            if (newRowId == -1) {
                return false;
            } else{

                return true;}


    }

    /**
     * //This method update a coin to the database
     */
    public boolean AktualizujMonete(int idd, String waluta, Integer rok, String ksztalt, String metal,
                                    String stop_metalu, String kraj_pochodzenia, Integer nominal, Integer waga, Integer srednica, Integer wartosc) {

        //Create and/or open a database that will be used for reading and writing
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuee = new ContentValues();

        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_WALUTA, waluta);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ROK, rok);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_KSZTALT, ksztalt);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_METAL, metal);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_STOP_METALU, stop_metalu);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_KRAJ_POCHODZENIA, kraj_pochodzenia);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NOMINAL, nominal);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_WAGA, waga);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SREDNICA, srednica);
        valuee.put(FeedReaderContract.FeedEntry.COLUMN_NAME_WARTOSC, wartosc);

        // Update to database
        long newRowId = db.update(FeedReaderContract.FeedEntry.TABLE_NAME, valuee, FeedReaderContract.FeedEntry
                ._ID + "=" + idd, null);
        if (newRowId == -1) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }


    /**
     * //This method returns all coins from the database
     */
    public ArrayList<moneta> getAllNotes() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<moneta> listItems = new ArrayList<moneta>();

        //Get results from the database to Cursor
        Cursor cursor = db.rawQuery("SELECT * from " + FeedReaderContract.FeedEntry.TABLE_NAME,
                new String[]{});

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

                // Adding object to ListItem
                listItems.add(mon);
            } while (cursor.moveToNext());
        }
        // Closing databases because it consumes a lot of memory and time
        db.close();
        cursor.close();

        return listItems;
    }


    /**
     * //This method removing a coin from the database
     */
    public void removee(long id) {

        //Create and/or open a database.
        SQLiteDatabase db = this.getReadableDatabase();
        String string = String.valueOf(id);
        db.execSQL("DELETE FROM " + FeedReaderContract.FeedEntry.TABLE_NAME + " WHERE " + FeedReaderContract.FeedEntry._ID + "= '" + string + "'");


    }


}
