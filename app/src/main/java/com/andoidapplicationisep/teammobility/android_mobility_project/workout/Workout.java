package com.andoidapplicationisep.teammobility.android_mobility_project.workout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.andoidapplicationisep.teammobility.android_mobility_project.Globals;
import com.andoidapplicationisep.teammobility.android_mobility_project.MainActivity;
import com.andoidapplicationisep.teammobility.android_mobility_project.R;

/**
 * Created by Guigui on 08/12/2015.
 */
    public class Workout extends AppCompatActivity {

    TextView latitude;
    TextView longitude;
    String lat = "0";
    String lon = "0";

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.workout);

            latitude = (TextView)findViewById(R.id.latitude);
            longitude = (TextView)findViewById(R.id.longitude);

            Log.d("", "" + Globals.latitude);
            Log.d("",""+Globals.longitude);
            lat = Float.toString(Globals.latitude);
            lon=Float.toString(Globals.longitude);
            latitude.setText(lat);
            longitude.setText(lon);
        }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //demande d'envoie des messages

            Intent intent = new Intent(Workout.this, MainActivity.class);
            //l'intent sert à passer des données entre les classes
            startActivity(intent);
            //on ferme l'activité
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    }
