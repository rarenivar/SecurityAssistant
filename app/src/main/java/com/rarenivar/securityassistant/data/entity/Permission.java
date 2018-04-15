package com.rarenivar.securityassistant.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Permission")
public class Permission {

    public Permission(int _id, String name) {
        this._id = _id;
        this.name = name;
    }

    @PrimaryKey
    private int _id;

    @ColumnInfo(name = "name")
    private String name;

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
