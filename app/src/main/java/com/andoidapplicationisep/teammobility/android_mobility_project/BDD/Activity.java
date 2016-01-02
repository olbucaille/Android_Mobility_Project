package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import java.util.Date;

/**
 * Created by apple on 25/11/2015.
 */
public class Activity {
    static public final int TYPE_HEARTBEAT = 1;
    static public final int TYPE_RUNNING = 2;

    private long id ;
    private String userFbID;
    private int type ;
    private String begin;
    private String end;


    public Activity(){
    }

    public Activity(String userFbID,int type ,String begin, String end){
        this.userFbID = userFbID;
        this.type = type;
        this.begin = begin;
        this.end = end;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUserFbID() {
        return userFbID;
    }

    public void setUserFbID(String userFbID) {
        this.userFbID = userFbID;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
