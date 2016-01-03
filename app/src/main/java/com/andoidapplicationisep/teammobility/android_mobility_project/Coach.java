package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.res.Resources;

import java.util.ArrayList;

/**
 * Created by apple on 10/11/2015.
 */
public class Coach {
    int idPicture;
    String name;
    int level ;
    int id ;
    String description;

    public Coach (int idPicture,int id,int level,String name,String description){
        this.description = description;
        this.level = level;
        this.idPicture = idPicture;
        this.id= id ;
        this.name = name;
    }

    public static ArrayList<Coach> getAllCaoch(Resources res){


        ArrayList<Coach> coachList = new ArrayList<Coach>();
        coachList.add(new Coach(R.drawable.comics_superman_icon, 1,1,"Superman", res.getString(R.string.description_superman)));
        coachList.add(new Coach(R.drawable.comics_batman_icon,2,2,"Le Batman", res.getString(R.string.description_batman)));
        coachList.add(new Coach(R.drawable.comics_batman_joker_icon,3,3,"Le Joker", res.getString(R.string.description_Joker)));
        return coachList;

    }
}
