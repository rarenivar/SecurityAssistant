package com.rarenivar.securityassistant.models;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

public class AppScan {

    private PackageManager packageManager;
    private Context context;
    private ArrayList<ScanObj> scanObjs;
    private ArrayList<PackageInfo> appList = new ArrayList<>();

    public AppScan(Context context) {
        this.context = context;
        this.packageManager = context.getPackageManager();
        getUserApps();
    }

    private void getUserApps() {
        List<PackageInfo> appsInstalled =
                packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);
        for (PackageInfo packageInfo : appsInstalled) {
            try {
                ApplicationInfo applicationInfo =
                        packageManager.getApplicationInfo(packageInfo.packageName, 0);
                if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                    // Not a system package
                    appList.add(packageInfo);
                }
            }
            catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        scanObjs = new ArrayList<>();
        for(PackageInfo packageInfo : appList) {
            String appName = getApplicationName(packageInfo, context);
            String[] permissions = getRequestedPermissions(packageInfo);
            scanObjs.add(new ScanObj(appName, permissions));
        }
    }

    public ArrayList<ScanObj> getScanObjs() {
        return scanObjs;
    }

    private static String[] getRequestedPermissions(PackageInfo packageInfo) {
        if (packageInfo.requestedPermissions != null) {
            return packageInfo.requestedPermissions;
        }
        return null;
    }

    private static String getApplicationName(PackageInfo packageInfo, Context context) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(packageInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        return (applicationInfo != null) ?
                (String) context.getPackageManager().getApplicationLabel(applicationInfo) : "UNKNOWN";
    }

}
