package com.example.stickman.golfbegginings.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class StrokesDataSource {


    public static final String LOGTAG = "LOGCAT Strokes :";

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;
    //Context context;


    // First step is to create this constructor method

    public StrokesDataSource(Context context) {

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

