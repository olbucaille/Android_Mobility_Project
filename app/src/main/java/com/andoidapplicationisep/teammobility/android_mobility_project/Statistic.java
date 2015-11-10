package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by apple on 03/11/2015.
 */
public class Statistic  extends FragmentActivity {
    static int id;
    static FragmentManager myFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);
        id = 0;
        myFragmentManager = getSupportFragmentManager();
        myFragmentManager.beginTransaction()
                .add(R.id.stats_container, new HistoryStatsFragment())
                .commit();

    }


    public static void goOnDetailsFragment(){
        id=1;
        myFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right)
                .replace(R.id.stats_container, new DetailsFragment())
                .commit();
    }
    public static void goOnHistoryFragment(){
        id=0;
        myFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_left)
                .replace(R.id.stats_container, new HistoryStatsFragment())
                .commit();
    }
    /**************************************************************************************
     * 								event sur la touche retour
     ***************************************************************************************/
    // On arrete la demande d'envoie de message lorsqu'on clique sur retour
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){

            //demande d'envoie des messages
            if (id==0){
                Intent intent = new Intent(Statistic.this,MainActivity.class);
                //l'intent sert à passer des données entre les classes
                startActivity(intent);
                //on ferme l'activité
                finish();
            }else if (id==1){
                goOnHistoryFragment();
            }
        }
        return true;
    }

}
