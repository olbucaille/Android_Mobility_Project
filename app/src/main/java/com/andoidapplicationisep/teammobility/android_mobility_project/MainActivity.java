package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.UserDAO;
import com.andoidapplicationisep.teammobility.android_mobility_project.workout.Workout;
import com.facebook.AccessToken;

public class MainActivity extends AppCompatActivity {

    SensorManager mSensorManager;
    Sensor mPressure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //connexion temporaire

        /*Button connect = (Button) findViewById(R.id.connect);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si l'utilisateur clique sur le bouton, on va sur la page de connexion
                //Intent intent = new Intent(MainActivity.this,);
                //l'intent sert à passer des données entre les classes
               // startActivity(intent);
                //on ferme l'activité
                finish();
            }
        })*/


        // connexion facebook et google +
        //enregistrement de la connexion pour une reconnexion auto
        ImageButton workout = (ImageButton) findViewById(R.id.workout);

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si l'utilisateur clique sur le bouton, on va sur la page de connexion
                Intent intent = new Intent(MainActivity.this, Workout.class);
                //l'intent sert à passer des données entre les classes
                startActivity(intent);
                //on ferme l'activité
                finish();
            }
        });

        ImageButton profile = (ImageButton) findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si l'utilisateur clique sur le bouton, on va sur la page de connexion
                Intent intent = new Intent(MainActivity.this,Profile.class);
                //l'intent sert à passer des données entre les classes
                startActivity(intent);
                //on ferme l'activité
                finish();
            }
        });
        ImageButton statistic = (ImageButton) findViewById(R.id.statistics);

        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si l'utilisateur clique sur le bouton, on va sur la page de connexion
                Intent intent = new Intent(MainActivity.this,Statistic.class);
                //l'intent sert à passer des données entre les classes
                startActivity(intent);
                //on ferme l'activité
                finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }
}
