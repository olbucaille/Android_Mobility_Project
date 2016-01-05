package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.UserDAO;
import com.andoidapplicationisep.teammobility.android_mobility_project.new_view.CircleImageView;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by apple on 03/11/2015.
 */
public class Profile extends AppCompatActivity {
    ViewPager viewPager;
    CoachContentView mAdapter;
    ArrayList<Coach> coachList = new ArrayList<Coach>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile);

        /*//Methode pour afficher la photo seul

        ProfilePictureView profilePictureView = (ProfilePictureView) findViewById(R.id.imagefb);
        profilePictureView.setDrawingCacheEnabled(true);
        profilePictureView.setProfileId(AccessToken.getCurrentAccessToken().getUserId());*/


        String userid = AccessToken.getCurrentAccessToken().getUserId();

        CircleImageView circle = (CircleImageView) findViewById(R.id.image);

        TextView username = (TextView)findViewById(R.id.username);
        UserDAO userDAO = new UserDAO(this);
        userDAO.open();

        username.setText(userDAO.getFBName(AccessToken.getCurrentAccessToken().getUserId()));

        new DownloadImageTask(circle).execute("https://graph.facebook.com/" + userid + "/picture?type=large");

        coachList = Coach.getAllCaoch(getResources());

        fragmentIHM();

        Button disconnect = (Button) findViewById(R.id.disconnect);

        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disconnectFromFacebook();
                threadDisconnect.start();


            }
        });
    }

    public Thread threadDisconnect = new Thread(new Runnable() {
        @Override
        public void run() {
            while (isFacebookLoggedIn()==true) {

            }
            Intent intent = new Intent(Profile.this, Index.class);
            //l'intent sert à passer des données entre les classes

            startActivity(intent);
            //on ferme l'activité
            finish();
        }
    });

    public void disconnectFromFacebook() {

        if (AccessToken.getCurrentAccessToken() == null) {
            return; // already logged out
        }

        new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, new GraphRequest
                .Callback() {
            @Override
            public void onCompleted(GraphResponse graphResponse) {

                LoginManager.getInstance().logOut();

            }
        }).executeAsync();
    }

    public void fragmentIHM() {
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
     * event sur la touche retour
     ***************************************************************************************/
    // On arrete la demande d'envoie de message lorsqu'on clique sur retour
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //demande d'envoie des messages

            Intent intent = new Intent(Profile.this, MainActivity.class);
            //l'intent sert à passer des données entre les classes
            startActivity(intent);
            //on ferme l'activité
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean isFacebookLoggedIn(){
        return AccessToken.getCurrentAccessToken() != null;
    }

}

class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    CircleImageView image;

    public DownloadImageTask(CircleImageView bmImage) {
    this.image = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        image.setImageBitmap(result);
    }
}



