package com.rarenivar.securityassistant.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

@Dao
public interface PermissionsIncludedXrefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPermissionsIncludedXref(List<PermissionsIncludedXref> permissionsIncludedXrefList);

}
