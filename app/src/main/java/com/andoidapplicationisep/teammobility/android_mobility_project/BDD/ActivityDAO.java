package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.app.*;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by apple on 25/11/2015.
 */
public class ActivityDAO extends DAOBase{

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



    public ActivityDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param a le Activity à ajouter à la base
     */
    public long ajouter(Activity a) {
        // CODE

        ContentValues value = new ContentValues();
        value.put(ACTIVITY_USER_ID, a.getUserFbID());
        value.put(ACTIVITY_TYPE, a.getType());
        value.put(ACTIVITY_BEGIN, a.getBegin());
        value.put(ACTIVITY_END, a.getEnd());
        return mDb.insert(ACTIVITY_TABLE_NAME, null, value);

    }
    public void setEnd(String userFbId, String end){
        mDb.execSQL("UPDATE " + ACTIVITY_TABLE_NAME +
                " SET "+ ACTIVITY_END + " = \"" +end+ "\"" +
                " WHERE "+ ACTIVITY_USER_ID+" = ?", new String[]{ userFbId});

    }
    /**
     * @param id l'identifiant du Activity à supprimer
     */
    public void supprimer(long id) {
        // CODE
    }

    /**
     * @param HB le Activity modifié
     */
    public void modifier(HeartBeat HB) {
        // CODE
    }

    /**
     * @param id l'identifiant du Activity à récupérer
     */
    public Activity selectionner(long id) {
        // CODE
        return new Activity();
    }

    public ArrayList <Activity> getActivityOfUSer (String userfbID){
        ArrayList <Activity> activityArrayList =new ArrayList<Activity>();

        Cursor cursor = mDb.rawQuery("select " + "*" + " from " + ACTIVITY_TABLE_NAME + " where " + ACTIVITY_USER_ID +"= ? ", new String[]{userfbID});
        while (cursor.moveToNext()) {
            Activity activity = new Activity();
            activity.setId(cursor.getLong(0));
            activity.setUserFbID(cursor.getString(1));
            activity.setType(cursor.getInt(2));
            activity.setBegin(cursor.getString(3));
            activity.setEnd(cursor.getString(4));
            String userID = cursor.getString(1);

            activityArrayList.add(activity);

        }
        cursor.close();


        return activityArrayList;
    }
}
