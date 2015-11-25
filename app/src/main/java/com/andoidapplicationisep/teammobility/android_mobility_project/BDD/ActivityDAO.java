package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.app.*;

/**
 * Created by apple on 25/11/2015.
 */
public class ActivityDAO {

    public static final String TABLE_NAME = "Activity";
    public static final String KEY = "id";


    //public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INTITULE + " TEXT, " + SALAIRE + " REAL);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    /**
     * @param a le Activity à ajouter à la base
     */
    public void ajouter(Activity a) {
        // CODE
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
}
