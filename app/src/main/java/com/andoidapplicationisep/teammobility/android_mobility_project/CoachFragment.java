package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by apple on 09/11/2015.
 */
public class CoachFragment extends Fragment {
    private final Coach coach;

    public CoachFragment(Coach coach) {
        this.coach = coach;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coach_fragment, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageCoach);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView description = (TextView) view.findViewById(R.id.description);
        imageView.setImageResource(coach.idPicture);
        name.setText(coach.name);
        description.setText(coach.description);
        return view;
    }
}