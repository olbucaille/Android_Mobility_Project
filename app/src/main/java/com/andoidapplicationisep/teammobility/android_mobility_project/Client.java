package com.andoidapplicationisep.teammobility.android_mobility_project;

/**
 * Created by apple on 24/11/2015.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    static final int port = 4242;
    private static PrintWriter pred;
    private static BufferedReader plec;
    private static Socket socket;

    final public static int GIVENAME = 1;
    final public static int GIVEACTIVITY = 2;
    final public static int GIVEHB = 3;
    static DateFormat dateFormatActivity= new SimpleDateFormat("dd/MM/yyyy");
    static DateFormat dateFormatHB = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");


    public Client() {
        try {
            Socket socket = new Socket("77.130.42.41", port);
            System.out.println("SOCKET = " + socket);

            plec = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            pred = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())),
                    true);

            Globals.clientStatus = Globals.CONNECTED;
        }catch (Exception ex){

            Log.d("client",""+ ex);     // message de terminaison
            //pred.println("END") ;

        }
    }

    synchronized public static void send(String userName,String userID,String activityID,int distance,int HB ,int type){
        String str="";
        String date= "";
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy-hh:mm:ss");

        String strRead="";

         switch (type){
             case GIVENAME:
                 str = "GIVENAME_"+userName+"_"+userID;
                 break;

             case GIVEACTIVITY:
                 date= dateFormatActivity.format(new Date());
                 str = "GIVEACTIVITY_"+userID+"_"+activityID+"_"+date+"_"+distance;
                 break;

             case GIVEHB:
                 date = dateFormatHB.format(new Date());
                 str = "GIVEHB_"+activityID+"_"+HB+"_"+date;
                 break;
        }

        if (pred != null){
            pred.println(str);
        }
                  // envoi d'un message

        /*try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*try {
            strRead = plec.readLine();  // lecture de l'Ècho
            Log.d("client",strRead);
        }catch (IOException ex){
            Log.d("client",""+ex);     // message de terminaison
            pred.println("END") ;
            try{
                plec.close();
                pred.close();
                socket.close();
            }catch (IOException e){
                Log.d("client",""+ e);
            }
        }*/
    }
}