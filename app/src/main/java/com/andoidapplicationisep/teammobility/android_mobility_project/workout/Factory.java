package com.andoidapplicationisep.teammobility.android_mobility_project.workout;

import android.net.Uri;

import com.andoidapplicationisep.teammobility.android_mobility_project.R;

/**
 * Created by Guigui on 02/01/2016.
 */
public class Factory {
    public static CoachMedias GetACoach(String coach)
    {
        CoachMedias cm = new CoachMedias(coach);
        switch (coach) {
            case StringProvider.Superman:
                cm.AddList_Run(R.raw.superman_debut);
                cm.AddList_Run(R.raw.superman_2km);
                cm.AddList_Run(R.raw.superman_4km);
                cm.AddList_Run(R.raw.superman_6km);
                cm.AddList_Hb(R.raw.superman_niv1);
                cm.AddList_Hb(R.raw.superman_niv2);
                cm.AddList_Hb(R.raw.superman_niv3);
                cm.AddList_Perso(R.raw.superman_p1);
                cm.AddList_Perso(R.raw.superman_p2);
                cm.AddList_Perso(R.raw.superman_p3);
                break;
            case StringProvider.Batman:
                cm.AddList_Run(R.raw.batman_debut);
                cm.AddList_Run(R.raw.batman_2km);
                cm.AddList_Run(R.raw.batman_4km);
                cm.AddList_Run(R.raw.batman_6km);
                cm.AddList_Hb(R.raw.batman_niv1);
                cm.AddList_Hb(R.raw.batman_niv2);
                cm.AddList_Hb(R.raw.batman_niv3);
                cm.AddList_Perso(R.raw.batman_p1);
                cm.AddList_Perso(R.raw.batman_p2);
                cm.AddList_Perso(R.raw.batman_p3);
                break;

            case StringProvider.Joker:
                cm.AddList_Run(R.raw.joker_debut);
                cm.AddList_Run(R.raw.joker_2km);
                cm.AddList_Run(R.raw.joker_4km);
                cm.AddList_Run(R.raw.joker_6km);
                cm.AddList_Hb(R.raw.joker_niv1);
                cm.AddList_Hb(R.raw.joker_niv2);
                cm.AddList_Hb(R.raw.joker_niv3);
                cm.AddList_Perso(R.raw.joker_p1);
                cm.AddList_Perso(R.raw.joker_p2);
                cm.AddList_Perso(R.raw.joker_p3);
                break;

            default:
                break;
        }


        return cm;
    }

}
