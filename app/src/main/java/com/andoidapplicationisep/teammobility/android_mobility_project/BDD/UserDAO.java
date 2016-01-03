package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/**
 * Created by apple on 25/11/2015.
 */
public class UserDAO extends DAOBase{

    public static final String USER_KEY ="id";
    public static final String USER_FB_ID ="fb_id";
    public static final String USER_NAME ="username";
    public static final String USER_COACH_ID ="selectedCoachId";
    public static final String USER_TABLE_NAME ="user";

    public static final String USER_TABLE_CREATE =
            "CREATE TABLE " + USER_TABLE_NAME + " (" +
                    USER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    USER_FB_ID + " TEXT," +
                    USER_NAME + " TEXT, " +
                    USER_COACH_ID+ " TEXT);";

    public static final String USER_TABLE_DROP = "DROP TABLE IF EXISTS " + USER_TABLE_NAME + ";";

    public UserDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param u le User à ajouter à la base
     */
    public void ajouter(User u) {
        // CODE
        ContentValues value = new ContentValues();
        value.put(USER_FB_ID, u.getFbId());
        value.put(USER_NAME, u.getName());
        value.put(USER_COACH_ID, u.getSelectedCoachId());
        mDb.insert(USER_TABLE_NAME, null, value);
    }

    /**
     * @param id l'identifiant du VirtualCoach à supprimer
     */
    public void supprimer(long id) {
        // CODE
    }

    /**
     * @param u le VirtualCoach modifié
     */
    public void modifier(User u) {
        // CODE
    }

    /**
     * @param id l'identifiant du Running à récupérer
     */
    public User selectionner(long id) {
        // CODE
        return new User();
    }

    public void setSelectedCaoch(String userFbId,String coachID){
        mDb.execSQL("UPDATE " + USER_TABLE_NAME +
                " SET "+ USER_COACH_ID+ " = "+coachID);

    }

    public String getSelectedCaoch(String userFbId){
        String coachId="";
        Cursor cursor = mDb.rawQuery("SELECT " +" * " +
                " FROM "+ USER_TABLE_NAME+
                " WHERE "+ USER_FB_ID+" = ?", new String[]{ userFbId});

        while(cursor.moveToNext()){
            coachId = cursor.getString(0);
            Log.d("coach iiid", "" +coachId);
            coachId = cursor.getString(1);
            Log.d("coach iiid", "" +coachId);
            coachId = cursor.getString(2);
            Log.d("coach iiid", "" +coachId);
            coachId = cursor.getString(3);
            Log.d("coach iiid", "" +coachId);

        }
        return coachId;
    }

}
