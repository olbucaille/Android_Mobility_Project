package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by apple on 04/11/2015.
 */
public class DetailsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_stats_fragment, container, false);
       //afficher les statistics de la statistic séleltionné.

        return view;
    }
}

