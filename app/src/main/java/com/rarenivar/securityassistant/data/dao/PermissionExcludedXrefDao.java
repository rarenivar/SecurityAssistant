package com.rarenivar.securityassistant.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rarenivar.securityassistant.data.entity.PermissionExcludedXref;

import java.util.List;

@Dao
public interface PermissionExcludedXrefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPermissionsExcludedXref(List<PermissionExcludedXref> permissionsExcludedXrefList);

    @Query("DELETE FROM PermissionExcludedXref")
    void deleteAll();
}
