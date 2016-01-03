package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static java.util.Collections.*;

/**
 * Created by apple on 05/11/2015.
 */
public class ListViewAdapter extends BaseAdapter{

private static ArrayList <com.andoidapplicationisep.teammobility.android_mobility_project.BDD.Activity> activityArrayList ;
private LayoutInflater mInflater;

        public ListViewAdapter (Context context,ArrayList <com.andoidapplicationisep.teammobility.android_mobility_project.BDD.Activity> activityArrayList){
            this.activityArrayList = activityArrayList;
            //sort(activityArrayList);
            mInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return activityArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return activityArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            // TODO Auto-generated method stub

            String groups="";

            view = mInflater.inflate(R.layout.list_item, null);
            TextView title = (TextView)view.findViewById(R.id.title); // title
            //TextView artist = (TextView)view.findViewById(R.id.artist); // artist name
            TextView duration = (TextView)view.findViewById(R.id.duration); // duration
            TextView begin = (TextView)view.findViewById(R.id.begin); // duration
            ImageView thumb_image=(ImageView)view.findViewById(R.id.list_image);
            begin.setText("Jour : "+activityArrayList.get(position).getBegin());
            duration.setText("Durée : "+activityArrayList.get(position).getEnd());
            // On applique la valeur recuperer dans la IHMList pour l'afficher dans la listView
           // holder.txtName.setText(ihmList.get(position).ihmName);
            //holder.txtAccess.setText(ihmList.get(position).rights);


            return view;
        }





}