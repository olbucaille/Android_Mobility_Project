package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import android.content.Context;

/**
 * Created by apple on 25/11/2015.
 */
public class VirtualCoachDAO extends DAOBase{
    public static final String TABLE_NAME = "VirtualCoach";
    public static final String KEY = "id";


    //public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INTITULE + " TEXT, " + SALAIRE + " REAL);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public VirtualCoachDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param v le VirtualCoach à ajouter à la base
     */
    public void ajouter(VirtualCoach v) {
        // CODE
    }

    /**
     * @param id l'identifiant du VirtualCoach à supprimer
     */
    public void supprimer(long id) {
        // CODE
    }

    /**
     * @param v le VirtualCoach modifié
     */
    public void modifier(VirtualCoach v) {
        // CODE
    }

    /**
     * @param id l'identifiant du métier à récupérer
     */
    public VirtualCoach selectionner(long id) {
        // CODE
        return new VirtualCoach();
    }

}
