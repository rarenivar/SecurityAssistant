package com.rarenivar.securityassistant.data.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.rarenivar.securityassistant.data.DataGenerator;
import com.rarenivar.securityassistant.data.dao.DecisionRuleDao;
import com.rarenivar.securityassistant.data.dao.PermissionDao;
import com.rarenivar.securityassistant.data.dao.PermissionExcludedXrefDao;
import com.rarenivar.securityassistant.data.dao.PermissionIncludedXrefDao;
import com.rarenivar.securityassistant.data.entity.DecisionRule;
import com.rarenivar.securityassistant.data.entity.Permission;
import com.rarenivar.securityassistant.data.entity.PermissionExcludedXref;
import com.rarenivar.securityassistant.data.entity.PermissionIncludedXref;

import java.util.List;

@Database(entities = {
                        DecisionRule.class,
                        Permission.class,
                        PermissionIncludedXref.class,
                        PermissionExcludedXref.class
                     },
          version = 6)
public abstract class DecisionRulesDatabase extends RoomDatabase {

    private final static String DATABASE_NAME = "decisionrulesdb";

    private static DecisionRulesDatabase INSTANCE;

    public abstract DecisionRuleDao decisionRulesDao();
    public abstract PermissionDao permissionsDao();
    public abstract PermissionIncludedXrefDao permissionsIncludedXrefDao();
    public abstract PermissionExcludedXrefDao permissionsExcludedXrefDao();

    public static DecisionRulesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DecisionRulesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DecisionRulesDatabase.class, DATABASE_NAME)
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            //new PopulateDbAsync(INSTANCE).execute();
        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // Populate database on creation
            new PopulateDbAsync(INSTANCE).execute();

        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PermissionDao permissionDao;
        private final DecisionRuleDao decisionRuleDao;
        private final PermissionExcludedXrefDao permissionExcludedXrefDao;
        private final PermissionIncludedXrefDao permissionIncludedXrefDao;

        PopulateDbAsync(DecisionRulesDatabase db) {

            permissionDao = db.permissionsDao();
            decisionRuleDao = db.decisionRulesDao();
            permissionExcludedXrefDao = db.permissionsExcludedXrefDao();
            permissionIncludedXrefDao = db.permissionsIncludedXrefDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            List<Permission> permissionList = DataGenerator.generatePermissions();
            permissionDao.insertAllPermissions(permissionList);

            List<DecisionRule> decisionRuleList = DataGenerator.generateDecisionRules();
            decisionRuleDao.insertAllDecisionRules(decisionRuleList);

            List<PermissionExcludedXref> permissionExcludedXrefList = DataGenerator.generatePermissionsExcludedXref();
            permissionExcludedXrefDao.insertAllPermissionsExcludedXref(permissionExcludedXrefList);

            List<PermissionIncludedXref> permissionIncludedXrefDaoList = DataGenerator.generatePermissionsIncludedXref();
            permissionIncludedXrefDao.insertAllPermissionsIncludedXref(permissionIncludedXrefDaoList);

            return null;
        }
    }

}