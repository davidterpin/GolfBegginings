package com.example.stickman.golfbegginings.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by stickman on 3/22/16.
 */
public class ClubsDataSource {

    public static final String LOGTAG = "LOGCAT Clubs :";

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;
    //Context context;


    // First step is to create this constructor method

    public ClubsDataSource(Context context) {

        //dbhelper = new DBOpenHelper(context);
        // database =dbhelper.getWritableDatabase();
        // This changed into
        dbhelper = new DBOpenHelper(context);
    }

    public void open() {


        database = dbhelper.getWritableDatabase();
        Log.i(LOGTAG, "Database opened");

    }

    public void close() {
        Log.i(LOGTAG, "Database closed");
        dbhelper.close();
    }
}


