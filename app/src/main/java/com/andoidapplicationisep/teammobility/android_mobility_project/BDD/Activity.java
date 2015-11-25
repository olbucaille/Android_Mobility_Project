package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

import java.util.Date;

/**
 * Created by apple on 25/11/2015.
 */
public class Activity {
    static final int TYPE_HEARTBEAT = 1;
    static final int TYPE_RUNNING = 2;

    private long id ;
    private long userFbID;
    private int type ;
    private Date begin;
    private Date end;


    public Activity(){

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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public long getUserFbID() {
        return userFbID;
    }

    public void setUserFbID(long userFbID) {
        this.userFbID = userFbID;
    }
}
