package com.rarenivar.securityassistant.data;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Database(entities = {
                        DecisionRules.class,
                        Permissions.class,
                        PermissionsIncludedXref.class,
                        PermissionsExcludedXref.class
                     },
          version = 1)
public abstract class DecisionRulesDatabase extends RoomDatabase {

    private final static String DATABASE_NAME = "decisionrulesdb";

    private final MutableLiveData<Boolean> isDatabaseCreated = new MutableLiveData<>();

    private static DecisionRulesDatabase INSTANCE;

    public abstract DecisionRulesDao decisionRulesDao();

    public abstract PermissionsDao permissionsDao();

    public abstract PermissionsIncludedXrefDao permissionsIncludedXrefDao();

    public abstract PermissionsExcludedXrefDao permissionsExcludedXrefDao();

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
            new PopulateDbAsync(INSTANCE).execute();
        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PermissionsDao permissionsDao;

        PopulateDbAsync(DecisionRulesDatabase db) {
            permissionsDao = db.permissionsDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            //permissionsDao.deleteAll();

            Permissions permission = new Permissions(3, "Hello1");
            Permissions permission2 = new Permissions(4, "Hello2");
            Permissions permission3 = new Permissions(5, "Hello3");
            Permissions permission4 = new Permissions(6, "Hello4");
            List<Permissions> permissionsList = new ArrayList<>();
            permissionsList.add(permission);
            permissionsList.add(permission2);
            permissionsList.add(permission3);
            permissionsList.add(permission4);
            //permissionsDao.insertPermission(permission);
            permissionsDao.insertAllPermissions(permissionsList);
            return null;
        }
    }

}