package com.rarenivar.securityassistant.util;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.os.Build;
import android.widget.Toast;

import static android.net.wifi.WifiConfiguration.KeyMgmt.NONE;

/**
 * Created by ramiro on 11/23/17.
 */

public class Util {

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Determines if the WifiiConfiguration object represents a secured connection
     * @param wifiConfiguration
     * @return TRUE if the connection is secured, FALSE otherwise
     */
    public static boolean isWiFiSecured(WifiConfiguration wifiConfiguration) {

        // There is no key management scheme
        if (wifiConfiguration.allowedKeyManagement.get(NONE)) {
            return false;
        } else {
            return true;
        }
        // TODO: this is crashing the app....
//        if (wifiConfiguration.allowedKeyManagement.get(WPA_EAP) ||
//                wifiConfiguration.allowedKeyManagement.get(IEEE8021X) ||
//                wifiConfiguration.allowedKeyManagement.get(WPA_PSK)) {
//            return true;
//        }
//        return false;
    }

    public static String getAndroidVersion() {
        String osVersion = Build.VERSION.RELEASE;
        String androidName;
        switch(Build.VERSION.SDK_INT) {
            case(Build.VERSION_CODES.KITKAT):
                androidName = "KitKat";
                break;
            case(Build.VERSION_CODES.LOLLIPOP):
                androidName = "Lollipop";
                break;
            case(Build.VERSION_CODES.LOLLIPOP_MR1):
                androidName = "Lollipop";
                break;
            case(Build.VERSION_CODES.M):
                androidName = "Marshmallow";
                break;
            case(Build.VERSION_CODES.N_MR1):
                androidName = "Marshmallow";
                break;
            case(Build.VERSION_CODES.N):
                androidName = "Nougat";
                break;
            default:
                androidName = "Unknown";
                break;
        }
        return osVersion + " (" + androidName + ")";
    }

    public enum EncryptionStatus {
        Inactive,
        Unsupported,
        Active
    }
}

