package com.rarenivar.securityassistant.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rarenivar.securityassistant.data.entity.PermissionIncludedXref;

import java.util.List;

@Dao
public interface PermissionIncludedXrefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPermissionsIncludedXref(List<PermissionIncludedXref> permissionIncludedXrefList);

    @Query("DELETE FROM PermissionIncludedXref")
    void deleteAll();
}
