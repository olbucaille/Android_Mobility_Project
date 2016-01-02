package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

/**
 * Created by apple on 25/11/2015.
 */
public class Running {
    private long activityID;
    private String distance;

    public Running (long activityID,String distance){
        this.activityID= activityID;
        this.distance=distance;
    }
    public Running (){

    }


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public long getActivityID() {
        return activityID;
    }

    public void setActivityID(long activityID) {
        this.activityID = activityID;
    }
}
