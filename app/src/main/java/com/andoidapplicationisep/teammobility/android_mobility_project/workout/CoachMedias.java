package com.andoidapplicationisep.teammobility.android_mobility_project.workout;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by Guigui on 02/01/2016.
 */
public class CoachMedias {
    private String Name;
    private ArrayList<Integer> List_Run;
    private ArrayList<Integer> List_Hb;
    private ArrayList<Integer> List_Perso;


    public CoachMedias(String name)
    {
        Name= name;
        List_Run = new ArrayList<Integer>();
        List_Hb = new ArrayList<Integer>();
        List_Perso = new ArrayList<Integer>();
    }

    public void AddList_Run(int Toadd)
    {
        List_Run.add(Toadd);
    }

    public void AddList_Hb(int Toadd)
    {
        List_Hb.add(Toadd);
    }

    public void AddList_Perso(int Toadd)
    {
        List_Perso.add(Toadd);
    }

    public int PickRandomRun()
    {
        return List_Run.get((int)(Math.random() * List_Run.size()));
    }
    public int PickRandomHb()
    {
        return List_Hb.get((int)(Math.random() * List_Hb.size()));
    }
    public int PickRandomPerso()
    {
        return List_Perso.get((int)(Math.random() * List_Perso.size()));
    }

}
