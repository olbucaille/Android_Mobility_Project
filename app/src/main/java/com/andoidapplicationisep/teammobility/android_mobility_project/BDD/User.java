package com.andoidapplicationisep.teammobility.android_mobility_project.BDD;

/**
 * Created by apple on 25/11/2015.
 */
public class User {
    private long id;//key
    private String fbId;
    private String name;
    private int selectedCoachId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSelectedCoachId() {
        return selectedCoachId;
    }

    public void setSelectedCoachId(int selectedCoachId) {
        this.selectedCoachId = selectedCoachId;
    }
}
