package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import java.util.Date;

/**
 * Created by apple on 25/11/2015.
 */
public class HeartBeat {
    private long activityID;
    private int heartBeat;
    private String date;

    public HeartBeat(long activityID ,int heartBeat,String date){
        this.activityID = activityID;
        this.heartBeat = heartBeat;
        this.date = date;

    }


    public long getActivityID() {
        return activityID;
    }

    public void setActivityID(long activityID) {
        this.activityID = activityID;
    }

    public int getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(int heartBeat) {
        this.heartBeat = heartBeat;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
