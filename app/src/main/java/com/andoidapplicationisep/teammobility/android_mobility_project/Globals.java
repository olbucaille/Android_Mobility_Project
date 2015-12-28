package com.andoidapplicationisep.teammobility.android_mobility_project;

import com.andoidapplicationisep.teammobility.android_mobility_project.Client;

/**
 * Created by apple on 24/11/2015.
 */
public class Globals {

    // partie client
    static Client client;
    static int clientStatus ;

    final static int CONNECTED = 1;
    final static int DISCONNECTED = 0;

    //selection coach ;

    static int currentCoach ;

    public static int gpsStatus;
    private static float latitude;
    private static float longitude;

    public static synchronized float getlatitude(){
        return latitude;
    }
    public static synchronized float getlongitude(){
        return longitude;
    }
    public static synchronized void setlatitude(float lat){
        latitude=lat;
    }
    public static synchronized  void setlongitude(float lon){
        longitude=lon;
    }
}
