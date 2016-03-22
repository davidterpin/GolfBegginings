package com.example.stickman.golfbegginings.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.stickman.golfbegginings.utilities.Message;

/**
 * Created by stickman on 3/22/16.
 */
public class DBOpenHelper extends SQLiteOpenHelper{
    // Declare constants for

    private static final String LOGTAG = "LOGCAT DBOPENHELPER : ";

    private static final String DATABASE_NAME = "golftest.db";
    private static final int DATABASE_VERSION = 12;

///  Courses
    public static final String COURSE_TABLE = "course";
    private static final String UID = "_id";
    public static final String COURSE_ID = "cId";
    public static final String COURSE_NAME = "cName";
    public static final String COURSE_DESC = "cDes";
    public static final String COURSE_IMAGE = "cImg";

    private static final String COURSE_TABLE_CREATE =
            "CREATE TABLE " + COURSE_TABLE + " (" +
                    UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COURSE_NAME + " TEXT, " +
                    COURSE_DESC + " TEXT, " +
                    COURSE_IMAGE + " TEXT, " +
                    COURSE_ID + " INTEGER " +
                    ")";

/// Holes

    public static final String HOLES_TABLE = "holes";

    public static final String HOLES_ID = "hId";
    public static final String HOLES_NAME = "hName";
    public static final String HOLES_DESC = "hDes";
    public static final String HOLES_IMAGE = "hImg";
    public static final String HOLES_DIST = "hDist";
    public static final String HOLES_PAR = "hPar";


    private static final String HOLES_TABLE_CREATE =
            "CREATE TABLE " + HOLES_TABLE + " (" +
                    UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    HOLES_NAME + " TEXT, " +
                    HOLES_DESC + " TEXT, " +
                    HOLES_IMAGE + " TEXT, " +
                    HOLES_DIST + " INTEGER, " +
                    HOLES_PAR + " INTEGER, " +
                    HOLES_ID + " INTEGER " +
                    ")";

/// Players

    public static final String PLAYER_TABLE = "player";

    public static final String PLAYER_ID = "pId";
    public static final String PLAYER_NAME = "pName";
    public static final String PLAYER_DATE = "pDate";
    public static final String PLAYER_IMAGE = "pImg";



    private static final String PLAYER_TABLE_CREATE =
            "CREATE TABLE " + PLAYER_TABLE + " (" +
                    UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PLAYER_NAME + " TEXT, " +
                    PLAYER_IMAGE + " TEXT, " +
                    PLAYER_DATE + " INTEGER, " +
                    PLAYER_ID + " INTEGER " +
                    ")";


    /// Clubs

    public static final String ClUBS_TABLE = "clubs";

    public static final String CLUB_ID = "clubId";
    public static final String CLUB_NAME = "clubName";
    public static final String CLUB_IMAGE = "clubImg";



    private static final String CLUBS_TABLE_CREATE =
            "CREATE TABLE " + ClUBS_TABLE + " (" +
                    UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CLUB_NAME + " TEXT, " +
                    CLUB_IMAGE + " TEXT, " +
                    CLUB_ID + " INTEGER " +
                    ")";




/// Strokes

    public static final String STROKES_TABLE = "strokes";

   // public static final String STROKE_ID = "stId";
   // public static final String STROKE_CLUB = "stClub";
    public static final String STROKE_EVENT = "stEvent";
    public static final String STROKE_COUNT = "stCnt";
    public static final String STROKE_DATE = "stDate";
    public static final String STROKE_X = "stX";
    public static final String STROKE_Y = "stY";
    public static final String STROKE_GPS = "stGPS";



    private static final String STROKES_TABLE_CREATE =
            "CREATE TABLE " + STROKES_TABLE + " (" +
                    UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COURSE_ID + " INTEGER, " +
                    HOLES_ID + " INTEGER, " +
                    PLAYER_ID + " INTEGER, " +
                    CLUB_ID + " INTEGER, " +
                    STROKE_EVENT + " INTEGER, " +
                    STROKE_COUNT + " INTEGER, " +
                    STROKE_DATE + " INTEGER, " +
                    STROKE_X + " INTEGER, " +
                    STROKE_Y + " INTEGER, " +
                    STROKE_GPS + " INTEGER " +
                    ")";



    //Methods

    private final Context context;


    public DBOpenHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.context =context;
        Message.message(context, "DATABASE CONSTRUCTOR CALLED");
        Log.i(LOGTAG, "DATABASE CONSTRUCTOR CALLED\n");
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(COURSE_TABLE_CREATE);
            Log.i(LOGTAG, "Course Table has been created \n");
            Message.message(context, "Course Table has been created ");

            db.execSQL(HOLES_TABLE_CREATE);
            Log.i(LOGTAG, "Holes Table has been created \n");
            Message.message(context, "Holes Table has been created ");

            db.execSQL(PLAYER_TABLE_CREATE);
            Log.i(LOGTAG, "Players Table has been created \n");
            Message.message(context, "Players Table has been created ");

            db.execSQL(CLUBS_TABLE_CREATE);
            Log.i(LOGTAG, "Clubs Table has been created \n");
            Message.message(context, "Clubs Table has been created ");

            db.execSQL(STROKES_TABLE_CREATE);
            Log.i(LOGTAG, "Strokes Table has been created \n");
            Message.message(context, "Strokes Table has been created ");







        } catch (SQLException e) {
            e.printStackTrace();
            Message.messagefail(context, " " + e);
            Log.i(LOGTAG, " FAIL ERROR  >> On Create not called" + e);
            e.printStackTrace();

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(" DROP TABLE IF EXISTS " + COURSE_TABLE);
            Log.i(LOGTAG, "Course Table has been updated \n");
            Message.message(context, "Course Table has been UPDATED ");

            db.execSQL(" DROP TABLE IF EXISTS " + HOLES_TABLE);
            Log.i(LOGTAG, "Holes Table has been updated \n");
            Message.message(context, "Holes Table has been UPDATED ");

            db.execSQL(" DROP TABLE IF EXISTS " + PLAYER_TABLE);
            Log.i(LOGTAG, "Players Table has been updated \n");
            Message.message(context, "Players Table has been UPDATED ");

            db.execSQL(" DROP TABLE IF EXISTS " + ClUBS_TABLE);
            Log.i(LOGTAG, "Clubs Table has been updated \n");
            Message.message(context, "Clubs Table has been UPDATED ");

            db.execSQL(" DROP TABLE IF EXISTS " + STROKES_TABLE);
            Log.i(LOGTAG, "Strokes Table has been updated \n");
            Message.message(context, "Strokes Table has been UPDATED ");


            onCreate(db);


        } catch (SQLException e) {
            Message.messagefail(context, "" + e);
            Log.i(LOGTAG, "Database has been dropped and upgraded");
            e.printStackTrace();
        }
    }
}
