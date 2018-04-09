package com.rarenivar.securityassistant.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.views.MainActivity;

import static android.net.wifi.WifiConfiguration.KeyMgmt.NONE;


public class WiFiUtil {

    private static final String TAG = "WiFiUtil";

    /**
     * Determines if the WifiiConfiguration object represents a secured connection
     * @param wifiConfiguration
     * @return TRUE if the connection is secured, FALSE otherwise
     */
    private static boolean isWiFiSecured(WifiConfiguration wifiConfiguration) {
        // There is no key management scheme
        // TODO: finish implementation
        if (wifiConfiguration.allowedKeyManagement.get(NONE)) {
            return false;
        } else {
            return true;
        }
    }

    public static void displayNotificationIfUnsecured(Context context) {
        WifiConfiguration activeWifi = null;
        WifiManager wifiManager = (WifiManager)context.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        // Need to check if the WiFi is enabled, otherwise if user disables the WiFi the app crashes
        if (wifiManager.isWifiEnabled()) {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            if (wifiInfo != null) {
                for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                    if (wifiConfiguration.status == WifiConfiguration.Status.CURRENT) {
                        activeWifi = wifiConfiguration;
                        break;
                    }
                }
                if (activeWifi != null && !isWiFiSecured(activeWifi)) {
                        displayNotification(context);
                }
            }
        }
    }

    private static void displayNotification(Context context) {
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), 0);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                        .setContentTitle(context.getString(R.string.notification_unsecured_wifi_title))
                        .setContentText(context.getString(R.string.notification_unsecured_wifi_msg));
        // Lollipop requires a white logo withh transparency
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        } else {
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        }
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        mBuilder.setSound(alarmSound);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }
}