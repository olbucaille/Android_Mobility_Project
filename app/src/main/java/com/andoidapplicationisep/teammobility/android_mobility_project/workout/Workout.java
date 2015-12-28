package com.andoidapplicationisep.teammobility.android_mobility_project.workout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


import com.andoidapplicationisep.teammobility.android_mobility_project.Globals;
import com.andoidapplicationisep.teammobility.android_mobility_project.MainActivity;
import com.andoidapplicationisep.teammobility.android_mobility_project.R;

import java.text.DecimalFormat;

/**
 * Created by Guigui on 08/12/2015.
 */
    public class Workout extends AppCompatActivity {

    boolean run = true;
    TextView latitude, longitude, time, distance;
    float lat = 0;
    float lon = 0;
    float lat_old = 0;
    float lon_old = 0;
    double dist = 0;
    int beat = 0;

    Chronometer focus;
    Button bpm, stop;

    MediaPlayer mPlayer = null;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.workout);



            lat = Globals.getlatitude();
            lon = Globals.getlongitude();

            latitude = (TextView)findViewById(R.id.latitude);
            longitude = (TextView)findViewById(R.id.longitude);
            time = (TextView)findViewById(R.id.time);
            distance = (TextView)findViewById(R.id.distance);

            bpm = (Button)findViewById(R.id.button1);
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


            bpm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    beat++;
                    buttonEffect(bpm);
                    //bpm.setText("OK" + beat);
                }
            });

            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    focus.stop();
                    //time.setText("Durée de l'entrainement : " + focus.getText());
                    alertDialog.setMessage("Durée de l'entrainement : " + focus.getText() + "\n" + distance.getText());
                    alertDialog.show();
                    mPlayer.release();
                    run = false;
                }
            });
        //ICI THIB ********//////

         /*   Use AsyncTask for:

            Simple network operations which do not require downloading a lot of data
            Disk-bound tasks that might take more than a few milliseconds


            Use Java threads for:

            Network operations which involve moderate to large amounts of data (either uploading or downloading)
            High-CPU tasks which need to be run in the background
            Any task where you want to control the CPU usage relative to the GUI thread


            Je crois qu'il est préférable d'utiliser un thred ICI, on utilisera l'asynctask just pour la communication TCP
          */
            threadUpdateHR.start();
            threadUpdateTask.start();

        }/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/


    public Thread threadUpdateHR = new Thread(new Runnable() {
        @Override
        public void run() {
            while (run) {
                Log.d("distance","toto2");
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        bpm.setText(""+beat*6);
                        beat = 0;
                        mPlayer = MediaPlayer.create(getApplicationContext(),R.raw.just_do_it);
                        mPlayer.start();
                    }
                });
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mPlayer.release();
            }
        }
    });

    public Thread threadUpdateTask = new Thread(new Runnable() {
        @Override
        public void run() {
            while (run) {
                Log.d("distance","toto");
                lat_old = lat;
                lon_old = lon;
                lat = (float) (Globals.getlatitude());
                lon = Globals.getlongitude();
                dist = dist + CalculationByDistance(lat_old, lon_old, lat, lon);
                final DecimalFormat df = new DecimalFormat("0.0");

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        latitude.setText(Float.toString(lat));
                        longitude.setText(Float.toString(lon));
                        distance.setText("Distance parcourue : " + df.format(dist) + "km");
                    }
                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

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


    public double CalculationByDistance(float lat1, float lon1,
                                        float lat2, float lon2){
        int R = 6371; // km
        double dLat = toRadians((lat2-lat1));
        double dLon = toRadians((lon2-lon1));

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    public double toRadians(double deg) {
        return deg * (Math.PI/180);
    }

    public static void buttonEffect(Button button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xffff0000, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }
}
