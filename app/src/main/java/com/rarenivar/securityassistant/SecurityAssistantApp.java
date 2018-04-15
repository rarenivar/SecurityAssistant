//package com.rarenivar.securityassistant;
//
//import android.app.Application;
//
//import com.rarenivar.securityassistant.data.AppExecutors;
//import com.rarenivar.securityassistant.data.DecisionRules;
//import com.rarenivar.securityassistant.data.DecisionRulesDatabase;
//
//public class SecurityAssistantApp extends Application{
//
//    private AppExecutors appExecutors;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        appExecutors = new AppExecutors();
//    }
//
//    public DecisionRulesDatabase getDatabase() {
//        return DecisionRulesDatabase.getInstance(this, appExecutors);
//    }
//
//}
