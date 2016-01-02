package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by apple on 24/11/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String USER_KEY ="id";
    public static final String USER_FB_ID ="fb_id";
    public static final String USER_NAME ="username";
    public static final String USER_COACH_ID ="selectedCoachId";
    public static final String USER_TABLE_NAME ="user";

    public static final String USER_TABLE_CREATE =
            "CREATE TABLE " + USER_TABLE_NAME + " (" +
                    USER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    USER_FB_ID + "TEXT," +
                    USER_NAME + " TEXT, " +
                    USER_TABLE_NAME + " TEXT" +
                    USER_COACH_ID+ " TEXT);";
    public static final String USER_TABLE_DROP = "DROP TABLE IF EXISTS " + USER_TABLE_NAME + ";";


    public static final String ACTIVITY_KEY = "id";
    public static final String ACTIVITY_USER_ID = "user_id";
    public static final String ACTIVITY_TYPE = "type";
    public static final String ACTIVITY_BEGIN = "begin";
    public static final String ACTIVITY_END = "end";
    public static final String ACTIVITY_TABLE_NAME = "Metier";

    public static final String ACTIVITY_TABLE_CREATE =
            "CREATE TABLE " + ACTIVITY_TABLE_NAME + " (" +
                    ACTIVITY_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ACTIVITY_USER_ID + " TEXT, " +
                    ACTIVITY_TYPE + " TEXT, " +
                    ACTIVITY_BEGIN + " TEXT, " +
                    ACTIVITY_END + " TEXT);";

    public static final String ACTIVITY_TABLE_DROP = "DROP TABLE IF EXISTS " + ACTIVITY_TABLE_NAME + ";";


    public static final String HB_KEY = "id";
    public static final String HB_ACTIVITY_ID = "activity_id";
    public static final String HB_HB = "hb";
    public static final String HB_DATE = "date";
    public static final String HB_TABLE_NAME = "HeartBeat";

    public static final String HB_TABLE_CREATE =
            "CREATE TABLE " + HB_TABLE_NAME + " (" +
                    HB_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    HB_ACTIVITY_ID + " TEXT, " +
                    HB_HB + "INTEGER,"+
                    HB_DATE + " TEXT);";

    public static final String HB_TABLE_DROP = "DROP TABLE IF EXISTS " + HB_TABLE_NAME + ";";


    public static final String RUNNING_KEY = "id";
    public static final String RUNNING_ACTIVITY_ID = "activity_id";
    public static final String RUNNING_DISTANCE = "date";
    public static final String RUNNING_TABLE_NAME = "Running";

    public static final String RUNNING_TABLE_CREATE =
            "CREATE TABLE " + RUNNING_TABLE_NAME + " (" +
                    RUNNING_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    RUNNING_ACTIVITY_ID + " TEXT, " +
                    RUNNING_DISTANCE + " INTEGER);";

    public static final String RUNNING_TABLE_DROP = "DROP TABLE IF EXISTS " + RUNNING_TABLE_NAME + ";";




    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
        db.execSQL(ACTIVITY_TABLE_CREATE);
        db.execSQL(RUNNING_TABLE_CREATE);
        db.execSQL(HB_TABLE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(USER_TABLE_DROP);
        db.execSQL(ACTIVITY_TABLE_DROP);
        db.execSQL(RUNNING_TABLE_DROP);
        db.execSQL(HB_TABLE_DROP);
        onCreate(db);
    }


}