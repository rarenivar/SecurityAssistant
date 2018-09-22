package com.rarenivar.securityassistant.data.repository;

import android.app.Application;

import com.rarenivar.securityassistant.data.dao.DecisionRuleDao;
import com.rarenivar.securityassistant.data.database.DecisionRulesDatabase;
import com.rarenivar.securityassistant.data.entity.DecisionRule;

import java.util.List;

public class DecisionRulesRepository {

    private DecisionRuleDao decisionRuleDao;

    // Note that in order to unit test the DecisionRuleRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    public DecisionRulesRepository(Application application) {
        DecisionRulesDatabase db = DecisionRulesDatabase.getDatabase(application);
        decisionRuleDao = db.decisionRulesDao();
    }

    public List<DecisionRule> getMatchingDecisionRules(List<String> permissions) {
        return decisionRuleDao.getDecisionRulesMatching(permissions);
    }

}
