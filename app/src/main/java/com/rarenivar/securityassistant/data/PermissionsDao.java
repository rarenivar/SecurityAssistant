package com.rarenivar.securityassistant.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PermissionsDao {

    @Query("select * from Permissions")
    LiveData<List<Permissions>> getAllPermissions();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPermissions(List<Permissions> permissionsList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPermission(Permissions permission);

}
