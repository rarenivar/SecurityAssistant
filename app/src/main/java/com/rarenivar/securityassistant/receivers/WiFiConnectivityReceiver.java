package com.rarenivar.securityassistant.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.util.WiFiUtil;


public class WiFiConnectivityReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean shouldDisplayNotification = pref.getBoolean(context.getResources()
                .getString(R.string.settings_secured_wifis), false);
        if (shouldDisplayNotification) {
            WiFiUtil.displayNotificationIfUnsecured(context);
        }
    }

}
