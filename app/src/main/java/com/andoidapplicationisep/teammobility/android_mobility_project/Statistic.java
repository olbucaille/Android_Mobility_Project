package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by apple on 03/11/2015.
 */
public class Statistic  extends AppCompatActivity {

    static FragmentManager myFragmentManager;
    static DetailsFragment mDetailsFragment = new DetailsFragment();
    static HistoryStatsFragment mHistoryFragment = new HistoryStatsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);
        myFragmentManager = getSupportFragmentManager();
        myFragmentManager.beginTransaction()
                .add(R.id.stats_container, new HistoryStatsFragment())
                .commit();
        }


    public static void goOnDetailsFragment(){
        myFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right)
                .replace(R.id.stats_container, new DetailsFragment())
                .commit();
    }
    public static void goOnHistoryFragment(){
        myFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_left)
                .replace(R.id.stats_container, new HistoryStatsFragment())
                .commit();
    }


    /*public static void destroyChallengeFragment(){
        if (myFragmentManager!=null ){
            CategoryFragment fragment = (CategoryFragment) myFragmentManager.findFragmentByTag(CategoryFragment.TAG);
            if (fragment != null) {
                Log.d("challenge", "destroy");
                myFragmentManager.beginTransaction()
                        .remove(mSelectorFragment)
                        .remove(mCategoryFragment)
                        .commit();
            }
        }
    }
*/

}
