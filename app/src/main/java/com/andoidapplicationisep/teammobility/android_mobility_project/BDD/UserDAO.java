package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

/**
 * Created by apple on 25/11/2015.
 */
public class UserDAO {
    public static final String TABLE_NAME = "User";
    public static final String KEY = "id";


    //public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INTITULE + " TEXT, " + SALAIRE + " REAL);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    /**
     * @param u le User à ajouter à la base
     */
    public void ajouter(User u) {
        // CODE
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
