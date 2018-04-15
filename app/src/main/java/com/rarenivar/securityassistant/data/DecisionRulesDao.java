package com.rarenivar.securityassistant.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DecisionRulesDao {

    @Query("select * from DecisionRules")
    List<DecisionRules> getAllDecisionRules();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllDecisionRules(List<DecisionRules> decisionRuleList);

}

