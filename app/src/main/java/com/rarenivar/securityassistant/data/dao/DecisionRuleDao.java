package com.rarenivar.securityassistant.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rarenivar.securityassistant.data.entity.DecisionRule;

import java.util.List;

@Dao
public interface DecisionRuleDao {

    @Query("select * from DecisionRule")
    List<DecisionRule> getAllDecisionRules();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllDecisionRules(List<DecisionRule> decisionRuleList);

}

