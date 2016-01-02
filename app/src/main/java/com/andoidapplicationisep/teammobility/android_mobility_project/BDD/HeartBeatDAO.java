package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by apple on 25/11/2015.
 */
public class HeartBeatDAO extends DAOBase{

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

    public HeartBeatDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param HB le HeartBeat à ajouter à la base
     */
    public void ajouter(HeartBeat HB) {
        ContentValues value = new ContentValues();
        value.put(HB_ACTIVITY_ID, HB.getActivityID());
        value.put(HB_HB, HB.getHeartBeat());
        value.put(HB_DATE, HB.getDate());
        mDb.insert(HB_TABLE_NAME, null, value);
    }

    /**
     * @param id l'identifiant du HeartBeat à supprimer
     */
    public void supprimer(long id) {
        // CODE
    }

    /**
     * @param HB le HeartBeat modifié
     */
    public void modifier(HeartBeat HB) {
        // CODE
    }

    /**
     * @param id l'identifiant du HeartBeat à récupérer
     */
    public HeartBeat selectionner(long id) {
        // CODE
        return new HeartBeat();
    }
    public ArrayList<HeartBeat> getHB (String activityID) {
        ArrayList<HeartBeat> hbArrayList =new ArrayList<HeartBeat>();
        Cursor cursor = mDb.rawQuery("select " + "*" + " from " + HB_TABLE_NAME + " where " + HB_ACTIVITY_ID + "= ? ", new String[]{activityID});
        while (cursor.moveToNext()) {
            HeartBeat hb = new HeartBeat();
            long id = cursor.getLong(0);
            Long activityId = cursor.getLong(1);
            int heartbeat = cursor.getInt(2);
            String date = cursor.getString(3);
            hb.setActivityID(activityId);
            hb.setHeartBeat(heartbeat);
            hb.setDate(date);
            hbArrayList.add(hb);
            //Log.d("activityId", activityId);
        }

        cursor.close();
        return hbArrayList;
    }
}
