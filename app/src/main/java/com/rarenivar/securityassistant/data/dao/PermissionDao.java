package com.rarenivar.securityassistant.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rarenivar.securityassistant.data.entity.Permission;

import java.util.List;

@Dao
public interface PermissionDao {

    @Query("DELETE FROM Permission")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPermissions(List<Permission> permissionList);

    @Query("SELECT * from Permission")
    LiveData<List<Permission>> getAllPermissions();

}
