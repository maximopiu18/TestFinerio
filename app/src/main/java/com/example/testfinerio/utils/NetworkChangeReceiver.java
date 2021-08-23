package com.example.testfinerio.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkChangeReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        try
        {
            if (isOnline(context)) {
              //  dialog(true);
                Log.e("Connectividad", "Conectado a Internet");
            } else {
             //   dialog(false);
                Log.e("Connectividad", "No Conectado a Internet");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

   public boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}