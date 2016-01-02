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
                for (int i = 0; i < 10; i++)
                    cm.AddList_Perso(i);
                break;

            case StringProvider.Joker:
                cm.AddList_Run(R.raw.just_do_it);
                cm.AddList_Run(R.raw.highway_to_hell);
                break;

            default:
                break;
        }


        return cm;
    }

}
