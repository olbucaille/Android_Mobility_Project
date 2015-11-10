package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by apple on 04/11/2015.
 */
public class HistoryStatsFragment extends Fragment {

    static ArrayList<Stats> statsArrayList = new ArrayList<Stats>();


    public HistoryStatsFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_stats_fragment, container, false);
        statsArrayList.clear();
        for (int i = 0; i < 5; i++) {

            // adding HashList to ArrayList
            statsArrayList.add(new Stats());
        }

        ListView listView = (ListView) view.findViewById(R.id.list);

        // Getting adapter by passing xml data ArrayList
        ListViewAdapter adapter = new ListViewAdapter(this.getContext(), statsArrayList);
        listView.setAdapter(adapter);

        // Click event for single list row
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view,
                                    int position, long id) {
                Statistic.goOnDetailsFragment();
            }
        });



        return view;
    }


}
