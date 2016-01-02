package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import java.util.Date;

/**
 * Created by apple on 25/11/2015.
 */
public class HeartBeat {
    private long activityID;
    private int heartBeat;
    private Date date;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
