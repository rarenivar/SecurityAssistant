package com.rarenivar.securityassistant.data.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.database.Observable;
import android.os.AsyncTask;

import com.rarenivar.securityassistant.data.dao.DecisionRuleDao;
import com.rarenivar.securityassistant.data.dao.PermissionDao;
import com.rarenivar.securityassistant.data.database.DecisionRulesDatabase;
import com.rarenivar.securityassistant.data.entity.DecisionRule;
import com.rarenivar.securityassistant.data.entity.Permission;

import java.util.List;

public class DecisionRulesRepository {

    private DecisionRuleDao decisionRuleDao;
    private PermissionDao permissionDao;
    private LiveData<List<DecisionRule>> decisions;
    private LiveData<List<Permission>> permissions;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public DecisionRulesRepository(Application application) {
        DecisionRulesDatabase db = DecisionRulesDatabase.getDatabase(application);
        permissionDao = db.permissionsDao();
        permissions = permissionDao.getAllPermissions();
        decisionRuleDao = db.decisionRulesDao();
        decisions = decisionRuleDao.getAllDecisionRules();
        int a = 3;
    }

//    public List<DecisionRule> getMatchingDecisionRules(List<String> permissions) {
//        return decisionRuleDao.getDecisionRulesMatching(permissions);
//    }

    public LiveData<List<Permission>> getAllPermissions() {
        return permissions;
    }

    public LiveData<List<DecisionRule>> getAllDecisions() {
        return decisions;
    }

//    public void getMachingDecisionRules(List<String> permissions) {
//        new matchPermissionsAsyncTask(decisionRuleDao).execute(permissions);
//    }


//    private class matchPermissionsAsyncTask extends AsyncTask<List<String>, Void, List<DecisionRule>> {
//
//        private DecisionRuleDao asyncDecisionRuleDaoTask;
//
//        matchPermissionsAsyncTask(DecisionRuleDao dao) {
//            asyncDecisionRuleDaoTask = dao;
//        }
//
//        @Override
//        protected List<DecisionRule> doInBackground(List<String>... permissions) {
//           //asyncDecisionRuleDaoTask.getAllDecisionRules();
//           return asyncDecisionRuleDaoTask.getDecisionRulesMatching(permissions[0]);
//           //return null;
//        }
//
//        @Override
//        protected void onPostExecute(List<DecisionRule> result) {
//            decisionRules.setValue(result);
//            //super.onPostExecute(result);
//            //int a = 3;
//        }
//    }

}
