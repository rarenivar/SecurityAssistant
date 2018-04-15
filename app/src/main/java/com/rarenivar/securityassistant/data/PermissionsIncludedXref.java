package com.rarenivar.securityassistant.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "PermissionsIncludedXref")
public class PermissionsIncludedXref {

    @PrimaryKey
    private int _id;

    @ColumnInfo(name = "decisionRuleID")
    private int decisionRuleID;

    @ColumnInfo(name = "permissionID")
    private int permissionID;

    public int get_id() {
        return _id;
    }

    public int getDecisionRuleID() {
        return decisionRuleID;
    }

    public int getPermissionID() {
        return permissionID;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setDecisionRuleID(int decisionRuleID) {
        this.decisionRuleID = decisionRuleID;
    }

    public void setPermissionID(int permissionID) {
        this.permissionID = permissionID;
    }

}
