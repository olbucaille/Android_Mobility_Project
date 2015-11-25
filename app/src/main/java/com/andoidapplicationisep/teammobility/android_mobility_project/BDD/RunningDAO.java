package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

/**
 * Created by apple on 25/11/2015.
 */
public class RunningDAO {
    public static final String TABLE_NAME = "Running";
    public static final String KEY = "id";


    //public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INTITULE + " TEXT, " + SALAIRE + " REAL);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    /**
     * @param r le Running à ajouter à la base
     */
    public void ajouter(Running r) {
        // CODE
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
