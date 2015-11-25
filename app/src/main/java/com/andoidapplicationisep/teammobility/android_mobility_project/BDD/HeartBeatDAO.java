package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

/**
 * Created by apple on 25/11/2015.
 */
public class HeartBeatDAO {

    public static final String TABLE_NAME = "HeartBeat";
    public static final String KEY = "id";


    //public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INTITULE + " TEXT, " + SALAIRE + " REAL);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

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
