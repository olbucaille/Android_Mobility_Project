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

            case StringProvider.Joker:
                cm.AddList_Run(R.raw.just_do_it);
                cm.AddList_Run(R.raw.highway_to_hell);
                cm.AddList_Run(R.raw.batman_debut);
                break;

            default:
                break;
        }


        return cm;
    }

}
