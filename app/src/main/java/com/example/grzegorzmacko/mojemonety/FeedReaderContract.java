package com.example.grzegorzmacko.mojemonety;

import android.provider.BaseColumns;

/**
 * Created by Grzesiek on 2017-08-15.
 */

public final class FeedReaderContract {

    private FeedReaderContract(){}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "moneta";
        public static final String DATABASE_NAME = "Kolekcja monet.db";
        public static final String _ID = "_id";
        public static final String COLUMN_NAME_WALUTA = "waluta";
        public static final String COLUMN_NAME_ROK = "rok";
        public static final String COLUMN_NAME_KSZTALT = "ksztalt";
        public static final String COLUMN_NAME_METAL = "metal";

        public static final String COLUMN_NAME_STOP_METALU = "stop_metalu";
        public static final String COLUMN_NAME_KRAJ_POCHODZENIA = "kraj_pochodzenia";
        public static final String COLUMN_NAME_NOMINAL = "nominal";
        public static final String COLUMN_NAME_WAGA = "waga";
        public static final String COLUMN_NAME_SREDNICA = "srednica";
        public static final String COLUMN_NAME_WARTOSC = "wartosc";

        // sciaga do tworzenia tabeli
        /*db.execSQL("create table moneta(" + "_id integer primary key autoincrement ,"
                + "waluta text," + "rok integer," + "ksztalt text,"
                + "metal text," + "stop_metalu text," + "kraj_pochodzenia text,"
                + "nominal integer," + "waga integer," + "srednica integer," + "wartosc integer);" + "");
        */

    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY autoincrement ," +
                    FeedEntry.COLUMN_NAME_WALUTA + " TEXT," +
                    FeedEntry.COLUMN_NAME_ROK + " INTEGER," +
                    FeedEntry.COLUMN_NAME_KSZTALT + " TEXT," +
                    FeedEntry.COLUMN_NAME_METAL + " TEXT," +
                    FeedEntry.COLUMN_NAME_STOP_METALU + " TEXT," +
                    FeedEntry.COLUMN_NAME_KRAJ_POCHODZENIA + " TEXT," +
                    FeedEntry.COLUMN_NAME_NOMINAL + " INTEGER," +
                    FeedEntry.COLUMN_NAME_WAGA + " INTEGER," +
                    FeedEntry.COLUMN_NAME_SREDNICA + " INTEGER," +
                    FeedEntry.COLUMN_NAME_WARTOSC + " INTEGER )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
}
