package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.User;
import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.UserDAO;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.Arrays;


/**
 * Created by apple on 20/10/15.
 */
public class Index extends AppCompatActivity {
    CallbackManager callbackManager;
    boolean loggedIn;
    UserDAO userDAO;
    String username;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Globals.clientStatus = Globals.DISCONNECTED;
        ClientTask clientTask = new ClientTask();
        clientTask.execute();

        userDAO = new UserDAO(this);
        userDAO.open();

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.accueil);

        loggedIn = isFacebookLoggedIn();

        if (loggedIn ==true){
            // App code
            Intent intent = new Intent(Index.this,MainActivity.class);
            //l'intent sert à passer des données entre les classes
            startActivity(intent);
            //on ferme l'activité
            finish();
        }

        initGpsLocation();

        // Initialize the SDK before executing any other operations,
        // especially, if you're using Facebook UI elements.
        //connexion temporaire

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile, user_birthday,user_photos"));


        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object,GraphResponse response) {
                                try {
                                    String userID= AccessToken.getCurrentAccessToken().getUserId();
                                    User user = new User();
                                    //on récupert le pseudo utilisateur
                                    username=object.getString("name");
                                    user.setName(username);
                                    user.setFbId(userID);
                                    user.setSelectedCoachId("1");// on met le coach 1 par defaut
                                    userDAO.ajouterIfNotExist(user);


                                    userDAO.getSelectedCaoch(userID);

                                    Globals.client.send(userDAO.getFBName(userID), userID, "", 0, 0, Client.GIVENAME);

                                } catch(JSONException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
















                Intent intent = new Intent(Index.this,MainActivity.class);
                //l'intent sert à passer des données entre les classes
                startActivity(intent);
                //on ferme l'activité
                finish();





            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
        Button connect = (Button) findViewById(R.id.connect);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loggedIn = isFacebookLoggedIn();

                if (loggedIn ==true){
                    // App code
                    Intent intent = new Intent(Index.this,MainActivity.class);
                    //l'intent sert à passer des données entre les classes
                    startActivity(intent);
                    //on ferme l'activité
                    finish();
                }
            }
        });

        // connexion facebook et google +
        //enregistrement de la connexion pour une reconnexion auto


    }



    /**************************************************************************************
     * 									GPS LOCATION
     ***************************************************************************************/

    public void initGpsLocation(){
        // Get the location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Globals.gpsStatus=LocationProvider.OUT_OF_SERVICE;
        LocationListener gpsListener = new LocationListener(){

            @Override
            public void onLocationChanged(Location loc) {
                // TODO Auto-generated method stub
                float lat = (float) (loc.getLatitude());
                float lng = (float) (loc.getLongitude());
                Globals.setlatitude(lat);
                Globals.setlongitude(lng);

            }

            @Override
            public void onProviderDisabled(String arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(), "GPS desactive " ,
                        Toast.LENGTH_SHORT).show();
                Globals.setlatitude(0);
                Globals.setlongitude(0);

            }

            @Override
            public void onProviderEnabled(String arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(), "GPS activ� " ,
                        Toast.LENGTH_SHORT).show();
                int oldGpsStatus =Globals.gpsStatus;
                Globals.gpsStatus= LocationProvider.OUT_OF_SERVICE;
            }

            @Override
            public void onStatusChanged(String arg0, int status, Bundle arg2) {
                // TODO Auto-generated method stub

            }
        };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, gpsListener);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        // Initialize the location fields
        if (location != null) {
            gpsListener.onLocationChanged(location);
        } else {
            Globals.setlatitude(0);
            Globals.setlongitude(0);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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


    public boolean isFacebookLoggedIn(){
        return AccessToken.getCurrentAccessToken() != null;
    }


    private class ClientTask extends AsyncTask<Void, Integer, Void> {
        protected Void doInBackground(Void ... arg0) {
            Globals.client =  new Client();

            return null;
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(Long result) {

        }
    }
}


