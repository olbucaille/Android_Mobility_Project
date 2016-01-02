package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by apple on 25/11/2015.
 */
public class UserDAO extends DAOBase{

    public static final String USER_KEY ="id";
    public static final String USER_FB_ID ="fb_id";
    public static final String USER_NAME ="username";
    public static final String USER_TABLE_NAME ="user";

    public static final String USER_TABLE_CREATE =
            "CREATE TABLE " + USER_TABLE_NAME + " (" +
                    USER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    USER_FB_ID + "TEXT," +
                    USER_NAME + " TEXT, " +
                    USER_TABLE_NAME + " TEXT);";

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

}
