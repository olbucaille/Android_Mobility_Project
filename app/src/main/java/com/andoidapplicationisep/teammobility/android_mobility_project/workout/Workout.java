package com.andoidapplicationisep.teammobility.android_mobility_project.workout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;


import com.andoidapplicationisep.teammobility.android_mobility_project.Globals;
import com.andoidapplicationisep.teammobility.android_mobility_project.MainActivity;
import com.andoidapplicationisep.teammobility.android_mobility_project.R;

/**
 * Created by Guigui on 08/12/2015.
 */
    public class Workout extends AppCompatActivity {

    TextView latitude, longitude, time;
    String lat = "0";
    String lon = "0";
    Chronometer focus;
    Button start, stop;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.workout);

            latitude = (TextView)findViewById(R.id.latitude);
            longitude = (TextView)findViewById(R.id.longitude);
            time = (TextView)findViewById(R.id.time);

            Log.d("", "" + Globals.latitude);
            Log.d("", "" + Globals.longitude);
            lat = Float.toString(Globals.latitude);
            lon=Float.toString(Globals.longitude);
            latitude.setText(lat);
            longitude.setText(lon);
            start = (Button)findViewById(R.id.button1);
            stop = (Button)findViewById(R.id.button2);

            focus = (Chronometer)findViewById(R.id.chronometer1);
            focus.start();

           final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Fin de l'entrainement");

            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Workout.this, MainActivity.class);
                    //l'intent sert à passer des données entre les classes
                    startActivity(intent);
                    //on ferme l'activité
                    finish();
                }
            });


            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    focus.start();
                }
            });

            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    focus.stop();
                    time.setText("Durée de l'entrainement : " + focus.getText());
                    alertDialog.setMessage("Durée de l'entrainement : " + focus.getText());
                    alertDialog.show();
                }
            });



        }/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
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
