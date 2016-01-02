package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by apple on 25/11/2015.
 */
public class RunningDAO extends DAOBase {

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


    public RunningDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param r le Running à ajouter à la base
     */
    public void ajouter(Running r) {
        ContentValues value = new ContentValues();
        value.put(RUNNING_ACTIVITY_ID, r.getActivityID());
        value.put(RUNNING_DISTANCE, r.getDistance());
        mDb.insert(RUNNING_TABLE_NAME, null, value);
    }

    /**
     * @param id l'identifiant du Running à supprimer
     */
    public void supprimer(long id) {
        // CODE
    }

    /**
     * @param r le Running modifié
     */
    public void modifier(Running r) {
        // CODE
    }

    /**
     * @param id l'identifiant du Running à récupérer
     */
    public Running selectionner(long id) {
        // CODE
        return new Running();
    }

}
