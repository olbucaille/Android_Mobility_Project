package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by apple on 09/11/2015.
 */
public class CoachContentView extends FragmentStatePagerAdapter {
    private int nbCoach;
    ArrayList <Coach> coachList;

    public CoachContentView(FragmentManager fm,ArrayList <Coach> coachList) {
        super(fm);
        this.nbCoach = coachList.size();
        this.coachList = coachList;
    }


    @Override
    public Fragment getItem(int i) {
        if ((i<nbCoach)||(i>0)){
            return new CoachFragment(coachList.get(i));
        }else
            return null;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return nbCoach; //No of Tabs
    }
}
