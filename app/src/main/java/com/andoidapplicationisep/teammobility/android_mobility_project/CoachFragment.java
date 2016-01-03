package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.UserDAO;
import com.facebook.AccessToken;

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
        TextView niveau = (TextView) view.findViewById(R.id.level);
        TextView description = (TextView) view.findViewById(R.id.description);
        imageView.setImageResource(coach.idPicture);
        niveau.setText("Difficulté d'entrainement : " + coach.level + " / 3");
        name.setText(coach.name);
        description.setText(coach.description);

        Button btn = (Button)view.findViewById(R.id.select_coach);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDAO userDAO = new UserDAO(getActivity());
                userDAO.open();
                String userid = AccessToken.getCurrentAccessToken().getUserId();
                userDAO.setSelectedCaoch(userid, coach.id);
            }
        });


        return view;
    }
}