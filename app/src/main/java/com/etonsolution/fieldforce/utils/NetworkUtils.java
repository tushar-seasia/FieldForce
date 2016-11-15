package com.etonsolution.fieldforce.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.etonsolution.fieldforce.R;

/**
 * Created by BawejaTushar on 11/15/2016.
 */

public class NetworkUtils {
    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (null != networkInfo) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;

        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context){
        int connection=NetworkUtils.getConnectivityStatus(context);
        String status=null;
        if(connection==NetworkUtils.TYPE_WIFI){
            status=context.getResources().getString(R.string.connection_wifi);
        }else if(connection==NetworkUtils.TYPE_MOBILE){
            status=context.getResources().getString(R.string.connection_mobile);
        }else if(connection==NetworkUtils.TYPE_NOT_CONNECTED){
            status=context.getResources().getString(R.string.connection_not_connected);
        }
        return status;
    }
}
