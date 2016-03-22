package com.example.stickman.golfbegginings.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


public class Message {

    public static void message(Context context, String message){

        Toast.makeText(context,"Success MESSAGE CLASS "+ message,Toast.LENGTH_LONG).show();
        Log.d("LOGCAT ","Success");
    }

    public static void messagefail(Context context, String message){

        Toast.makeText(context,"Fail MESSAGE CLASS "+message,Toast.LENGTH_LONG).show();
        System.out.println(message+" FAIL ");
    }
}
