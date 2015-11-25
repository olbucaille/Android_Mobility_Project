package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by apple on 03/11/2015.
 */
public class Profile extends AppCompatActivity {
    ViewPager viewPager;
    CoachContentView mAdapter;
    ArrayList<Coach> coachList = new ArrayList<Coach>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        coachList.clear();
        Resources res = getResources();
        coachList.add(new Coach(R.drawable.comics_batman_icon, "Le Batman", res.getString(R.string.description_batman)));
        coachList.add(new Coach(R.drawable.comics_batman_joker_icon, "Le Joker", res.getString(R.string.description_Joker)));
        coachList.add(new Coach(R.drawable.comics_captain_america_icon, "Captain America", res.getString(R.string.description_captain_america)));
        coachList.add(new Coach(R.drawable.comics_ironman_red_icon, "Iron Man", res.getString(R.string.description_iron_man)));
        coachList.add(new Coach(R.drawable.comics_magneto_icon, "Magneto", res.getString(R.string.description_magneto)));
        coachList.add(new Coach(R.drawable.comics_spiderwoman_icon, "Spider Woman", res.getString(R.string.description_spider_woman)));
        coachList.add(new Coach(R.drawable.comics_thor_icon, "Thor", res.getString(R.string.description_thor)));

        fragmentIHM();

        Button disconnect = (Button) findViewById(R.id.disconnect);

        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,Index.class);
                //l'intent sert à passer des données entre les classes
                startActivity(intent);
                //on ferme l'activité
                finish();
            }
        });
    }

    public void fragmentIHM(){
        // Initialization
        viewPager = (ViewPager) findViewById(R.id.pager);
        //cr�ation des vues avec la class ContentView
        mAdapter = new CoachContentView(getSupportFragmentManager(), coachList);
        viewPager.setAdapter(mAdapter);

        //action sur le changement de page
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // TODO Auto-generated method stub
            }
        });

    }

    /**************************************************************************************
     * 								event sur la touche retour
     ***************************************************************************************/
    // On arrete la demande d'envoie de message lorsqu'on clique sur retour
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            //demande d'envoie des messages

            Intent intent = new Intent(Profile.this,MainActivity.class);
            //l'intent sert à passer des données entre les classes
            startActivity(intent);
            //on ferme l'activité
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }


}



