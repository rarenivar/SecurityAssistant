package com.rarenivar.securityassistant.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

@Dao
public interface PermissionsExcludedXrefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPermissionsExcludedXref(List<PermissionsExcludedXref> permissionsExcludedXrefList);

}
