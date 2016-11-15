package com.etonsolution.fieldforce.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.widget.Toast;

import com.etonsolution.fieldforce.utils.NetworkUtils;

/**
 * Created by BawejaTushar on 11/15/2016.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkUtils.getConnectivityStatusString(context);

        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
    }
}
