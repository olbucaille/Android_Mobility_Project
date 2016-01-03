package com.andoidapplicationisep.teammobility.android_mobility_project;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.HeartBeat;
import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.HeartBeatDAO;
import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.Running;
import com.andoidapplicationisep.teammobility.android_mobility_project.BDD.RunningDAO;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;


/**
 * Created by apple on 04/11/2015.
 */
public class DetailsFragment extends Fragment {
    private long id;



    public DetailsFragment( Long id) {
        this.setStatId(id);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_stats_fragment, container, false);
       //afficher les statistics de la statistic séleltionné.
        ListView lv = (ListView) view.findViewById(R.id.listView1);
        ArrayList<ChartItem> list = new ArrayList<ChartItem>();
        Utils.init(getContext());

        list.add(new LineChartItem(generateDataLine(1), getContext()));


        ChartDataAdapter cda = new ChartDataAdapter(getContext(), list);
        lv.setAdapter(cda);


        return view;
    }
    public long getStatId() {
        return id;
    }

    public void setStatId(long id) {
        this.id = id;
    }


    /** adapter that supports 3 different item types */
    private class ChartDataAdapter extends ArrayAdapter<ChartItem> {

        public ChartDataAdapter(Context context, List<ChartItem> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getItem(position).getView(position, convertView, getContext());
        }

        @Override
        public int getItemViewType(int position) {
            // return the views type
            return getItem(position).getItemType();
        }

        @Override
        public int getViewTypeCount() {
            return 3; // we have 3 different item-types
        }
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        // on récupert la distance parcouru dans la base de donnée
        RunningDAO runningDAO = new RunningDAO(getActivity());
        runningDAO.open();
        Running running = runningDAO.getRunning(Long.toString(id));



        // on récupert les pulsations lié à l'activité pour les afficher
        HeartBeatDAO heartBeatDAO = new HeartBeatDAO(getActivity());
        heartBeatDAO.open();

        ArrayList<HeartBeat> hb_stockee = heartBeatDAO.getHB(Long.toString(id));
        int i = 0;
        ArrayList<String> date = new ArrayList<String>();


        for (HeartBeat hb : hb_stockee ) {
            e1.add(new Entry((int) hb.getHeartBeat(), i));
            date.add(hb.getDate());
            i++;
        }



        LineDataSet d1 = new LineDataSet(e1, "Pulsation cardiaque " + cnt + ", (1)");
        d1.setLineWidth(2.5f);
        d1.setCircleSize(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);
        d1.setValueTextColor(Color.WHITE);





        ArrayList<LineDataSet> sets = new ArrayList<LineDataSet>();
        sets.add(d1);



        LineData cd = new LineData(date, sets);
        return cd;
    }






}




