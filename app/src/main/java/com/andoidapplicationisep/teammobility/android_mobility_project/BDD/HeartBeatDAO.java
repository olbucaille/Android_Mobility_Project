package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.content.Context;

/**
 * Created by apple on 25/11/2015.
 */
public class HeartBeatDAO extends DAOBase{

    public static final String HB_KEY = "id";
    public static final String HB_ACTIVITY_ID = "activity_id";
    public static final String HB_DATE = "date";
    public static final String HB_TABLE_NAME = "HeartBeat";

    public static final String HB_TABLE_CREATE =
            "CREATE TABLE " + HB_TABLE_NAME + " (" +
                    HB_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    HB_ACTIVITY_ID + " TEXT, " +
                    HB_DATE + " TEXT);";

    public static final String HB_TABLE_DROP = "DROP TABLE IF EXISTS " + HB_TABLE_NAME + ";";

    public HeartBeatDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param HB le HeartBeat à ajouter à la base
     */
    public void ajouter(HeartBeat HB) {
        // CODE
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

}
