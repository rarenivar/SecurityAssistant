package com.rarenivar.securityassistant.models;

import java.util.ArrayList;


public class AppPackageInfo {

    private String name;
    private ArrayList<String> permissions;

    public AppPackageInfo(String name, ArrayList<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }
}
