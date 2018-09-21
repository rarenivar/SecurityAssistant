package com.rarenivar.securityassistant.models;

import java.util.ArrayList;

public class ScanObj {

    private String appName;
    private String[] permissions;

    public ScanObj(String appName, String[] permissions)
    {
        this.appName = appName;
        this.permissions = permissions;
    }

    public String getAppName() {
        return appName;
    }
    public String[] getPermissions() {
        if (permissions == null)
        {
            return new String[0];
        }
        else {
            return permissions;
        }
    }
}
