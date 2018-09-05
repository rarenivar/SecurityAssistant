package com.rarenivar.securityassistant.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rarenivar.securityassistant.data.entity.DecisionRule;
import com.rarenivar.securityassistant.data.entity.Permission;

import java.util.List;

@Dao
public interface DecisionRuleDao {

    @Query (
        "select distinct z.* "+
        "from DecisionRule as z "+
        "join ( "+
            "select dr._id as Decision_Rule_ID, count(*) as Num_Permissions_Required "+
            "from DecisionRule dr "+
            "join PermissionIncludedXref "+
            "on PermissionIncludedXref.decisionRuleID = dr._id "+
            "join Permission "+
            "on Permission._id = PermissionIncludedXref.PermissionID "+
            "group by dr._id "+
        ") as a on a.Decision_Rule_ID = z._id "+
        "join ( "+
            "select PermissionIncludedXref.decisionRuleID, count(*) as Matched_Permissions "+
            "from PermissionIncludedXref "+
            "where PermissionIncludedXref.permissionID in "+
            "( "+
                "select Permission._id "+
                "from Permission "+
                "where Permission.name in (:permissions) "+
            ") "+
            "group by PermissionIncludedXref.decisionRuleID "+
        ") as b on b.decisionRuleID = a.Decision_Rule_ID and a.Num_Permissions_Required <= b.Matched_Permissions "+
        "where b.decisionRuleID not in ( "+
            "select distinct PermissionExcludedXref.decisionRuleID "+
            "from PermissionExcludedXref "+
            "where PermissionExcludedXref.permissionID in "+
            "( "+
                "select Permission._id "+
                "from Permission "+
                "where Permission.name in (:permissions) "+
            ") "+
            ") "
    )
    List<DecisionRule> getDecisionRulesMatching(List<String> permissions);

    @Query("select * from DecisionRule")
    LiveData<List<DecisionRule>> getAllDecisionRules();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllDecisionRules(List<DecisionRule> decisionRuleList);

    @Query("DELETE FROM DecisionRule")
    void deleteAll();
}

