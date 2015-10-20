package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by apple on 20/10/15.
 */
public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        //connexion temporaire

        Button connect = (Button) findViewById(R.id.connect);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //si l'utilisateur clique sur le bouton, on va sur la page de connexion
                Intent intent = new Intent(Index.this,MainActivity.class);
                //l'intent sert à passer des données entre les classes
                startActivity(intent);
                //on ferme l'activité
                finish();
            }
        });

        // connexion facebook et google +
        //enregistrement de la connexion pour une reconnexion auto


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }
}
